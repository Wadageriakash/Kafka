package com.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class KafkaProducer {

	private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
	
    // Here using the kafka template we can send the message to the kafka topic and this topic already created through command prompt in the kafka.
	@PostMapping("/send")
	public String sendMessage(@RequestParam String message) {
		kafkaTemplate.send("my-topic", message);
		return "Message Sent: " + message; 
	}
	
	
	// Here this "my-topic-new" topic doesnot exist in the kafka and we are trying to send message to this topic "my-topic-new"
	// once we invoke this api automatically new topic will generate in the kafka with the name called my-topic-new
	@PostMapping("/sendmessagefornotexistingtopic")
	public String sendMessageFornotExistingTopic(@RequestParam String message) {
		kafkaTemplate.send("my-topic-new", message);
		return "Message Sent: " + message; 
	}
	
}
