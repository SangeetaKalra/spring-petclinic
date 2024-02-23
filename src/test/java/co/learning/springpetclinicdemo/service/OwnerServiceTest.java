package co.learning.springpetclinicdemo.service;

import co.learning.springpetclinicdemo.entity.Owner;
import co.learning.springpetclinicdemo.repository.OwnerRepository;
import co.learning.springpetclinicdemo.testsupport.factories.OwnerFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@SpringJUnitConfig
public class OwnerServiceTest {

    @Mock
    private OwnerRepository ownerRepository;

    @InjectMocks
    private OwnerServiceImpl ownerService;

    Owner johnDoe = OwnerFactory.createJohnDoe();


    @BeforeEach
    void setUp() {
        when(ownerRepository.findAll()).thenReturn(new ArrayList<>(
                Collections.singleton(johnDoe)
        ));

        when(ownerRepository.findById(anyInt())).thenReturn(Optional.ofNullable(johnDoe));
    }

    @Test
    void testFindAllOwners() {
        List<Owner> owners = ownerService.findAllOwners();
        assertThat(owners).isNotNull();
        assertThat(owners.get(0).getCity()).isEqualTo(johnDoe.getCity());

        //add verify statements
    }

    @Test
    public void testGetOwnerById() {

        Owner ownerReturn = ownerService.getOwnerById(123);
        Assertions.assertThat(ownerReturn).isNotNull();
        //add verify statements
    }
}
