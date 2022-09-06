package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Contact;

public interface ContactServiceI {

	public boolean createContact(Contact contact);
	
	public boolean updateContact(Contact contact );
	
	public Contact getContact(Integer contactId);
	
	public List<Contact> getContacts();
	
	public boolean deleteContact(Integer contactId);
}
