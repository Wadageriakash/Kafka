package com.kafka.producer;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopicConfig {

	
	// Here new topic name is "my-new-topic-2"
	// 3 is the number of partition
	// (short)1 is the replicationFactor
	@Bean
	public NewTopic createMyTopic() {
		return new NewTopic("my-new-topic-2", 3, (short)1);
	}
}
