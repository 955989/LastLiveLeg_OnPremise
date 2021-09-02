/**
 * @author skumar
 */

package com.aa.qlaservices;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
//import com.aa.opshub.creation.entity.Add;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aa.ccsservices.CCS_Contractual_Month;
import com.aa.entities.ResponseEntity;
import com.aa.entities.qlarequest.ActualEndDateTime;
import com.aa.entities.qlarequest.ActualStartDateTime;
import com.aa.entities.qlarequest.DutyPeriodIndicators;
import com.aa.entities.qlarequest.DutyPeriodItem;
import com.aa.entities.qlarequest.DutyPeriods;
import com.aa.entities.qlarequest.FdpEndTime;
import com.aa.entities.qlarequest.FdpStartTime;
import com.aa.entities.qlarequest.FlightDutyPeriodKey;
import com.aa.entities.qlarequest.FlightLegs;
import com.aa.entities.qlarequest.LegItem;

@Service

public class QLA_Build_DutyPeriods {

    @Autowired
    private CCS_Contractual_Month ccs;

    public DutyPeriods build_DP(final FlightLegs FL, final String pos)
            throws KeyManagementException, UnrecoverableKeyException, NoSuchFieldException, NoSuchAlgorithmException,
            KeyStoreException, CertificateException, ParseException, IOException {
    	
        final List<LegItem> LI = FL.getItems();
        final List<DutyPeriodItem> items = new ArrayList<DutyPeriodItem>();
        final DutyPeriods DP = new DutyPeriods();
        int dpno = LI.get(0).getDutyPeriod();
        boolean ind1 = false;
        String var1, contractual, date1;
        var1 = contractual = date1 = null;
        boolean loop = false;
        LocalDateTime var2, depbase, depgmt, deplocal, arrbase, arrgmt, arrlocal;
        var2 = depbase = depgmt = deplocal = arrbase = arrgmt = arrlocal = LocalDateTime
            .parse(LI.get(0).getDepartureTime().getScheduled().getBaseTime()); // initialize to
                                                                               // suppress error
        int cnt = 0;
        final ResponseEntity response = new ResponseEntity();
        for (int i = 0; i <= LI.size() - 1; i++) {

            if (dpno == LI.get(i).getDutyPeriod()) {

                if (!ind1) {
                    // 1.calculate sign-in time in local/gmt/base time.
                    var1 = LI.get(i).getDepartureTime().getScheduled().getBaseTime();
                    var2 = LocalDateTime.parse(var1);
                    depbase = var2.minusHours(1);
                    var1 = LI.get(i).getDepartureTime().getScheduled().getGmt();
                    var2 = LocalDateTime.parse(var1);
                    depgmt = var2.minusHours(1);
                    var1 = LI.get(i).getDepartureTime().getScheduled().getLocalTime();
                    var2 = LocalDateTime.parse(var1);
                    deplocal = var2.minusHours(1);
                    // ---------find contractual month------------//
                    final String Str1 = deplocal.toString();
                    final String[] arrOfStr = Str1.split("T", 2);
                    date1 = arrOfStr[0];
                    contractual = ccs.get_contractual_month(date1, response);
                    // -------------------------------------------//
                    ind1 = true;
                }
                // 2. calculate release time in gmt/base/local
                var1 = LI.get(i).getArrivalTime().getScheduled().getLocalTime();
                var2 = LocalDateTime.parse(var1);
                arrlocal = var2.plusMinutes(15);
                var1 = LI.get(i).getArrivalTime().getScheduled().getGmt();
                var2 = LocalDateTime.parse(var1);
                arrgmt = var2.plusMinutes(15);
                var1 = LI.get(i).getArrivalTime().getScheduled().getBaseTime();
                var2 = LocalDateTime.parse(var1);
                arrbase = var2.plusMinutes(15);
                cnt = cnt + 1;
            }
            if ((dpno != LI.get(i).getDutyPeriod()) || (i == LI.size() - 1)) {
                final DutyPeriodItem DPI = new DutyPeriodItem();
                // 1. update sign-in time
                final ActualStartDateTime ASD = new ActualStartDateTime();
                ASD.setBaseTime(depbase.toString());
                ASD.setGmt(depgmt.toString());
                ASD.setLocalTime(deplocal.toString());
                DPI.setActualStartDateTime(ASD);
                // 2. update release time
                final ActualEndDateTime AED = new ActualEndDateTime();
                AED.setLocalTime(arrlocal.toString());
                AED.setGmt(arrgmt.toString());
                AED.setBaseTime(arrbase.toString());
                DPI.setActualEndDateTime(AED);
                // 3.update start time in FDP
                final FdpStartTime FST = new FdpStartTime();
                FST.setBaseTime(ASD.getBaseTime());
                FST.setGmt(ASD.getGmt());
                FST.setLocalTime(ASD.getLocalTime());
                DPI.setFdpStartTime(FST);
                // 4.update end time in FDP
                final FdpEndTime FET = new FdpEndTime();
                FET.setBaseTime(AED.getBaseTime());
                FET.setGmt(AED.getGmt());
                FET.setLocalTime(AED.getLocalTime());
                DPI.setFdpEndTime(FET);
                // 5.update release time
                DPI.setScheduledEndDateTime(AED.getGmt());
                // 6.update sign-in time
                DPI.setScheduledStartDateTime(ASD.getGmt());
                // 7.update flight duty period key details
                final FlightDutyPeriodKey FDPK = new FlightDutyPeriodKey();
                FDPK.setAirlineCode("AA");
                // FDPK.setContractMonth(LI.get(i).getContractMonth());
                FDPK.setContractMonth(contractual);
                // FDPK.setDutyPeriodNumber(LI.get(i).getDutyPeriod());
                FDPK.setDutyPeriodNumber(dpno);
                // FDPK.setOriginationDate(LI.get(i).getFlightKey().getFlightOriginationDate());
                FDPK.setOriginationDate(date1);
                FDPK.setSequenceNumber(1234);
                FDPK.setPositionCode(pos);
                DPI.setFlightDutyPeriodKey(FDPK);
                // 8.update duty period status
                DPI.setDutyPeriodStatus("SCHEDULED");
                // 9.set hawaii satus
                DPI.setHawaiiDutyPeriod(false);
                // 10.update duty period indicators
                final DutyPeriodIndicators DPInd = new DutyPeriodIndicators();
                DPInd.setPilotAugmentationFour(false);
                DPInd.setPilotAugmentationThree(false);
                DPInd.setRestFacilityClass(0);
                DPI.setDutyPeriodIndicators(DPInd);
                // ---------------------------------------------------------------------------------//
                if (loop) {
                    if (cnt % 2 == 1) {
                        items.add(DPI);
                    }
                    break;
                }
                items.add(DPI);
                if (i == LI.size() - 1) {
                    loop = true;
                    if (LI.size() == 1) {
                        break;
                    }
                }
                i = i - 1;
                dpno = dpno + 1;
                ind1 = false;
                cnt = 0; // set leg counter zero
            }
        }
        DP.setItems(items);
        return DP;
    }
}
