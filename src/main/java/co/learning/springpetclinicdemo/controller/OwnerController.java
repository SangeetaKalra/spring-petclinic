package co.learning.springpetclinicdemo.controller;

import co.learning.springpetclinicdemo.entity.Owner;
import co.learning.springpetclinicdemo.service.OwnerService;
import co.learning.springpetclinicdemo.service.dto.OwnerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/owners")
public class OwnerController {

    @Autowired
    private OwnerService ownerService;



    @GetMapping("/findOwnerByLastName")
    public List<OwnerDTO> findOwnerByLastName(@RequestParam String lastName) {
        List<OwnerDTO> owners = ownerService.findOwnersByLastName(lastName);
        return owners;

    }

    //shows list of owners
    @GetMapping("/find")
    public String findAllOwner(Model model){
        model.addAttribute("listOwners", ownerService.findAllOwners());
        return "findOwners";
    }

    @GetMapping("{ownerId}")
    public String getById(@PathVariable("ownerId")Integer id, Model model){
        Owner owner=ownerService.getOwnerById(id);
        model.addAttribute("owner",owner);
        return "OwnerDetails";
    }

    @PostMapping("/saveOwner")
    public String saveOwner(@ModelAttribute("owner") Owner owner) {
        ownerService.saveOwner(owner);
        return "redirect:/";
    }

    @GetMapping("/{ownerId}/updateOwner")
    public String showFormForUpdate(@PathVariable(value = "ownerId") Integer id, Model model) {
        Owner owner = ownerService.getOwnerById(id);
        model.addAttribute("owner", owner);
        return "updateOwner";
    }

}
