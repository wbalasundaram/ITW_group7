package hibernateManagers;

import static org.junit.Assert.*;

import hibernateEntities.User;

import java.util.ArrayList;

import org.junit.Test;

public class CharityLoginManagerTest {

	@Test
	public void testExistingUser() {
		ArrayList<User> usr = CharityLoginManager.getUsers("amartin", "hibernate.cfg.xml");
		assertNotNull("Users not null", usr);
		assertTrue("At least one user returned", usr.size() > 0);
		//fail("Not yet implemented");
	}

	@Test
	public void testNonExistingUser() {
		ArrayList<User> usr = CharityLoginManager.getUsers("nonexusr", "hibernate.cfg.xml");
		assertNotNull("Users not null", usr);
		assertTrue("No user returned", usr.size() == 0);
		//fail("Not yet implemented");
	}
}
