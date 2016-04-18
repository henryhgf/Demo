package pe.com.peruInka.service.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import pe.com.peruInka.service.util.Person;

@Service("peruInkaService")
public class PeruInkaService {

	public static List<Person> listPerson = new ArrayList<Person>();

	public void saveService(Person person) {
		listPerson.add(person);
		// peruInkaDAO.savePerson(Person);
	}

	public List<Person> findAllPerson() {
		// return peruInkaDAO.findAllPerson();
		return listPerson;
	}

}
