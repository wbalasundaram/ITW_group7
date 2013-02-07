package XMLParse;

import static org.junit.Assert.*;

import org.junit.Test;

public class xmlParserTest {

	@Test
	public void testunwrapXMLInvalidInput() {
		assertNull("Parse invalid XML", xmlParser.unwrapXml("someinvalidxml"));
	}

	@Test
	public void testunwrapXMLValidInput() {
		String[][] result = xmlParser.unwrapXml("<root><Elem1 Attr1=\"Test\" /></root>");
		assertNotNull("Parse valid XML", result);
	}

	@Test
	public void testunwrapXMLValidInput2() {
		String[][] result = xmlParser.unwrapXml("<root><Elem1 Attr1=\"Test\" />stop</root>");
		assertNotNull("Parse valid XML", result);
	}
}
