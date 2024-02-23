package co.learning.springpetclinicdemo.service;

import co.learning.springpetclinicdemo.entity.Owner;

import java.util.List;

public interface OwnerService {

    List<Owner> findOwnersByLastName(String lastName);

    Owner getOwnerById(Integer id);

    List<Owner> getAllOwners();

    List<Owner> findAllOwners();

    void saveOwner(Owner owner);
}
