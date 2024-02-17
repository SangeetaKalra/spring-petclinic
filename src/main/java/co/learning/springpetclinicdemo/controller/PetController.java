package co.learning.springpetclinicdemo.controller;

import co.learning.springpetclinicdemo.entity.Owner;
import co.learning.springpetclinicdemo.entity.Pet;
import co.learning.springpetclinicdemo.repository.OwnerRepository;
import co.learning.springpetclinicdemo.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/owners/{ownerId}")
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

    public String getAllPets(Model model) {
        List<Pet> pets = petService.getAllPets();
        model.addAttribute("pets", pets);
        return "petList";
    }
}
