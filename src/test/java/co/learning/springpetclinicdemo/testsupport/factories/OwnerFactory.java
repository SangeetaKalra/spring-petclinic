package co.learning.springpetclinicdemo.testsupport.factories;

import co.learning.springpetclinicdemo.entity.Owner;
import co.learning.springpetclinicdemo.entity.Pet;

import java.time.LocalDate;
import java.util.Set;

public class OwnerFactory {

    public static Owner createJohnDoe() {
        return Owner.builder()
                    .firstName("John")
                    .lastName("Doe")
                    .address("123 Main St")
                    .telephone("555-1234")
                    .pets(Set.of(new Pet(1, "Cat1", LocalDate.of(1990, 1, 1))))
                    .build();
    }

    public static Owner createJaneSmith() {
        return Owner.builder()
                    .firstName("Jane")
                    .lastName("Smith")
                    .address("456 Elm St")
                    .telephone("555-5678")
                    .pets(Set.of(new Pet(1, "Cat1", LocalDate.of(1990, 1, 1))))
                    .build();
    }
}
