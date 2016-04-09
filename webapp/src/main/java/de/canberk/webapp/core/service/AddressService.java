package de.canberk.webapp.core.service;

import java.util.List;

import de.canberk.webapp.model.Address;

public interface AddressService {

	void createAddress(Address address);

	void deleteAddressById(int id);

	List<Address> listAllAddresses();

	Address readAddressById(int id);

	void updateAddress(Address address);

}
