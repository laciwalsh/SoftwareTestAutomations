/*
 * Test for ContactService class
 */

package test;


import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
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
	
	// Test updating first name with a valid name
	@Test
	void TestUpdateValidFirstName() {
		// create test object
		test.AddNewContact("Sherlock", "Holmes", "1234567890", "221a Baker Street");
		
		// check that first name is correct
		assertEquals(test.getContact("1").getFirst(), "Sherlock");
		
		// change first name < 10 characters
		test.updateFirstName("1", "Thomas");
		
		// check that first name change worked
		assertEquals(test.getContact("1").getFirst(), "Thomas");
		
		// check first name == 10
		Assertions.assertDoesNotThrow(() -> {
			test.updateFirstName("1", "Thomassons");
		});
		
		
	}
	
	// Test changing first name to name > 10 characters
	@Test 
	void TestUpdateInvalidName() {
		test.AddNewContact("Sherlock", "Holmes", "1234567890", "221a Baker Street");
		
		// check that first name is correct
		assertEquals(test.getContact("1").getFirst(), "Sherlock");
		
		// try to change name
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			test.updateFirstName("1", "TooLongFirstName");
		});
		
		// Check that name wasn't updated
		assertEquals(test.getContact("1").getFirst(), "Sherlock");
		
	}
	
	// Test updating last name  to valid last name
	@Test
	void TestUpdateLastName() {
		// create test object
		test.AddNewContact("Sherlock", "Holmes", "1234567890", "221a Baker Street");
				
		// check that last name is correct
		assertEquals(test.getContact("1").getLast(), "Holmes");
				
		// change last name
		test.updateLastName("1", "Jones");
				
		// check that last name change worked
		assertEquals(test.getContact("1").getLast(), "Jones");
		
		// check if last name == 10 characters
		Assertions.assertDoesNotThrow(() -> {
			test.updateLastName("1", "Jonesenses");
		});
	}
	
	// Test updating last name to invalid last name
	@Test
	void TestUpdateInvalidLastName() {
		// create contact
		test.AddNewContact("Sherlock", "Holmes", "1234567890", "221a Baker Street");
		
		// check that last name is correct
		assertEquals(test.getContact("1").getLast(), "Holmes");
		
		// try to change name
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			test.updateLastName("1", "TooLongLastName");
		});
		
		// check that name wasn't changed
		assertEquals(test.getContact("1").getLast(), "Holmes");
			
	}
	
	// Testing updating valid phone number
	@Test
	void TestUpdateNumber() {
		// create test object
		test.AddNewContact("Sherlock", "Holmes", "1234567890", "221a Baker Street");
						
		// check that phone number is correct
		assertEquals(test.getContact("1").getPhone(), "1234567890");
						
		// change phone number
		test.updateNumber("1", "0987654321");
						
		// check that last name change worked
		assertEquals(test.getContact("1").getPhone(), "0987654321");
	}
	
	// Test updating invalid phone number
	@Test
	void TestUpdateInvalidNumber() {
		// create test object 
		test.AddNewContact("Sherlock", "Holmes", "1234567890", "221a Baker Street");
		
		// try to change with number > 10
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			test.updateNumber("1", "123456789102");
		});
		
		// check that change did not occur
		assertEquals(test.getContact("1").getPhone(), "1234567890");
		
		// try to change with number < 10
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			test.updateNumber("1", "1234");
		});
		
		// check that change did not occur
		assertEquals(test.getContact("1").getPhone(), "1234567890");
		
		// try to change with non digit characters
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			test.updateNumber("1", "1234567B90");
		});
		
		// check that change did not occur
		assertEquals(test.getContact("1").getPhone(), "1234567890");
		
	}
	
	// Test updating address with valid length
	@Test
	void TestUpdateValidAddress() {
		// create test object
		test.AddNewContact("Sherlock", "Holmes", "1234567890", "221a Baker Street");
						
		// check that address is correct
		assertEquals(test.getContact("1").getAddress(), "221a Baker Street");
						
		// change address
		test.updateAddress("1", "221b Baker Street");
						
		// check that address change worked
		assertEquals(test.getContact("1").getAddress(), "221b Baker Street");
		
		// try with exactly 30 characters
		Assertions.assertDoesNotThrow(() -> {
			test.updateAddress("1", "This is a test 30 character ad");
		});
		
		// check that address change worked
		assertEquals(test.getContact("1").getAddress(), "This is a test 30 character ad");
	}
	
	// Test updating address with invalid length
	@Test
	void TestUpdateInvalidAddress() {
		// create test object
		test.AddNewContact("Sherlock", "Holmes", "1234567890", "221a Baker Street");
		
		// Try to change with address > 30
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			test.updateAddress("1", "This is a super long address that should thow an exception");
		});
		
		// check that address wasn't changed
		assertEquals(test.getContact("1").getAddress(), "221a Baker Street");
	}
	
	// Test getting contact
	@Test
	void TestGetContact() {
		// check that unused ID returns null object
		assertNull(test.getContact("1"));
		
		
		// create test object
		test.AddNewContact("Sherlock", "Holmes", "1234567890", "221a Baker Street");
		
		assertNotNull(test.getContact("1"));
	}
	
	// Test creating duplicate contact
	@Test
	void TestDuplicateContact() {
		test.AddNewContact("Sherlock", "Holmes", "1234567890", "221a Baker Street");
		
		// attempt to create duplicate contact - should not work
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			test.AddNewContact("Sherlock", "Holmes", "1234567890", "221a Baker Street");
		});
		
		// creating contact with 1 different character - should work
		Assertions.assertDoesNotThrow(() -> {
			test.AddNewContact("Sherloch", "Holmes", "1234567890", "221a Baker Street");
		});
	}

}
