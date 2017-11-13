package be.steformations.pc.ticketmaster.client.tests;

import be.steformations.pc.ticketmaster.common.beans.Client;
import be.steformations.pc.ticketmaster.common.beans.Show;
import be.steformations.pc.ticketmaster.common.beans.Venue;

public class TestHelper {

	public Venue createORW() {
		Venue v = new Venue();
		v.setId(1);
		v.setName("Opera Royal de Wallonie");
		v.setCapacity(1033);
		return v;
	}
	
	public Show createStradella() {
		Show s = new Show();
		java.util.Calendar cal = java.util.GregorianCalendar.getInstance();
		cal.set(java.util.Calendar.MILLISECOND, 0);
		s.setId(1);
		s.setTitle("Stradella");
		s.setVenue(this.createORW());
		cal.set(2017, 8, 19, 0, 0, 0);
		s.setDay(cal.getTime());
		cal.set(1970, 0, 1, 20, 0, 0);
		s.setTime(cal.getTime());
		return s;
	}
	
	public Show createNew() {
		Show s = new Show();
		java.util.Calendar cal = java.util.GregorianCalendar.getInstance();
		s.setTitle("new-show-" + System.currentTimeMillis());
		s.setVenue(this.createORW());
		cal.set(java.util.Calendar.HOUR_OF_DAY, 0);
		cal.set(java.util.Calendar.MINUTE, 0);
		cal.set(java.util.Calendar.SECOND, 0);
		cal.set(java.util.Calendar.MILLISECOND, 0);
		s.setDay(cal.getTime());
		cal.set(1970, 0, 1, 20, 0, 0);
		s.setTime(cal.getTime());
		return s;
	}
	
	public Client createBettyBoop() {
		Client c = new Client();
		c.setId(1);
		c.setName("Betty Boop");
		c.setIban("US18 1234 5678 9012");
		c.setEmail("pascal.cornet@uliege.be");
		return c;
	}
}
