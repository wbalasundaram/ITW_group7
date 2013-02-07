package hibernateManagers;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.Test;

public class FormFieldsManagerTest {

	@Test
	public void testretrieve() {
		Map<Integer,List<String>> result = FormFieldsManager.retrieve(1);
		assertNotNull("Result not null", result);
		assertTrue("Result not empty", result.size() > 0);
	}

}
