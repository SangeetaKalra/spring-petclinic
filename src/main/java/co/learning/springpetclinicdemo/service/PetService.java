package co.learning.springpetclinicdemo.service;

import co.learning.springpetclinicdemo.entity.Pet;
import co.learning.springpetclinicdemo.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    public void savePet(Pet pet) {

         this.petRepository.save(pet);
    }

    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }
}
