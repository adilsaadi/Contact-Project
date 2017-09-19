package com.ensao.service;

import java.util.List;

import com.ensao.model.Contact;
import com.ensao.model.Groupe;

public interface ContactService {

	public void addContact(Contact contact);

	public List<Contact> getAllContact();

	public List<Contact> getContactByIdGroupe(int groupeId);

	
	public void deleteContact(Integer contactId);

	public Contact updateContact(Contact contact);

	public Contact getContact(int contactid);
	
	public List<Groupe> getAllGroupe();
	
	public Groupe getGroupe(int groupeid);
	
	public void addGroupe(Groupe groupe);
	
	public Groupe updateGroupe(Groupe groupe);



}
