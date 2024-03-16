package co.learning.springpetclinicdemo.controller;

import co.learning.springpetclinicdemo.entity.Owner;
import co.learning.springpetclinicdemo.service.OwnerServiceImpl;
import co.learning.springpetclinicdemo.service.dto.OwnerDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/owners")
public class OwnerController {

    @Autowired
    private OwnerServiceImpl ownerServiceImpl;

    @GetMapping("/findOwnerByLastName")
    public List<OwnerDTO> findOwnerByLastName(@RequestParam String lastName) {
        List<OwnerDTO> owners = ownerServiceImpl.findOwnersByLastName(lastName);
        return owners;
    }

    @GetMapping("/findAll")
    public List<Owner> findAllOwner(){

        return ownerServiceImpl.findAllOwners();
    }

    @GetMapping("{ownerId}")
    public Owner getById(@PathVariable("ownerId")Integer id){
        return ownerServiceImpl.getOwnerById(id);
    }

    @PostMapping("/saveOwner")
    public void saveOwner(@Valid @RequestBody Owner owner) {

        ownerServiceImpl.saveOwner(owner);
    }

//    @PutMapping("/updateOwner/{id}")
//    public void updateOwner(@PathVariable(value = "id") Integer id) {
//        ownerServiceImpl.updateOwner(id);
//
//    }

}
