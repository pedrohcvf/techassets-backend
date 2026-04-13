package com.techassets.techassets.exception;

import java.time.LocalDateTime;
import java.util.List;

public record ErrorResponseDto(int status,
                               String  mensagem,
                               LocalDateTime timeStamp,
                               List<String> errors) {
}
