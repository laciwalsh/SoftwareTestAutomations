/*
 * Contact class creates contacts and can be used to return specific contact
 * information.
 */

package contact; 

public class Contact{
	String contactID;
	String firstName;
	String lastName;
	String phone;
	String address;
	
	// constructor - does not allow for null attributes
	public Contact(String ID, String first, String last, String phone, String address) {
		// If ID is null or more than 10 characters
		if (ID == null || ID.length() > 10) {
			throw new IllegalArgumentException("Invalid ID");
		}
		
		// If first name is null or longer than 10 characters
		if (first == null || first.length() > 10) {
			throw new IllegalArgumentException("Invalid First Name");
		}
		
		// If last name is null or longer than 10 characters
		if (last == null || last.length() > 10) {
			throw new IllegalArgumentException("Invalid Last Name");
		}
		
		// If phone number is null or not exactly 10 characters long
		if (phone == null || phone.length() != 10) {
			throw new IllegalArgumentException("Invalid Phone Number");
		}
		
		// If address is null or longer than 30 characters
		if (address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid Address");
		}
		
		// if all requirements met, store data in corresponding variables
		this.contactID = ID;
		this.firstName = first;
		this.lastName = last;
		this.phone = phone;
		this.address = address;
	}
	
	// get ID
	public String getID() {
		return this.contactID;
	}
	// get First Name
	public String getFirst() {
		return this.firstName;
	}
	
	// get Last Name
	public String getLast() {
		return this.lastName;
	}
	
	// get Phone Number
	public String getPhone() {
		return this.phone;
	}
	
	// get Address
	public String getAddress() {
		return this.address;
	}
}