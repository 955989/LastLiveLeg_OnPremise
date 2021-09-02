/**
 * @author skumar
 * To map CCS and QLA fields
 */

package com.aa.qlaservices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.aa.entities.SequenceDetailsEntity;
import com.aa.entities.ccsResponse.SequenceInfoKeyResponse;
import com.aa.entities.qlarequest.FlightLegs;
import com.aa.entities.qlarequest.LanguageRequirement;
import com.aa.entities.qlarequest.ProjectedData;
import com.aa.entities.qlarequest.QLARequestPayload;
import com.aa.entities.qlarequest.SeqProperties;
import com.aa.entities.qlarequest.SequenceDetail;
import com.aa.entities.qlarequest.SequenceInfoKey;
import com.aa.entities.qlarequest.SequencePayCredit;

@Service
public class CCS_QLA_SequenceDetails_Mapping {

    public List<QLARequestPayload> map_CCS_QLA_SequenceDetails(final List<SequenceInfoKeyResponse> ccsResponse,
            final SequenceDetailsEntity sd,
            final FlightLegs flightLegs, final List<QLARequestPayload> qlaPayload) {

        final ProjectedData projectedData = new ProjectedData();

        qlaPayload.get(0).setProjectedData(projectedData);

        final List<SequenceDetail> sequenceDetails = new ArrayList<SequenceDetail>();

        projectedData.setSequenceDetails(sequenceDetails);

        final SequenceDetail sequenceDet = new SequenceDetail();

        final SequenceInfoKeyResponse ccsResponseData = ccsResponse.get(0);

        sequenceDet.setAddCode(ccsResponseData.getAddCode());
        sequenceDet.setEquipmentGroups(Arrays.asList(ccsResponseData.getEquipmentGroup()));

        sequenceDet.setBase(ccsResponseData.getBase());
        sequenceDet.setCabinType(ccsResponseData.getCabinType());
        sequenceDet.setCoterminal(ccsResponseData.getIsCoterminal());
        sequenceDet.setDivisionType(ccsResponseData.getDivision());
        sequenceDet.setEndDateTime(ccsResponseData.getSequenceDutyTime());
        sequenceDet.setEndDateTimeInBaseTime(ccsResponseData.getSequenceEndDateTime().getBaseTime());
        sequenceDet.setEndDateTimeInGmt(ccsResponseData.getSequenceEndDateTime().getGmt());
        sequenceDet.setFirstLegDHD(ccsResponseData.getFirstLegDeadHeadIndicator());
        sequenceDet.setFirstLegDepAirport(ccsResponseData.getFirstLegDepartureAirport());

        sequenceDet.setFlightLegs(flightLegs); // GEt flight leg object here

        sequenceDet.setGalleyPosition(ccsResponseData.getGalleyPosition());
        sequenceDet.setInternational(ccsResponseData.getInternational());
        sequenceDet.setIpd(ccsResponseData.getIsIPD());
        sequenceDet.setLandingQuals(ccsResponseData.getLandingQuals());

        // populate language code
        final List<LanguageRequirement> languageRequirements = new ArrayList<LanguageRequirement>();

        final LanguageRequirement LangReq = new LanguageRequirement();
        LangReq.setLangCode(null);
        LangReq.setLangCount(0);

        sequenceDet.setLanguageRequirements(languageRequirements);

        //

        sequenceDet.setLastLegArrivalAirport(ccsResponseData.getLastLegArrivalAirport());
        sequenceDet.setLastLegDHD(ccsResponseData.getLastLegDeadHeadIndicator());

        sequenceDet.setNipd(ccsResponseData.isNIPD());
        sequenceDet.setOdan(ccsResponseData.getIsODAN());
        sequenceDet.setPosLangQual(null);
        sequenceDet.setPosSpeakerRestricted(ccsResponseData.getSpeakerRequirement().isPosSpeakerRestricted());
        sequenceDet.setPurser(ccsResponseData.isPurser());
        sequenceDet.setRedEye(ccsResponseData.getIsRedEye());
        sequenceDet.setSatellite(ccsResponseData.getIsSatellite());

        // Set property

        final SeqProperties seqProperties = new SeqProperties();
        seqProperties.isAdvIndicator();
        seqProperties.isCfdIndicator();

        sequenceDet.setSeqProperties(seqProperties);

        // Sequence Info key
        final SequenceInfoKey sequenceInfoKey = new SequenceInfoKey();
        sequenceInfoKey.setAirlineCode(ccsResponseData.getAirlineCode());
        sequenceInfoKey.setBaseIndicator(ccsResponseData.getBase());
        sequenceInfoKey.setContractMonth(ccsResponseData.getContractMonth());
        sequenceInfoKey.setOriginationDate(flightLegs.getItems().get(0).getFlightKey().getFlightOriginationDate());
        sequenceInfoKey.setPositionCode(ccsResponseData.getPositionCode());
        sequenceInfoKey.setSequenceNumber(ccsResponseData.getSequenceNumber());

        sequenceDet.setSequenceInfoKey(sequenceInfoKey);

        // SequencePayCredit - do we need to calculate this

        final SequencePayCredit sequencePayCredit = new SequencePayCredit();
        sequencePayCredit.setActualSeqCredit(0); // check with QLA team
        sequencePayCredit.setScheduledSeqCredit(0);// check this with QLA ..... need more fields
                                                   // here
        sequencePayCredit.setActualBlockTime(0);

        sequenceDet.setSequencePayCredit(sequencePayCredit);

        sequenceDet.setSequenceStatus(ccsResponseData.getSequenceStatus());

        // Local time
        final String strLoc = flightLegs.getItems().get(0).getDepartureTime().getScheduled().getLocalTime();
        final String[] arrOfStrLoc = strLoc.split("T", 2);
        sequenceDet.setStartDateTime(arrOfStrLoc[1]);

        // base

        final String str = flightLegs.getItems().get(0).getDepartureTime().getScheduled().getBaseTime();
        final String[] arrOfStr = str.split("T", 2);
        sequenceDet.setStartDateTimeInBaseTime(arrOfStr[1]);

        // gmt
        final String str2 = flightLegs.getItems().get(0).getDepartureTime().getScheduled().getGmt();
        final String[] arrOfStr2 = str2.split("T", 2);
        sequenceDet.setStartDateTime(arrOfStr2[1]);

        sequenceDet.setTotalMissingForCabin(ccsResponseData.getSpeakerRequirement().getTotalMissingForCabin());
        sequenceDet.setTotalMissingForSeq(ccsResponseData.getSpeakerRequirement().getTotalMissingForSeq());
        sequenceDet.setTotalOpenPositionsForCabin(ccsResponseData.getTotalOpenPositionsForCabin());
        sequenceDet.setTotalOpenPositionsForSeq(ccsResponseData.getTotalOpenPositionsForSeq());
        sequenceDet.setTotalRequiredForCabin(ccsResponseData.getSpeakerRequirement().getTotalRequiredForCabin());
        sequenceDet.setTotalRequiredForSeq(ccsResponseData.getSpeakerRequirement().getTotalRequiredForSeq());
        sequenceDet.setType("F");
        sequenceDet.setCreditThisMonth(ccsResponseData.getCreditThisMonth());// WONT IT BE CREDIT
                                                                             // FOR FA 2

        System.out.println(" QLA projected data in class :::: " + qlaPayload);

        return qlaPayload;
    }

}
