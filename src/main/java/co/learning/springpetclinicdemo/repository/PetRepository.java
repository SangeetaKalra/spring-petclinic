package co.learning.springpetclinicdemo.repository;

import co.learning.springpetclinicdemo.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Integer> {
}
