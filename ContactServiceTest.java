/*
 * Test for ContactService class
 */

package test;


import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import contact.ContactService;

class ContactServiceTest {
	ContactService test = new ContactService();

	
	// clear contactList before each test so that ID is reset (See GetID() in ContactService)
	@BeforeEach
	void resetList() {
		test.contactList.clear();
	}
	
	// Test getting ID
	@Test
	void TestGetID() {
		// ensures first ID will be 1
		String ID = test.GetID();
		assertTrue(ID.equals("1"));
		
		// create new contact that will have ID of 1
		test.AddNewContact("Sherlock", "Holmes", "1234567890", "221a Baker Street");
		
		// ensures next ID will be 2
		String ID2 = test.GetID();
		assertTrue(ID2.equals("2"));
	}
	
	// Test adding new contacts to vector
	@Test
	void TestAddNewContact() { 
		// before contact is added 
		assertTrue(test.contactList.isEmpty());
		
		test.AddNewContact("Harry", "Potter", "1123581321", "4 Privet Drive");
		// after contact is added
		assertEquals(1, test.contactList.size());
		
		test.AddNewContact("Sherlock", "Holmes", "1234567890", "221a Baker Street");
		
		// after second contact is added
		assertEquals(2, test.contactList.size());
		
	}
	
	// Test deleting contacts
	@Test
	void TestDeletContact() {
		// add new contacts to be deleted
		test.AddNewContact("Harry", "Potter", "1123581321", "4 Privet Drive");
		test.AddNewContact("Sherlock", "Holmes", "1234567890", "221a Baker Street");
		assertEquals(2, test.contactList.size());
		
		// delete contacts
		test.DeleteContact("1");
		test.DeleteContact("2");
		
		// test that list is now empty
		assertEquals(0, test.contactList.size());
		
	}
	
	// Test updating first name
	@Test
	void TestUpdateFirstName() {
		// create test object
		test.AddNewContact("Sherlock", "Holmes", "1234567890", "221a Baker Street");
		
		// check that first name is correct
		assertTrue(test.getContact("1").getFirst().compareTo("Sherlock") == 0);
		
		// change first name
		test.updateFirstName("1", "Thomas");
		
		// check that first name change worked
		assertTrue(test.getContact("1").getFirst().compareTo("Thomas") == 0);
		
	}
	
	// Test updating last name
	@Test
	void TestUpdateLastName() {
		// create test object
		test.AddNewContact("Sherlock", "Holmes", "1234567890", "221a Baker Street");
				
		// check that last name is correct
		assertTrue(test.getContact("1").getLast().compareTo("Holmes") == 0);
				
		// change last name
		test.updateLastName("1", "Jones");
				
		// check that last name change worked
		assertTrue(test.getContact("1").getLast().compareTo("Jones") == 0);
	}
	
	// Testing updating phone number
	@Test
	void TestUpdateNumber() {
		// create test object
		test.AddNewContact("Sherlock", "Holmes", "1234567890", "221a Baker Street");
						
		// check that phone number is correct
		assertTrue(test.getContact("1").getPhone().compareTo("1234567890") == 0);
						
		// change phone number
		test.updateNumber("1", "0987654321");
						
		// check that last name change worked
		assertTrue(test.getContact("1").getPhone().compareTo("0987654321") == 0);
	}
	
	// Test updating address
	@Test
	void TestUpdateAddress() {
		// create test object
		test.AddNewContact("Sherlock", "Holmes", "1234567890", "221a Baker Street");
						
		// check that address is correct
		assertTrue(test.getContact("1").getAddress().compareTo("221a Baker Street") == 0);
						
		// change last name
		test.updateAddress("1", "221b Baker Street");
						
		// check that last name change worked
		assertTrue(test.getContact("1").getAddress().compareTo("221b Baker Street") == 0);
	}
	
	@Test
	void TestGetContact() {
		// check that unused ID returns null object
		assertTrue(test.getContact("1") == null);
		
		// create test object
		test.AddNewContact("Sherlock", "Holmes", "1234567890", "221a Baker Street");
		
		assertTrue(test.getContact("1") != null);
	}

}
