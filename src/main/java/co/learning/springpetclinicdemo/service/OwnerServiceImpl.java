package co.learning.springpetclinicdemo.service;

import co.learning.springpetclinicdemo.entity.Owner;
import co.learning.springpetclinicdemo.repository.OwnerDAO;
import co.learning.springpetclinicdemo.repository.OwnerRepository;
import co.learning.springpetclinicdemo.service.dto.OwnerDTO;
import co.learning.springpetclinicdemo.service.mapper.OwnerConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerServiceImpl implements OwnerService{

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private OwnerDAO ownerDAO;


    public OwnerServiceImpl(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    public List<OwnerDTO> findOwnersByLastName(String lastName) {

        List<Owner> owners= ownerRepository.findOwnersByLastName(lastName);
        return OwnerConverter.convert(owners);
    }

    public List<Owner> getAllOwners() {
        return ownerRepository.findAll();
    }

    public Owner getOwnerById(Integer id){
        Optional<Owner> optionalEmployee=ownerRepository.findById(id);
        Owner owner=null;
        if(optionalEmployee.isPresent()){
            owner=optionalEmployee.get();
        }else {
            throw new RuntimeException("Employee not found for id: " +id);
        }
        return owner;
    }

    public void saveOwner(Owner owner) {

         this.ownerDAO.save(owner);
    }

    public List<Owner> findAllOwners(){
        return ownerRepository.findAll();
    }

}
