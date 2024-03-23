package co.learning.springpetclinicdemo.controller;

import co.learning.springpetclinicdemo.entity.Owner;
import co.learning.springpetclinicdemo.service.OwnerService;
import co.learning.springpetclinicdemo.service.OwnerServiceImpl;
import co.learning.springpetclinicdemo.service.dto.ErrorDTO;
import co.learning.springpetclinicdemo.service.dto.OwnerDTO;
import co.learning.springpetclinicdemo.service.dto.ResponseDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/owners")
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    @GetMapping("/findOwnerByLastName")
    public List<OwnerDTO> findOwnerByLastName(@RequestParam String lastName) {
        List<OwnerDTO> owners = ownerService.findOwnersByLastName(lastName);
        return owners;
    }

    @GetMapping("/findAll")
    public List<Owner> findAllOwner() {

        return ownerService.findAllOwners();
    }

    @GetMapping("{ownerId}")
    public Owner getById(@PathVariable("ownerId") Integer id) {

        return ownerService.getOwnerById(id);
    }

    @PostMapping("/saveOwner")
    public ResponseEntity<ResponseDTO> saveOwner(@Valid @RequestBody Owner owner, BindingResult result) {
        if (result.hasErrors()) {
            List<ErrorDTO> errors = new ArrayList<>();
            for (FieldError error : result.getFieldErrors()) {
                errors.add(new ErrorDTO(error.getField(), error.getDefaultMessage()));
            }
            // Return validation errors in response
            return ResponseEntity.badRequest().body(constructErrorResponse(errors));
        } else {
            Owner owner1=ownerService.saveOwner(owner);
            return ResponseEntity.status(201).body(constructSuccessResponse(owner1));
        }
    }

    private ResponseDTO constructSuccessResponse(Owner owner) {
        return ResponseDTO.builder()
                .status("ok")
                .message("Owner saved successfully")
                .owner(owner)
                .build();
    }

    private ResponseDTO constructErrorResponse(List<ErrorDTO> errors) {
        return ResponseDTO.builder()
                .status("Error")
                .message("There are validation errors")
                .errors(errors)
                .build();
    }

    @PutMapping("/{ownerId}")
    public ResponseEntity<String> updateOwner(@PathVariable Integer ownerId, @RequestBody OwnerDTO ownerDTO) {
        Owner owner = ownerService.getOwnerById(ownerId);
        if (owner == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Owner not found");
        }
        owner.setFirstName(ownerDTO.getFirstName());
        owner.setLastName(ownerDTO.getLastName());
        owner.setAddress(ownerDTO.getAddress());
        owner.setCity(ownerDTO.getCity());
        owner.setTelephone(ownerDTO.getTelephone());
        ownerService.updateOwner(owner);
        return ResponseEntity.ok("Owner updated successfully");
    }
}
