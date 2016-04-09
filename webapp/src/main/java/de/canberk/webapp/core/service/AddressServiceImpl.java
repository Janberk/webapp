package de.canberk.webapp.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.canberk.webapp.core.dao.AddressDAO;
import de.canberk.webapp.model.Address;

@Service
@Primary
@Transactional
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressDAO dao;

	@Override
	public void createAddress(Address address) {
		this.dao.createAddress(address);
	}

	@Override
	public void deleteAddressById(int id) {
		this.dao.deleteAddressById(id);
	}

	@Override
	public List<Address> listAllAddresses() {
		return this.dao.listAllAddresses();
	}

	@Override
	public Address readAddressById(int id) {
		return this.dao.readAddressById(id);
	}

	@Override
	public void updateAddress(Address address) {
		this.dao.updateAddress(address);
	}

}
