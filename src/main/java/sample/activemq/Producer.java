package sample.activemq;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

@Component
public class Producer implements CommandLineRunner {
	@Autowired
	private JmsTemplate JmsTemplate;
	
	//@Autowired
	//private JmsListenerContainerFactory<?> myJmsContainerFactory;

	@Override
	@Order(value=1) 
	public void run(String... arg0) throws Exception {
		send("Sample message");
		System.out.println("Message was sent to the Queue");
		
	}
	public void send(final String msg){
		//this.jmsMessagingTemplate.convertAndSend(this.myJmsListenerContainerFactory, msg);
		//this.JmsTemplate.setConnectionFactory(ConnectionFactory ConnectionFactory);
		//System.out.println(this.JmsTemplate.getConnectionFactory());
		this.JmsTemplate.setPubSubDomain(true);
		this.JmsTemplate.send("OKChemDataSyncTopic",new MessageCreator() {
			
			@Override
			public Message createMessage(Session session) throws JMSException {
				// TODO Auto-generated method stub
				//return null;
				return session.createTextMessage(msg);
			}
		});
	}
	

	
	
}
