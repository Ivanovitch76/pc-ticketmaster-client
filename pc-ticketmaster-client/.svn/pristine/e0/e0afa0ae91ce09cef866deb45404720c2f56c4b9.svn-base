package be.steformations.pc.ticketmaster.client.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import be.steformations.pc.ticketmaster.client.TicketMasterClient;
import be.steformations.pc.ticketmaster.common.beans.Booking;

public class TestCreateBooking {

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
	public void testCreateBooking() {
		Booking booking = this.client.createBooking(1, 1);
		assertNotNull(booking);
		assertNotNull(booking.getId());
		assertEquals(this.helper.createStradella(), booking.getShow());
		assertEquals(this.helper.createBettyBoop(), booking.getClient());
	}

}
