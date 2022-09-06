package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Contact;
import com.example.demo.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactServiceI {

	@Autowired
	private ContactRepository contactRepository;

	@Override
	public boolean createContact(Contact contact) {
		Contact savedContact = contactRepository.save(contact);

		if (savedContact != null) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean updateContact(Contact contact) {
		Contact contact2 = contactRepository.findById(contact.getContactId()).get();
		
		if (contact2 != null) {
			 contactRepository.save(contact);
			return true;
		} else {
			return false;
		}

	}

	@Override
	public Contact getContact(Integer contactId) {
		Contact contact = contactRepository.findById(contactId).get();
		return contact;
	}

	@Override
	public List<Contact> getContacts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteContact(Integer contactId) {
		boolean existsById = contactRepository.existsById(contactId);
		if (existsById == true) {
			contactRepository.deleteById(contactId);
			return true;
		} else {
			return false;
		}
		
	

	}

}
