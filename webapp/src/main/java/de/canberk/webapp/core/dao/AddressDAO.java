package de.canberk.webapp.core.dao;

import java.util.List;

import de.canberk.webapp.model.Address;

public interface AddressDAO {

	void createAddress(Address address, String userName);

	void deleteAddressById(int id);

	List<Address> listAllAddresses();

	Address readAddressById(int id);

	void updateAddress(Address address);

}
