package com.aa.entities.ccsResponse;



import com.aa.entities.ccsResponse.ValidateConstants;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeSerializer extends JsonSerializer<LocalDateTime> {

    @Override
    public void serialize(final LocalDateTime value, final JsonGenerator gen, final SerializerProvider serializers)
            throws IOException, JsonProcessingException {
        final String timeString = value != null ? value.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
                : ValidateConstants.DATETIME_FORMAT;
        gen.writeString(timeString);
    }
}