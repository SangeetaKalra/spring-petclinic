package co.learning.springpetclinicdemo.repository;

import co.learning.springpetclinicdemo.entity.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OwnerDAOImpl implements OwnerDAO{


    @Autowired
    private OwnerRepository ownerRepository;
    @Override
    public Owner save(Owner owner) {
        return ownerRepository.save(owner);


    }
}
