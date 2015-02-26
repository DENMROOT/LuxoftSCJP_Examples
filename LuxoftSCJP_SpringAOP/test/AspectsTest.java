import exceptions.ValidationException;
import model.Person;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class AspectsTest {

	protected static final String APPLICATION_CONTEXT_XML_FILE_NAME = "resources/application-context.xml";

	private AbstractApplicationContext context;

	@Before
	public void setUp() throws Exception {
		context = new FileSystemXmlApplicationContext(
				new String[] { APPLICATION_CONTEXT_XML_FILE_NAME });
	}
	
	@Test
	public void testLogging() {
		Person person = (Person) context.getBean("person");
		person.setAge(50);
	}

	@Test(expected= ValidationException.class)
	public void testValidation() {
		Person person = (Person) context.getBean("person");
		person.setAge(101);
		System.out.println(person);
	}

	@Test
	public void testValidationException() {
		try {
			Person person = (Person) context.getBean("person");
			person.setAge(101);
		} catch(ValidationException e) {
			System.out.println("Validation exception occured!");
		}
	}

	@Test
	public void testThrowValidationException() {
		Person person = (Person) context.getBean("person");
		person.setAge(101);
	}
}
