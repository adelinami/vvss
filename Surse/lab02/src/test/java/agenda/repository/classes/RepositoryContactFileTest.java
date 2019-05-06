package agenda.repository.classes;

import agenda.exceptions.InvalidFormatException;
import agenda.model.base.Contact;
import agenda.repository.interfaces.RepositoryContact;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RepositoryContactFileTest {

    private Contact con;
    private RepositoryContact repositoryContact;

    @Before
    public void setUp() throws Exception {
        repositoryContact = new RepositoryContactFile();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void addContact_TC1_ECP() {
        try {
            con = new Contact("nume1", "adresa1", "0123456789");
        } catch (InvalidFormatException e) {
            fail();
        }
         
        repositoryContact.addContact(con);
        for(Contact c : repositoryContact.getContacts())
            if (c.equals(con))
            {
                assertTrue(true);
                break;
            }
    }

    @Test
    public void addContact_TC2_ECP() {
        try {
            con = new Contact("", "adresa1", "0123456789");
            fail();
        } catch (InvalidFormatException e) {
            assertTrue(true);
        }
         
        repositoryContact.addContact(con);
        if(repositoryContact.count() == 5)
            fail();
    }

    @Test
    public void addContact_TC3_ECP() {
        try {
            con = new Contact("nume1", "", "0123456789");
            fail();
        } catch (InvalidFormatException e) {
            assertTrue(true);
        }
         
        repositoryContact.addContact(con);
        if(repositoryContact.count() == 5)
            fail();
    }

//    @Test
//    public void addContact_TC2_BVA() {
//        try {
//            con = new Contact(null, "adresa1", "0123456789");
//        } catch (InvalidFormatException e) {
//            fail();
//        }
//
//        repositoryContact.addContact(con);
//        for(Contact c : repositoryContact.getContacts())
//            if (c.equals(con))
//            {
//                assertTrue(true);
//                break;
//            }
//    }

    @Test
    public void addContact_TC3_BVA() {
        try {
            con = new Contact("M", "adresa1", "0123456789");
        } catch (InvalidFormatException e) {
            fail();
        }
         
        repositoryContact.addContact(con);
        for(Contact c : repositoryContact.getContacts())
            if (c.equals(con))
            {
                assertTrue(true);
                break;
            }
    }
//    @Test
//    public void addContact_TC8_BVA() {
//        try {
//            con = new Contact("nume1", null, "0123456789");
//        } catch (InvalidFormatException e) {
//            fail();
//        }
//
//        repositoryContact.addContact(con);
//        for(Contact c : repositoryContact.getContacts())
//            if (c.equals(con))
//            {
//                assertTrue(true);
//                break;
//            }
//    }

    @Test
    public void addContact_TC9_BVA() {
        try {
            con = new Contact("nume1", "M", "0123456789");
        } catch (InvalidFormatException e) {
            fail();
        }
         
        repositoryContact.addContact(con);
        for(Contact c : repositoryContact.getContacts())
            if (c.equals(con))
            {
                assertTrue(true);
                break;
            }
    }
}