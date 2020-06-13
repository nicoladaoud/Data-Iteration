package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import AppGUI;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AppGUITest {

	AppGUI gui = new AppGUI();
	
	@Test
	/**
	 * Check if user info is empty.
	 */
	void test_initial_userInfo() {
		assertEquals("", gui.getUserEmail());
		assertEquals("", gui.getUserFirstName());
	}
	
	
	@Test
	/**
	 * Check if the PDF file viewer is not corrupted.
	 */
	void test_initial_pdf_viwer() {
		assertEquals(null, gui.getController());
		assertEquals(null, gui.getFilePath());
	}
	
	@Test
	/**
	 * Check if the admin information is corrupted.
	 */
	void test_admin_status() {
		assertEquals("", gui.getAdminId());
		assertEquals("", gui.getAdminPass());
	}

}
