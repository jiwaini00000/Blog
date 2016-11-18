package sample.activemq;

import javax.jms.JMSException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleActiveMqTests {

	@Autowired
	private Producer producer;
	
	@Test
	public void sendSimpleMessage() throws InterruptedException, JMSException{
		this.producer.send("Test Message");
		Thread.sleep(1000L);
	}
	
}
