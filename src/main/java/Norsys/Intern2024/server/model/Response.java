package Norsys.Intern2024.server.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Map;

@Data
@SuperBuilder
@JsonInclude(Include.NON_NULL)
public class Response {
    protected LocalDateTime timeStamp; // Renamed from timeStape to timeStamp
    protected int statusCode;
    protected HttpStatus status;
    protected String reason;
    protected String message;
    protected String developperMessage;
    protected Map<?,?> data;
}