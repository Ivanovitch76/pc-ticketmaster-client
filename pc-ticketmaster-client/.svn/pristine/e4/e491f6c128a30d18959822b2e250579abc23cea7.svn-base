package be.steformations.pc.ticketmaster.client;

import be.steformations.pc.ticketmaster.common.beans.Booking;
import be.steformations.pc.ticketmaster.common.beans.Show;
import be.steformations.pc.ticketmaster.common.service.TicketMasterService;

public class TicketMasterClient {

	TicketMasterService service;
	
	public TicketMasterClient(
			java.net.URL wsdl, javax.xml.namespace.QName qname,
			String jndiServerUrl, int jndiServerPort,
			String jmsConnectionFactoryJndi, String jmsDestinationJndi) {
		super();
		this.service = javax.xml.ws.Service.create(wsdl, qname).getPort(TicketMasterService.class);
		try {
			TicketMasterJmsConsumer jmsConsumer
				= new TicketMasterJmsConsumer(jndiServerUrl, jndiServerPort, 
						jmsConnectionFactoryJndi, jmsDestinationJndi);
			jmsConsumer.start();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public Show createShow(String title, int year, int month, int day, int hour, int minutes, int venue) {
		return service.createShow(title, year, month, day, hour, minutes, venue);
	}

	public Booking createBooking(int show, int client) {
		return service.createBooking(show, client);
	}
	
	private static class TicketMasterJmsConsumer extends Thread {
		
		private javax.jms.Connection connection;
		private javax.jms.MessageConsumer messageConsumer;
		
		public TicketMasterJmsConsumer(String jndiServerUrl, int jndiServerPort, 
				String jmsConnectionFactoryJndi, String jmsDestinationJndi) throws Exception {
			super();
			java.util.Properties config = new java.util.Properties();
			config.put("java.naming.provider.url", String.format("%s:%s", jndiServerUrl, jndiServerPort));
			javax.naming.InitialContext initialContext 
				= new javax.naming.InitialContext(config);
			javax.jms.ConnectionFactory connectionFactory
				= (javax.jms.ConnectionFactory) initialContext.lookup(jmsConnectionFactoryJndi);
			javax.jms.Destination destination 
				= (javax.jms.Destination) initialContext.lookup(jmsDestinationJndi);
			this.connection = connectionFactory.createConnection();
			this.messageConsumer = this.connection.createSession().createConsumer(destination);
		}
		
		@Override
		public void run() {
			System.out.println("TicketMasterClient.TicketMasterJmsConsumer.run()");
			try {
				this.connection.start();
				// while(true) {
					javax.jms.Message message = this.messageConsumer.receive();
					System.out.println("TicketMasterClient.TicketMasterJmsConsumer.received"
								+ " => " + ((javax.jms.ObjectMessage) message).getObject());
				//}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
}
