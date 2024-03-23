package co.learning.springpetclinicdemo.service.dto;


import co.learning.springpetclinicdemo.entity.Pet;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.util.Set;

@Getter
@AllArgsConstructor
public  class OwnerDTO implements Serializable {
    private int id;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    private String address;

    @NotBlank
    private String city;

    @NotBlank
    private String telephone;

   private Set<Pet> pets;
}
