package co.learning.springpetclinicdemo.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ErrorDTO {
    private String fieldName;
    private String errorMessage;

}
