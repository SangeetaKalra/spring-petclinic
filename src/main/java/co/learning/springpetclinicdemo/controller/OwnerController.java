package co.learning.springpetclinicdemo.controller;

import co.learning.springpetclinicdemo.entity.Owner;
import co.learning.springpetclinicdemo.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/owners")
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("ownerList", ownerService.getAllOwner());
        return "index";
    }

    @GetMapping("/findOwnerByLastName")
    public String findOwnerByLastName(@RequestParam String lastName, Model model) {
        List<Owner> owners = ownerService.findOwnersByLastName(lastName);
        model.addAttribute("owners", owners);
        return "owners/find";
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

    @GetMapping("/addOwner")
    public String addOwner(Model model) {
        Owner owner = new Owner();
        model.addAttribute("owner", owner);
        return "createOwner";
    }

//    @PostMapping("/add")
//    public Owner addOwner(@RequestBody Owner owner){
//        return ownerService.saveOwner(owner);
//    }

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
