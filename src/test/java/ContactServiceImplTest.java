import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ensao.model.Contact;
import com.ensao.model.Groupe;
import com.ensao.service.ContactService;


@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/spring-servlet.xml")  
@Transactional
public class ContactServiceImplTest {

	

	@Autowired
	 private ContactService contactserv;
	
	Groupe groupe ;
	Contact contact;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	@Before
	public void setUp() throws Exception {
		
		contact = new Contact();
		groupe = new Groupe();
	}
	
	@Test
	@Rollback(true)
    public void testUpdateContact() { 
		groupe.setLibelle("club");
		groupe.setEtat("active");
	    contactserv.addGroupe(groupe);
		contact.setNom("FirstName");
		contact.setPrenom("LastName");
		contact.setEmail("name@gmail.com");
		contact.setTelephone("123456");
		contact.setGroupe(groupe);
		contactserv.addContact(contact);
		contact.setNom("FirstNameEdited");
		contact=contactserv.updateContact(contact);
		contact = contactserv.getContact(contact.getIdContact());
	    assertEquals("FirstNameEdited",contact.getNom());
    } 
	
	 @Test  
	 @Rollback(true)
     public void testGetAllContact() { 
		 groupe.setLibelle("club");
		 groupe.setEtat("active");
		 contactserv.addGroupe(groupe);
		 contact.setNom("FirstName");
		 contact.setPrenom("LastName");
		 contact.setEmail("name@gmail.com");
		 contact.setTelephone("123456");
		 contact.setGroupe(groupe);
		 contactserv.addContact(contact);
      List<Contact> listContact = contactserv.getAllContact();
      assertNotNull(listContact);  
     }  
	 
	 @Test  
	 @Rollback(true)
     public void testGetAllGroupe() {  
	  groupe.setLibelle("club");
	  groupe.setEtat("active");
      contactserv.addGroupe(groupe);

      List<Groupe> listGroupe = contactserv.getAllGroupe();
      assertNotNull(listGroupe);  
     } 
	 
	 @Test
	 @Rollback(true)
	 public void testGetContactByIdGroupe(){
		 groupe.setLibelle("club");
		 groupe.setEtat("active");
		 contactserv.addGroupe(groupe);
		 contact.setNom("FirstName");
		 contact.setPrenom("LastName");
		 contact.setEmail("name@gmail.com");
		 contact.setTelephone("123456");
		 contact.setGroupe(groupe);
		 contactserv.addContact(contact);
		 String name=contactserv.getContactByIdGroupe(contact.getIdContact()).get(0).getNom();
		 assertEquals("FirstName",name);	 
	 }
	 
	 @Test
	 @Rollback(true)
	 public void testUpdateGroupe(){
		 groupe.setLibelle("club");
		 groupe.setEtat("active");
		 contactserv.addGroupe(groupe);
		 groupe.setLibelle("clubEdited");
		 groupe=contactserv.updateGroupe(groupe);
		 groupe = contactserv.getGroupe(groupe.getIdGroupe());
		 assertEquals("clubEdited",groupe.getLibelle());
		 
	 }

	 
	 @After
		public void tearDown() throws Exception {
		 
	 }
	
}
