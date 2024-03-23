package co.learning.springpetclinicdemo.repository;

import co.learning.springpetclinicdemo.entity.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OwnerDAOImpl implements OwnerDAO {
    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private RedisTemplate redisTemplate;

    private static final String KEY = "OWNER";

    @Override
    public Owner save(Owner owner) {
        return ownerRepository.save(owner);
    }

    @Override
    public List<Owner> findAllOwners() {
        List<Owner> owners = ownerRepository.findAll();
        return owners;
    }
}
