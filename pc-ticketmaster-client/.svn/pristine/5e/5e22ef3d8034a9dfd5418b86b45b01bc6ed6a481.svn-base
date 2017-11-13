package be.steformations.pc.ticketmaster.client.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import be.steformations.pc.ticketmaster.client.TicketMasterClient;
import be.steformations.pc.ticketmaster.common.beans.Show;

public class TestCreateShow {

	private TicketMasterClient client;
	private TestHelper helper = new TestHelper();
	
	@Before
	public void setUp() throws Exception {
		java.net.URL wsdl = new java.net.URL("http://localhost:8080/SoapTicketMasterService/SoapTicketMasterService?wsdl");
		javax.xml.namespace.QName qname
			= new javax.xml.namespace.QName("be.steformations.pc.ticketmaster", "SoapTicketMasterService");
		this.client = new TicketMasterClient(
				wsdl, qname, "localhost", 3700, 
				"jms/TicketMasterConnectionFactory", "jms/TicketMasterDestination");
	}

	@Test
	public void testCreateShow() {
		Show source = this.helper.createNew();
		java.util.Calendar cal = java.util.GregorianCalendar.getInstance();
		cal.setTime(source.getDay());
		int year = cal.get(java.util.Calendar.YEAR);
		int month = cal.get(java.util.Calendar.MONTH) + 1;
		int day = cal.get(java.util.Calendar.DAY_OF_MONTH);
		cal.setTime(source.getTime());
		int hour = cal.get(java.util.Calendar.HOUR_OF_DAY);
		int minutes = cal.get(java.util.Calendar.MINUTE);
		
		Show created = this.client.createShow(source.getTitle(), year, month, day, 
				hour, minutes, source.getVenue().getId());
		
		assertNotNull(created);
		assertNotNull(created.getId());
		assertEquals(source.getTitle(), created.getTitle());
		assertEquals(source.getVenue(), created.getVenue());
		assertEquals(source.getDay(), created.getDay());
		assertEquals(source.getTime(), created.getTime());
	}

}
