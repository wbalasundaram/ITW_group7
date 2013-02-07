package RESTservices;

import static org.junit.Assert.*;

import javax.ws.rs.core.GenericEntity;

import org.junit.Test;

public class FilledFormServiceTest {

	@Test
	public void testgetRecordsDataJSON() {
		FilledFormService service = new FilledFormService();
		GenericEntity<String> result = service.getRecordsDataJSON();
		assertNotNull("Result not null", result);
		assertTrue("Result not empty", result.getEntity().length() > 0);
	}

}
