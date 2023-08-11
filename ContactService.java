/*
 * Contact Service class allows contacts to be added and deleted.
 * It also allows the modification of some attributes
 */

package contact;
import java.util.Vector;

public class ContactService {
	public Vector<Contact> contactList = new Vector<Contact>(0);
	int ID = 1;
	
	
	// Creates an ID
	public String GetID() {
		// resets ID to 1 if contact list is empty 
		if (contactList.isEmpty() ) {
			ID = 1;
		}
		String IDString = String.valueOf(ID);
		
		// increment ID to create unique IDs for each contact
		++ ID;
		return IDString;
		
	}
	
	// Adds new contact
	public void AddNewContact(String first, String last, String phone, String address) {
		 
		// get new ID for new contact
		String ID = GetID();
		
		// check that contact doesn't already exist
		for (int i = 0; i < contactList.size(); ++i) {
			if (contactList.elementAt(i).getFirst() == first && contactList.elementAt(i).getLast() == last && contactList.elementAt(i).getPhone() == phone &&
					contactList.elementAt(i).getAddress() == address) {
				throw new IllegalArgumentException("Contact already exists");
			}
		}
		Contact newContact = new Contact(ID, first, last, phone, address);
		// add new contact to contact list
		contactList.add(newContact);
	}
	
	// Deletes contact
	public void DeleteContact(String ID) {
		// Search for contact by ID
		for (int i = 0; i < contactList.size(); ++i) {
			if (contactList.elementAt(i).contactID.compareTo(ID) == 0) {
				// remove contact if found
				contactList.removeElementAt(i);
			}
		}
	}
	
	// update first name
	public void updateFirstName(String ID, String first) {
		if (first.length() > 10) {
			throw new IllegalArgumentException("Invalid First Name");
		}
		// Search for contact by ID
		for (int i = 0; i < contactList.size(); ++i) {
			if (contactList.elementAt(i).contactID.compareTo(ID) == 0) {
				contactList.elementAt(i).firstName = first;
			}
		}
	}
	
	// update last name
	public void updateLastName(String ID, String last) {
		if (last.length() > 10) {
			throw new IllegalArgumentException("Invalid Last Name");
		}
		// Search for contact by ID
		for (int i = 0; i < contactList.size(); ++i) {
			if (contactList.elementAt(i).contactID.compareTo(ID) == 0) {
				contactList.elementAt(i).lastName = last;
			}
		}
	}
	
	// update phone number
	public void updateNumber(String ID, String number) {
		if (number.length() != 10 || !number.matches("[0-9]+")) {
			throw new IllegalArgumentException("Invalid Phone Number");
		}
		// Search for contact by ID
		for (int i = 0; i < contactList.size(); ++i) {
			if (contactList.elementAt(i).contactID.compareTo(ID) == 0) {
				contactList.elementAt(i).phone = number;
			}
		}
	}
	
	// update address
	public void updateAddress(String ID, String address) {
		if (address.length() > 30) {
			throw new IllegalArgumentException("Invalid Address");
		}
		// Search for contact by ID
		for (int i = 0; i < contactList.size(); ++i) {
			if (contactList.elementAt(i).contactID.compareTo(ID) == 0) {
				contactList.elementAt(i).address = address;
			}
		}
	}
	
	// return a contact
	public Contact getContact(String ID) {
		// Search for contact by ID
		for (int i = 0; i < contactList.size(); ++i) {
			if (contactList.elementAt(i).contactID.compareTo(ID) == 0) {
				return contactList.elementAt(i);
			}
		}
		return null;
	}

}