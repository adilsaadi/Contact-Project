package com.ensao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ensao.dao.ContactDao;
import com.ensao.model.Contact;
import com.ensao.model.Groupe;

@Service
@Transactional
public class ContactServiceImpl implements ContactService{

	
	@Autowired
	private ContactDao contactDao;
	
	public void addContact(Contact contact) {
		contactDao.addContact(contact);
		
	}

	public List<Contact> getAllContact() {
		return contactDao.getAllContact();
	}

	public void deleteContact(Integer contactId) {
		contactDao.deleteContact(contactId);
		
	}

	public Contact updateContact(Contact contact) {
		return contactDao.updateContact(contact);
	}

	public Contact getContact(int contactid) {
		return contactDao.getContact(contactid);
	}

	public List<Groupe> getAllGroupe() {
		return contactDao.getAllGroupe();
	}

	public Groupe getGroupe(int groupeid) {
		return contactDao.getGroupe(groupeid);
	}

	public void addGroupe(Groupe groupe) {
		contactDao.addGroupe(groupe);
	}

	public List<Contact> getContactByIdGroupe(int groupeId) {
		return contactDao.getContactByIdGroupe(groupeId);
	}

	public Groupe updateGroupe(Groupe groupe) {
		return contactDao.updateGroupe(groupe);
	}

}
