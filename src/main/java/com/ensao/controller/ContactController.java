package com.ensao.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ensao.model.Contact;
import com.ensao.model.Groupe;
import com.ensao.service.ContactService;

@Controller
public class ContactController {
	
	@Autowired
	ContactService contactService ;
	
	@RequestMapping(value = "/contactList", method = RequestMethod.GET)
	public ModelAndView listContact(ModelAndView model) throws IOException {
		
		Map<Groupe,List<Contact>> map = new HashMap<Groupe,List<Contact>>();
		List<Groupe> groupList = contactService.getAllGroupe();
		List<Contact> contactList = contactService.getAllContact();
		model.addObject("contactList",contactList);
		for(int i=0;i<groupList.size();i++){
			List<Contact> listContact=contactService.getContactByIdGroupe(groupList.get(i).getIdGroupe());
			map.put(groupList.get(i),listContact);
		}
		model.addObject("map",map);
		model.setViewName("ListContact");
		return model;
	}
	
	
	@RequestMapping(value = "/newContact", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model) {
		
		List<Groupe> listGroupe = contactService.getAllGroupe();
		model.addObject("listGroupe",listGroupe);
		model.addObject("contactID", 0);
		model.setViewName("addContact");
		model.addObject("page","Add");
		return model ;
	}
	
	@RequestMapping(value = "/saveContact", method = RequestMethod.POST)
	public ModelAndView saveContact(ModelAndView model , @RequestParam("nom") String nom ,
			                @RequestParam("prenom") String prenom ,
			                @RequestParam("telephone") String telephone,
			                @RequestParam("email") String email , 
			                @RequestParam("id") int id ,@RequestParam("idGroupe")
	                         String idGroupe ){
	
			Groupe groupe = contactService.getGroupe(Integer.parseInt(idGroupe));
			Contact contact;
				if(id==0) {
					contact= new Contact();
					contact.setNom(nom);
					contact.setPrenom(prenom);
					contact.setTelephone(telephone);
					contact.setEmail(email);
					contact.setGroupe(groupe);
					contactService.addContact(contact);
		} else {
					contact = contactService.getContact(id);
					contact.setNom(nom);
					contact.setPrenom(prenom);
					contact.setTelephone(telephone);
					contact.setEmail(email);
					contact.setGroupe(groupe);
					contactService.updateContact(contact);
			        
		}
				return new ModelAndView("redirect:/contactList");
	}
	

	@RequestMapping(value = "/newGroupe", method = RequestMethod.GET)
	public ModelAndView newGroupe(ModelAndView model) {
		model.setViewName("addGroupe");
		model.addObject("groupeID", 0);
		model.addObject("page","Add");
		return model;
	}
	
	@RequestMapping(value = "/editGroupe", method = RequestMethod.GET)
	public ModelAndView editGroupe(HttpServletRequest request) {
		String active="";
		String inactive="";
		int groupeId = Integer.parseInt(request.getParameter("id"));
		ModelAndView model = new ModelAndView("addGroupe");
		model.addObject("groupeID",groupeId);
		Groupe groupe = contactService.getGroupe(groupeId);
		model.addObject("groupe",groupe);
		if(groupe.getEtat().equals("active")){
			active="selected";
		}
		else{
			inactive="selected";
		}
		model.addObject("contact",groupe);
		model.addObject("active",active);
		model.addObject("inactive",inactive);
		model.addObject("page","Edit");
		return model;
	}
	
	@RequestMapping(value = "/saveGroupe", method = RequestMethod.POST)
	public ModelAndView saveGroupe(ModelAndView model , @RequestParam("libelle") String libelle,
			@RequestParam("etat") String etat , @RequestParam("id") int id){
		

			Groupe groupe ;
		if(id==0) {
			groupe = new Groupe();
			groupe.setLibelle(libelle);
			groupe.setEtat(etat);
			contactService.addGroupe(groupe);
        } else {
			groupe = contactService.getGroupe(id);
			groupe.setLibelle(libelle);
			groupe.setEtat(etat);
			contactService.updateGroupe(groupe);	        
        }
		
		return new ModelAndView("redirect:/contactList");
	}
	@RequestMapping(value = "/deleteContact", method = RequestMethod.GET)
	public ModelAndView deleteEmployee(HttpServletRequest request) {
		int contactId = Integer.parseInt(request.getParameter("id"));
		contactService.deleteContact(contactId);
		return new ModelAndView("redirect:/contactList");
	}
	
	@RequestMapping(value = "/editContact", method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {
		
		List<Groupe> listGroupe = contactService.getAllGroupe();
		int contactId = Integer.parseInt(request.getParameter("id"));
		ModelAndView model = new ModelAndView("addContact");
		model.addObject("listGroupe",listGroupe);
		model.addObject("contactID",contactId);
		Contact contact = contactService.getContact(contactId);
		model.addObject("contact",contact);
		model.addObject("page","Edit");
		return model;
	}
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index(ModelAndView model) {
		
		model.setViewName("index");
		return model ;
	}
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView home(ModelAndView model) {
		
		return new ModelAndView("redirect:/");
	}


}
