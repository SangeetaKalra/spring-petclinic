package co.learning.springpetclinicdemo.service.mapper;

import co.learning.springpetclinicdemo.entity.Owner;
import co.learning.springpetclinicdemo.service.dto.OwnerDTO;

import java.util.ArrayList;
import java.util.List;

public class OwnerConverter {


    public static List<OwnerDTO> convert(List<Owner> owners) {
        ArrayList<OwnerDTO> ownerDTOs=new ArrayList<>();
        for (Owner owner : owners) {
            OwnerDTO ownerDTO = new OwnerDTO(owner.getId(), owner.getFirstName(),
                    owner.getLastName(), owner.getAddress(),
                    owner.getCity(), owner.getTelephone(), owner.getPets());
            ownerDTOs.add(ownerDTO);
        }
        return ownerDTOs;
    }
}
