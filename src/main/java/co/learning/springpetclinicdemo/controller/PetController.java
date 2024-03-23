package co.learning.springpetclinicdemo.controller;

import co.learning.springpetclinicdemo.entity.Pet;
import co.learning.springpetclinicdemo.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pets/")
public class PetController {

    @Autowired
    private PetService petService;

    @GetMapping("/addPet")
    public String addPet(Model model) {
        Pet pet = new Pet();
        model.addAttribute("pet", pet);
        return "createPet";
    }

    @PostMapping("/savePet")
    public String savePet(@ModelAttribute("pet") Pet pet) {
        petService.savePet(pet);
        return "redirect:/owners/{ownerId}";
    }

    @GetMapping("/findAllPets")
    public List<Pet> getAllPets() {
        return petService.getAllPets();
    }
}
