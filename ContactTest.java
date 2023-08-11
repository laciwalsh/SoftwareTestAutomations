/*
 * Test for Contact class
 */

package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import contact.Contact;

class ContactTest {

	//String ID, String first, String last, String phone, String address
	@Test
	void testContactClass() {
		Contact contact = new Contact("181800", "Harry", "Potter", "1123581321", "4 Privet Drive");
		assertTrue(contact.getFirst().equals("Harry"));
		assertTrue(contact.getLast().equals("Potter"));
		assertTrue(contact.getID().equals("181800"));
		assertTrue(contact.getPhone().equals("1123581321"));
		assertTrue(contact.getAddress().equals("4 Privet Drive")); 
	}
	
	//Test ID length > 10
	@Test
	void testIDTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345678910", "Harry", "Potter", "1123581321", "4 Privet Drive");
		});
	}
	
	// Test ID length < 10
	@Test
	void testIDLessThan10() {
		Assertions.assertDoesNotThrow(() -> {
			new Contact("112358", "Harry", "Potter", "1123581321", "4 Privet Drive");
		});
	}
	
	// Test ID length == 10
	@Test
	void testIDEqualTo10() {
		Assertions.assertDoesNotThrow(() -> {
			new Contact("1123581327", "Harry", "Potter", "1123581321", "4 Privet Drive");
		});
	}
	
	// Test for null ID
	@Test
	void testIDNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "Harry", "Potter", "1123581321", "4 Privet Drive");
		});
	}
	
	// Test for first name > 10
	@Test
	void testFirstTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("181800", "Occieanniaa", "Potter", "1123581321", "4 Privet Drive");
		});
	}
	
	// Test for first name < 10
	@Test
	void testFirstLessThan10() {
		Assertions.assertDoesNotThrow(() -> {
			new Contact("181800", "Harry", "Potter", "1123581321", "4 Privet Drive");
		});
	}
	
	// Test for fist name == 10
	@Test
	void testFirstEqualTo10() {
		Assertions.assertDoesNotThrow(() -> {
			new Contact("181800", "Occieannia", "Potter", "1123581321", "4 Privet Drive");
		});
	}
	
	// Test for first name null
	@Test
	void testFirstIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567891", null, "Potter", "1123581321", "4 Privet Drive");
		});
	}
	
	// Test for last name > 10
	@Test
	void testLastTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567891", "Harry", "Potter56699", "1123581321", "4 Privet Drive");
		});
	}
	
	// Test for last name < 10
	@Test
	void testLastLessThan10() {
		Assertions.assertDoesNotThrow(() -> {
			new Contact("1234567891", "Harry", "Potter", "1123581321", "4 Privet Drive");
		});
	}
	
	// Test for last name == 10
	@Test
	void testLastEqualTo10() {
		Assertions.assertDoesNotThrow(() -> {
			new Contact("1234567891", "Harry", "Potter1234", "1123581321", "4 Privet Drive");
		});
	}
	
	// Test for last name null
	@Test
	void testLastIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567891", "Harry", null, "1123581321", "4 Privet Drive");
		});
	}
	
	// Test if phone number > 10
	@Test
	void testPhoneNotTen() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567891", "Harry", "Potter", "01123581321", "4 Privet Drive");
		});
	}
	
	// Test if phone number < 10
	@Test
	void testPhoneNumberLessThan10() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567891", "Harry", "Potter", "11235813", "4 Privet Drive");
		});
	}
	
	// Test if phone number == 10
	@Test
	void testPhoneNumberEqualTo10() {
		Assertions.assertDoesNotThrow(() -> {
			new Contact("1234567891", "Harry", "Potter", "1123581321", "4 Privet Drive");
		});
	}
	
	// Test if phone number contains non digits
	@Test
	void testPhoneNumberNotDigits() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567891", "Harry", "Potter", "11235B1327", "4 Privet Drive");
		});
	}
	
	// Test if phone number is null
	@Test
	void testPhoneIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567891", "Harry", "Potter", null, "4 Privet Drive");
		});
	}
	
	// Test if address > 30
	@Test
	void testAddressTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567891", "Harry", "Potter", "1123581321", "Hogwarts School Of Witchcraft and Wizadry");
		});
	}
	
	// Test if address < 30
	@Test
	void testAddressLessThan30() {
		Assertions.assertDoesNotThrow(() -> {
			new Contact("1234567891", "Harry", "Potter", "1123581321", "4 Privet Drive");
		});
	}
	
	// Test if address == 30
	@Test
	void testAddressExactly30() {
		Assertions.assertDoesNotThrow(() -> {
			new Contact("1234567891", "Harry", "Potter", "1123581321", "This Address is Exactly 30long");
		});
	}
	
	// Test if address null
	@Test
	void testAddressIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567891", "Harry", "Potter", "1123581321", null);
		});
	}

}
