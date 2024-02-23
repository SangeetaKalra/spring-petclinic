package co.learning.springpetclinicdemo.service;

import co.learning.springpetclinicdemo.entity.Owner;
import co.learning.springpetclinicdemo.repository.OwnerRepository;
import co.learning.springpetclinicdemo.testsupport.factories.OwnerFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@SpringJUnitConfig
public class OwnerServiceTest {

    @Mock
    private OwnerRepository ownerRepository;

    @InjectMocks
    private OwnerServiceImpl ownerService;

    Owner owner= OwnerFactory.createJohnDoe();


    @Test
    void testFindAllOwners() {


        when(ownerRepository.findAll()).thenReturn(new ArrayList<>(
                Collections.singleton(owner)
        ));
        List<Owner> owners = ownerService.findAllOwners();
        assertThat(owners).isNotNull();
        assertThat(owners.get(0).getCity()).isEqualTo(owner.getCity());
    }

    @Test
    public void testGetOwnerById() {
        int ownerId = 1;
        Owner owner = Owner.builder().id(1).firstName("George").lastName("Franklin")
                .address("110 W. Liberty St.").city("Madison")
                .telephone("6085551023").build();
        when(ownerRepository.findById(ownerId)).thenReturn(Optional.ofNullable(owner));
        Owner ownerReturn = ownerService.getOwnerById(ownerId);
        Assertions.assertThat(ownerReturn).isNotNull();
    }
}
