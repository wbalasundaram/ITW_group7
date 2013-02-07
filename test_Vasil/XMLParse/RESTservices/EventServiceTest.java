package RESTservices;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Map;

import org.junit.Test;

public class EventServiceTest {

	@Test
	public void testgeEventsJSON() {
		EventService service = new EventService();
		Map<Integer,ArrayList<String>> result = service.geEventsJSON();
		assertNotNull("Result not null", result);
		assertTrue("Result not empty", result.size() > 0);
	}

}
