package com.codecool.logmyphones.modell;

import java.time.LocalDateTime;

public record Call(int callId, String callingNumber, String calledNumber, LocalDateTime dateTime,CallStatus callStatus, int duration) {
}
