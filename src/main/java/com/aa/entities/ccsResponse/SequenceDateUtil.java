/**
 * @author rswami
 * POJO to get sequence date details from CCS service
 */

package com.aa.entities.ccsResponse;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public final class SequenceDateUtil {

    private static final DateFormat serviceFormatter5 = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

    private static final DateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");

    // Fri Oct 02 18:59:00 IST 2020

    public static Date parseDate(final String date) {
        try {
            return serviceFormatter5.parse(date);
        } catch (final ParseException e) {
            return null;
        }
    }

    public static String getDutyPeriodDateFormat(final String inputDate) {
        final SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");

        try {
            return df.format(formatter.parse(inputDate));
        } catch (final ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Timestamp getTimeStamp(final String str) {
        return Timestamp.valueOf(str);
    }

    /* This Method Converts GMT TO HBT time using the parameters date and region values. */
    public static String convertedGMTtoHBTTime(final Date date, final String region) {
        final DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        final DateTimeFormatter formatter = DateTimeFormatter
            .ofPattern("yyyy-MM-dd HH:mm:ss");
        final LocalDateTime gmtTime = LocalDateTime.parse(df.format(date), formatter);
        final ZonedDateTime dateAndTimeInGMT = ZonedDateTime.of(gmtTime,
            ZoneOffset.UTC);
        final TimeZone hbtTime = TimeZone.getTimeZone(region);
        df.setTimeZone(hbtTime);
        final String baseTime = df.format(Date.from(dateAndTimeInGMT.toInstant()));
        return baseTime;
    }

    /* This Method Converts HBT TO GMT time using the parameter date. */
    public static String convertedHBTtoGMTTime(final Date date) {
        final SimpleDateFormat df = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss");
        final TimeZone gmtTime = TimeZone.getTimeZone("GMT+00");
        df.setTimeZone(gmtTime);
        final String gmtDate = df.format(date);
        return gmtDate;
    }

    public static String getOrignationDate(final LocalDate date) {
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return date.format(formatter);
    }

    public static String getOrignationDateAsString(final LocalDate date) {
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMM");
        return date.format(formatter);
    }

    public static String parseOrignationDate(final String str) {
        Date date = null;
        final DateFormat formatters = new SimpleDateFormat("yyyy-MM-dd");
        try {
            if (str != null) {
                date = formatters.parse(str);
                final Instant instant = Instant.ofEpochMilli(date.getTime());
                final LocalDateTime ldt = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
                return ldt.format(DateTimeFormatter.ofPattern("ddMMM"));
            } else {
                return null;
            }

        } catch (final Exception e) {
            return null;
        }

    }

    public static String parseSequenceDateString(final String str) {
        Date date = null;
        final DateFormat formatters = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        try {
            if (str != null) {
                date = formatters.parse(str);
                final Instant instant = Instant.ofEpochMilli(date.getTime());
                final LocalDateTime ldt = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
                final String fomattedSequenceDate =
                    ldt.format(DateTimeFormatter.ofPattern("hhmm")).trim() + "/" + ldt.format(DateTimeFormatter.ofPattern("ddMMM"));
                return fomattedSequenceDate;
            } else {
                return null;
            }
        } catch (final Exception e) {
            return null;
        }
    }

    public static String formatSequenceDateTimeString(final String str) {
        Date date = null;
        final DateFormat formatters = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        try {
            if (str != null) {
                date = formatters.parse(str);
                final Instant instant = Instant.ofEpochMilli(date.getTime());
                final LocalDateTime ldt = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
                final String fomattedSequenceDate =
                    ldt.format(DateTimeFormatter.ofPattern("HHmm")).trim() + "/" + ldt.format(DateTimeFormatter.ofPattern("dd"));
                return fomattedSequenceDate;
            } else {
                return null;
            }
        } catch (final Exception e) {
            return null;
        }
    }

    public static LocalDate convertOriginationDateToLocalDate(final Date date) {
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        final Instant instant = Instant.ofEpochMilli(date.getTime());
        final LocalDate orignationDate = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        final String text = orignationDate.format(formatter);
        return LocalDate.parse(text, formatter);
    }

    public static LocalDate convertOriginationDateToLocalDate(final String date) {
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(date, formatter);
    }

}
