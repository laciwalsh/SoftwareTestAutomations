# SoftwareTestAutomations
How can I ensure that my code, program, or software is functional and secure?
I ensure that my code, program, or software is functional and secure by creating JUnit tests that provide high percentage coverage. These tests ensure the program meets the requirements for the project by testing the creation of objects, verifying user input is valid, and ensuring that the program processes exceptions as expected. An example of verifying valid user input can be found in the ContactTest file where one of the tests attempts to create a contact with the lastName field exceeding the 10 character limit. This test properly throws the correct exception which verifies that the program is working as intended.

How do I interpret user needs and incorperate them into a program?
I use the requirements documents to interpret user needs and incorperate them into a program. For example, one of the requirements of the ContactService class is that the class should be able to delete contacts per contactID. This is incorperated by including a method in the ContactService file that searches for a Contact object by the ID and deleting the contact.

How do I approach designing software?
My approach for designing software revolves around understanding the requirements. If there is a misunderstanding in the requiremens, the final product might not meet the needs of the user. After understanding the requirements, I begin planning out the code. This includes determining the attributes and methods of each class and how the different classes will interact. After creating the code, creating tests for each object and method is the next step to ensure the program will function as intended.
