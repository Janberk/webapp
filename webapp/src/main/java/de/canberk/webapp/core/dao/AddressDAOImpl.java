package de.canberk.webapp.core.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import de.canberk.webapp.model.Address;

@Primary
@Repository
public class AddressDAOImpl implements AddressDAO {

	private static final Logger log = LogManager.getLogger(AddressDAOImpl.class);

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	@Override
	public void createAddress(Address address) {

		log.info("createAddress");

		Session session = this.sessionFactory.getCurrentSession();
		session.persist(address);
		log.debug("Address saved successfully, Address details: " + address.getStreet() + " " + address.getZipCode());

	}

	@Override
	public void deleteAddressById(int id) {

		log.info("deleteAddressById");

		Session session = this.sessionFactory.getCurrentSession();
		Address address = (Address) session.load(Address.class, new Integer(id));
		if (address != null) {
			session.delete(address);
			log.debug("Address deleted successfully, Address details: " + address.getStreet() + " "
					+ address.getZipCode());
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Address> listAllAddresses() {

		log.info("listAllAddresses");

		Session session = this.sessionFactory.getCurrentSession();
		List<Address> addresses = session.createQuery("from Address").list();

		return addresses;
	}

	@Override
	public Address readAddressById(int id) {

		log.info("readAddressById");

		Session session = this.sessionFactory.getCurrentSession();
		Address address = (Address) session.load(Address.class, new Integer(id));
		log.debug("Address loaded successfully, Address details: " + address.getStreet() + " " + address.getZipCode());

		return address;
	}

	@Override
	public void updateAddress(Address address) {

		log.info("updateAddress");

		Session session = this.sessionFactory.getCurrentSession();
		session.update(address);
		log.debug("Address updated successfully, Address details: " + address.getStreet() + " " + address.getZipCode());

	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
