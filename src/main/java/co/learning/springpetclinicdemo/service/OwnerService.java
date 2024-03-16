package co.learning.springpetclinicdemo.service;

import co.learning.springpetclinicdemo.entity.Owner;
import co.learning.springpetclinicdemo.service.dto.OwnerDTO;

import java.util.List;

public interface OwnerService {

    List<OwnerDTO> findOwnersByLastName(String lastName);

    Owner getOwnerById(Integer id);

    List<Owner> findAllOwners();

    void saveOwner(Owner owner);

    void updateOwner(Owner owner);
}
