package tech.hidetora.security.dto.response;

import lombok.*;
import tech.hidetora.security.enumeration.ErrorCodes;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorResponse {
    private Integer httpCode;
    private ErrorCodes code;
    private String message;
    @Builder.Default
    private List<String> errors = new ArrayList<>();
}
