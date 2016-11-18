package sample.activemq;



import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.RedeliveryPolicy;
import org.apache.activemq.broker.region.policy.RedeliveryPolicyMap;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.config.SimpleJmsListenerContainerFactory;

@SpringBootApplication
@EnableJms
@EnableAutoConfiguration
public class SampleActiveMQAppliction {

	/*@Bean
	public Queue queue(){
		return new ActiveMQQueue("foo");
	}*/
	/*@Bean
	public Queue queue(){
		return new ActiveMQQueue("eventTopic");
	}*/
	
	@Bean
	JmsListenerContainerFactory<?> myJmsContainerFactory(ActiveMQConnectionFactory connectionFactory){
		RedeliveryPolicy topicPolicy = new RedeliveryPolicy();
		topicPolicy.setInitialRedeliveryDelay(300000);
        topicPolicy.setRedeliveryDelay(300000);
        topicPolicy.setMaximumRedeliveries(12);
        RedeliveryPolicyMap map = connectionFactory.getRedeliveryPolicyMap();
        map.put(new ActiveMQTopic(">"), topicPolicy);
        connectionFactory.setNonBlockingRedelivery(true);
        SimpleJmsListenerContainerFactory factory = new SimpleJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setPubSubDomain(false);
        factory.setSubscriptionDurable(true);
        factory.setClientId("event");
        factory.setSessionAcknowledgeMode(Session.CLIENT_ACKNOWLEDGE);
		return factory;
	}

	public static void main(String[] args) {
		SpringApplication.run(SampleActiveMQAppliction.class, args);

	}

}
