package co.learning.springpetclinicdemo.service;

import co.learning.springpetclinicdemo.entity.Owner;
import co.learning.springpetclinicdemo.repository.OwnerDAO;
import co.learning.springpetclinicdemo.repository.OwnerRepository;
import co.learning.springpetclinicdemo.service.dto.OwnerDTO;
import co.learning.springpetclinicdemo.service.mapper.OwnerConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerServiceImpl implements OwnerService {

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private OwnerDAO ownerDAO;


    @Cacheable("owners")
    public List<Owner> findAllOwners() {
        List<Owner> owners= ownerDAO.findAllOwners();
        return owners;

    }

    @Cacheable("owners")
    public List<OwnerDTO> findOwnersByLastName(String lastName) {

        List<Owner> owners = ownerRepository.findOwnersByLastName(lastName);
        return OwnerConverter.convert(owners);
    }

    @Cacheable(value = "owner")
    public Owner getOwnerById(Integer id) {
        Optional<Owner> optionalEmployee = ownerRepository.findById(id);
        Owner owner = null;
        if (optionalEmployee.isPresent()) {
            owner = optionalEmployee.get();
        } else {
            throw new RuntimeException("Employee not found for id: " + id);
        }
        owner.getPets();
        return owner;
    }

    public Owner saveOwner(Owner owner) {
        return ownerRepository.save(owner);

    }

    @Override
    public void updateOwner(Owner owner) {
        ownerRepository.save(owner);
    }


}
