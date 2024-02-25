package co.learning.springpetclinicdemo.repository;

import co.learning.springpetclinicdemo.entity.Owner;


/**
 * Example of DAO pattern. If using spring data, this becomes redundant to some extent.
 */
public interface OwnerDAO {

    public Owner save(Owner owner);


}
