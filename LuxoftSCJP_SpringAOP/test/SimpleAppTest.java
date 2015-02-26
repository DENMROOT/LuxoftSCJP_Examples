import static org.junit.Assert.*;

import org.junit.*;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.CountryImpl;
import model.Person;
import model.UsualPerson;
import model.Country;

import java.util.List;
import java.util.ArrayList;

public class SimpleAppTest {
	
	protected static final String APPLICATION_CONTEXT_XML_FILE_NAME = "classpath:application-context.xml";

	private AbstractApplicationContext context;

	private Person expectedPerson;

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext(
				APPLICATION_CONTEXT_XML_FILE_NAME);
		expectedPerson = getExpectedPerson();
	}

	@Test
	public void testInitPerson() {
		Person person = (Person) context.getBean("person");
//		FYI: Another way to achieve the bean
//		person = context.getBean(UsualPerson.class);
//		assertTrue(expectedPerson.equals(person));
		person.setAge(100);
		System.out.println(person);
	}

	private Person getExpectedPerson() {
		UsualPerson person = new UsualPerson();
		person.setAge(35);
		person.setHeight(1.78F);
		person.setIsProgrammer(true);
		person.setName("John Smith");

		Country country = new CountryImpl();
		country.setId(1);
		country.setName("Russia");
		country.setCodeName("RU");

		person.setCountry(country);

		List<String> contacts = new ArrayList<String>();
		contacts.add("asd@asd.ru");
		contacts.add("+7-234-456-67-89");

		person.setContacts(contacts);

		return person;
	}
}
