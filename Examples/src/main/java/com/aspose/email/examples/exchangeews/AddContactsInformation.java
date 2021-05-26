package com.aspose.email.examples.exchangeews;

import com.aspose.email.AssociatedPerson;
import com.aspose.email.AssociatedPersonCategory;
import com.aspose.email.Contact;
import com.aspose.email.EWSClient;
import com.aspose.email.EmailAddress;
import com.aspose.email.EmailAddressCategory;
import com.aspose.email.Gender;
import com.aspose.email.IEWSClient;
import com.aspose.email.PhoneNumber;
import com.aspose.email.PhoneNumberCategory;
import com.aspose.email.Url;
import com.aspose.email.UrlCategory;
import com.aspose.email.system.NetworkCredential;
import com.aspose.email.system.exceptions.Exception;

public class AddContactsInformation {

	public static void main(String[] args) {

		addContact();
	}

	public static void addContact()
	{
		//ExStart: AddContactsInformation
		String mailboxUri = "https://ex2010/exchangeews/exchange.asmx";
		String username = "test.exchange";
		String password = "pwd";
		String domain = "ex2010.local";
		NetworkCredential credentials = new NetworkCredential(username, password, domain);
		IEWSClient client = EWSClient.getEWSClient(mailboxUri, credentials);

		//Create New Contact
		Contact contact = new Contact();

		//Set general info
		contact.setGender(Gender.Male);
		contact.setDisplayName("Frank Lin");
		contact.setCompanyName("ABC Co.");
		contact.setJobTitle("Executive Manager");

		//Add Phone numbers
		PhoneNumber phoneNumber = new PhoneNumber();
		phoneNumber.setNumber("123456789");
		phoneNumber.setCategory(PhoneNumberCategory.getHome());
		contact.getPhoneNumbers().add(phoneNumber);

		//contact's associated persons
		AssociatedPerson person = new AssociatedPerson();
		person.setName("Catherine");
		person.setCategory(AssociatedPersonCategory.getSpouse());
		contact.getAssociatedPersons().add(person);

		person = new AssociatedPerson();
		person.setName("Bob");
		person.setCategory(AssociatedPersonCategory.getChild());
		contact.getAssociatedPersons().add(person);

		person = new AssociatedPerson();
		person.setName("Merry");
		person.setCategory(AssociatedPersonCategory.getSister());
		contact.getAssociatedPersons().add(person);

		//URLs
		Url url = new Url();
		url.setCategory(UrlCategory.getBlog());
		url.setHref("www.blog.com");
		contact.getUrls().add(url);

		url = new Url();
		url.setCategory(UrlCategory.getHomePage());
		url.setHref("www.homepage.com");
		contact.getUrls().add(url);

		//Set contact's Email address
		EmailAddress address = new EmailAddress();
		address.setAddress("Frank.Lin@Abc.com");
		address.setDisplayName("Frank Lin");
		EmailAddressCategory.getCustom();
		address.setCategory(EmailAddressCategory.getEmail1());

		try
		{
			client.createContact(contact);
		}
		catch (Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		//ExEnd: AddContactsInformation
	}


}
