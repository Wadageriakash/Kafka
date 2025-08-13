package com.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

//	Here consumer listening from the same topic but consumer in the different unique group
	// Here consumer in the different unique group id and both pointing to the same topic (my-topic) in the kafka 
	// here we can specify the topic name and also we can specify the group name
	@KafkaListener(topics = "my-topic", groupId = "my-new-group")
	public void listen1(String messages) {
		System.out.println("Received Message 1: " + messages);
	}
	@KafkaListener(topics = "my-topic", groupId = "my-new-group-1")
	public void listen2(String messages) {
		System.out.println("Received Message 2: " + messages);
	}
	

//	Received Message 1: Hello How are you..?
//	Received Message 2: Hello How are you..?
//	Received Message 1: Hello Kafka
//	Received Message 2: Hello Kafka
	
	
	// HERE IN THE BELOW BOTH ARE POINTING TO THE SAME TOPIC AND ALSO SAME GROUPID SO IT WILL PRINT ONLY ONE NOT TWO
	@KafkaListener(topics = "my-topic", groupId = "my-new-group")
	public void listen3(String messages) {
		System.out.println("Received Message 3: " + messages);
	}
	@KafkaListener(topics = "my-topic", groupId = "my-new-group")
	public void listen4(String messages) {
		System.out.println("Received Message 4: " + messages);
	}
	
	//Received Message 4: Hello Kafka

}
