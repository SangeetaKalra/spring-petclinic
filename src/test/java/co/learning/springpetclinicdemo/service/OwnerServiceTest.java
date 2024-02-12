//package co.learning.springpetclinicdemo.service;
//
//import co.learning.springpetclinicdemo.entity.Owner;
//import co.learning.springpetclinicdemo.repository.OwnerRepository;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Optional;
//
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//
//public class OwnerServiceTest {
//
//    @Mock
//    private OwnerRepository ownerRepository;
//    private OwnerService ownerService;
//    AutoCloseable autoCloseable;
//    Owner owner;
//
//    @BeforeEach
//    void setUp(){
//        autoCloseable= MockitoAnnotations.openMocks(this);
//        ownerService=new OwnerService();
//        owner=new Owner(1,"Betty","Davis","638 Cardinal Ave.","Sun Prairie","6085551749");
//    }
//
//    @Test
//    void testFindAllOwner(){
//        mock(Owner.class);
//        mock(OwnerRepository.class);
//        when(ownerRepository.findAll()).thenReturn(new ArrayList<Owner>(
//                Collections.singleton(owner)
//        ));
//        assertThat(ownerService.getAllOwner().get(0).getTelephone()).
//                isEqualTo(owner.getTelephone());
//    }
//
//    @AfterEach
//    void tearDown() throws Exception{
//        autoCloseable.close();
//    }
//
//}
