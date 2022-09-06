package com.example.demo.controller;

import java.time.LocalDate;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Contact;

import com.example.demo.service.ContactServiceI;
import com.example.demo.util.AppConstant;
import com.example.demo.util.AppProps;

@RestController
public class ContactController {

	@Autowired
	private ContactServiceI contactServiceI;
	
	@Autowired
	private AppProps appProps;
	
	@PostMapping(value="/createNewContact")
	public ResponseEntity<String> createNewContact(@RequestBody Contact contact){
		 Map<String,String> message = appProps.getMessage();
		boolean createContact = contactServiceI.createContact(contact);
		if (createContact== true) {
			String msg=message.get(AppConstant.SAVE_SUCCESS);
			return new ResponseEntity<String>(msg,HttpStatus.CREATED);
		}else {
			String msg=message.get(AppConstant.SAVE_FAIL);
			return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);
		}
			
	}
	
	@PutMapping(value="/updateContact", consumes="application/json",produces="application/json")
	public ResponseEntity<String>updateContact(@RequestBody Contact contact){
		boolean updateContact = contactServiceI.updateContact(contact);
		if(updateContact==true) {
			String msg=AppConstant.UPDATE_SUCCESS;
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		}else {
			String msg=AppConstant.UPDATE_FAIL;
			return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);
		}
			
	}
	
	@GetMapping(value="/getContact/{contactId}",produces="application/json")
	public ResponseEntity<Contact> getContact(@PathVariable Integer contactId){
		Contact contact = contactServiceI.getContact(contactId);
		return new ResponseEntity<Contact>(contact,HttpStatus.OK);
		
	}
	@DeleteMapping(value="/deleteContact/{contactId}")
	public ResponseEntity<String> deleteContact(@PathVariable Integer contactId){
		boolean deleteContact = contactServiceI.deleteContact(contactId);
		Map<String,String> message = appProps.getMessage();
		if(deleteContact==true) {
			String msg= message.get(AppConstant.DELETE_SUCCESS);
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		}else {
			String msg= message.get(AppConstant.DELETE_FAIL);
			return new ResponseEntity<String>(msg,HttpStatus.BAD_REQUEST);
		}
		
		
	}
	
	
}
