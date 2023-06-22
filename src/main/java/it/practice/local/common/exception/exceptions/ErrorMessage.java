package it.practice.local.common.exception.exceptions;


import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.OffsetDateTime;

@Data
@RequiredArgsConstructor
public class ErrorMessage {
    private final int status;
    private final String code;
    private final OffsetDateTime timestamp;
}
