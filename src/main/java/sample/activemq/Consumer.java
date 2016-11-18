package sample.activemq;


import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

import org.apache.activemq.command.ActiveMQBytesMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
	//@JmsListener(destination="eventTopic", concurrency="5-10")
	@JmsListener(destination="OKChemDataSyncTopic", containerFactory="myJmsContainerFactory", concurrency="1")
	public void receiveQueue(Message message){
		//ByteSequence bs = message.;
		//byte[] bs = (byte) text.split(",");
		//String[] arr = text.split(",");
		//for(int i=0;i<arr.length;i++){
		//	bs[i] = 
		//}
		//byte[] bs =(byte*) text.split(",");
		
		//String str = new String(text);
		//boolean result = message if (message instanceof type) {
			//type new_name = (type) message;
			
		//}
		if(message instanceof ActiveMQBytesMessage){
			try{
				ActiveMQBytesMessage bytesMessage = (ActiveMQBytesMessage) message;
				byte[] bs = new byte[(int) bytesMessage.getBodyLength()];
				bytesMessage.readBytes(bs);
				String str = new String(bs);
				System.out.println(str);
			}catch(JMSException e){
				e.printStackTrace();
			}
			//System.out.println("ActiveMQBytesMessage");
		}else{
			try{
				System.out.println(((TextMessage)message).getText());
				
			}catch(JMSException e){
				e.printStackTrace();
			}
		}
	}
}
