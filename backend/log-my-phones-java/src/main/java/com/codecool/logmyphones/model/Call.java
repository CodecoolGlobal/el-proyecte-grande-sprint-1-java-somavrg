package com.codecool.logmyphones.model;

import java.time.LocalDateTime;

public record Call(int callId, String callingNumber, String calledNumber, LocalDateTime dateTime,CallStatus callStatus, int duration) {
}
