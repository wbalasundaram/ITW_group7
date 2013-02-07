package staticResources;

import static org.junit.Assert.*;

import org.junit.Test;

public class PasswordEncryptionTest {

	@Test
	public void testEncryptPassword() {
		assertNotSame("", PasswordEncryption.createSalt());
	}

}
