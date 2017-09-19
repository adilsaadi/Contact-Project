package com.ensao.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ensao.model.Contact;
import com.ensao.model.Groupe;


@Repository
public class ContactDaoImpl implements ContactDao {

	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void addContact(Contact contact) {
		sessionFactory.getCurrentSession().saveOrUpdate(contact);		
	}

	@SuppressWarnings("unchecked")
	public List<Contact> getAllContact() {
		return sessionFactory.getCurrentSession().createQuery("from Contact").list();
	}

	public void deleteContact(Integer contactId) {
		Contact contact = (Contact) sessionFactory.getCurrentSession().load(
				Contact.class, contactId);
		if (null != contact) {
			this.sessionFactory.getCurrentSession().delete(contact);
		}
		
	}

	public Contact updateContact(Contact contact) {
		sessionFactory.getCurrentSession().update(contact);
		return contact;
	}

	public Contact getContact(int contactid) {
		return (Contact) sessionFactory.getCurrentSession().get(Contact.class, contactid);
	}

	@SuppressWarnings("unchecked")
	public List<Groupe> getAllGroupe() {
		return  sessionFactory.getCurrentSession().createQuery("from Groupe").list();
	}

	public Groupe getGroupe(int groupeid) {
		return (Groupe) sessionFactory.getCurrentSession().get(Groupe.class,groupeid);
	}

	public void addGroupe(Groupe groupe) {
		sessionFactory.getCurrentSession().saveOrUpdate(groupe);		
		
	}

	public List<Contact> getContactByIdGroupe(int groupeId) {
		
		List<Contact> listContact = new ArrayList<Contact>();
		String hql = "from Contact c inner join c.groupe where c.groupe.idGroupe=:i";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("i",groupeId);
		List<Object[]> listResult = query.list();
		 
		for (Object[] aRow : listResult) {
		    Contact contact = (Contact) aRow[0];
		    listContact.add(contact);
		}
		
		return listContact;
	}

	public Groupe updateGroupe(Groupe groupe) {
		sessionFactory.getCurrentSession().update(groupe);
		return groupe;
	}

}
