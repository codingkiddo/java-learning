package com.example.java8.features;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

public class MiliSecondsToDate {

	public static final long millis = 1556175797428L;

	public static void main(String[] args) {

		ZoneId id = ZoneId.systemDefault();

        LocalDateTime localDateTime =
                LocalDateTime.ofInstant(java.time.Instant.ofEpochMilli(millis), id);

        ZonedDateTime zdt = ZonedDateTime.of(localDateTime, id);

        System.out.println(zdt.toInstant().toEpochMilli());
        
        Date date = new Date(millis);
        System.out.println(date.getTime());
        
        
        Instant instant = Instant.ofEpochMilli(864000);

        Timestamp timestamp = Timestamp.from(instant); // same point on the time-line as Instant

        instant = timestamp.toInstant();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        formatter = formatter.withZone(TimeZone.getTimeZone("UTC").toZoneId());

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        df.setTimeZone(TimeZone.getTimeZone("UTC"));

        System.out.println(df.format(timestamp));
        
        
        LocalDate futureDate = LocalDate.now().plusDays(10);
        DateTimeFormatter futureFormatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
        String dateStr = futureDate.format(futureFormatter);
        System.out.println(dateStr);

	}

}
