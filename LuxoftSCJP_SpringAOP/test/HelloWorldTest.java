import static org.junit.Assert.* ;

import org.junit.*;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import model.CountryImpl;
import model.Person;
import model.UsualPerson;
import model.Person;
import model.Country;

import java.util.Arrays;

public class HelloWorldTest {

	protected static final String APPLICATION_CONTEXT_XML_FILE_NAME = "resources/application-context.xml";

	private Person expectedPerson;

	private AbstractApplicationContext context;

	@Before
	public void setUp() throws Exception {
		context = new FileSystemXmlApplicationContext(
				new String[] { APPLICATION_CONTEXT_XML_FILE_NAME });
		expectedPerson = getExpectedPerson();
	}

	@Test
	public void testInitPerson() {
		Person person = (Person) context.getBean("person", Person.class);
		assertEquals(expectedPerson, person);
		System.out.println(person);
	}

	private Person getExpectedPerson() {
		UsualPerson person = new UsualPerson();
		person.setAge(35);
		person.setName("John Smith");
		person.setHeight(1.78F);
		person.setIsProgrammer(true);
		person.setContacts(Arrays.asList("asd@asd.ru", "+7-234-456-67-89"));
		System.out.println(person.getContacts());

		Country country = new CountryImpl();
		country.setId(1);
		country.setName("Russia");
		country.setCodeName("RU");

		person.setCountry(country);

		return person;
	}
	
	@After
	public void tearDown() throws Exception{
		if (context != null)
			context.close();
	}
}
