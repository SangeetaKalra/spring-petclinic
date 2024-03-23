package co.learning.springpetclinicdemo.service.dto;

import co.learning.springpetclinicdemo.entity.Owner;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class ResponseDTO {
    private String status;
    private String message;
    private Owner owner;


    private List<ErrorDTO> errors;

}
