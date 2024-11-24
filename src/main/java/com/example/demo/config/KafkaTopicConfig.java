package com.example.demo.config;


import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.beans.factory.annotation.Value;

@Configuration
public class KafkaTopicConfig {

    @Value("${spring.kafka.topic.name:approval-topic}") // Default topic name
    private String topicName;

    @Value("${spring.kafka.topic.partitions:1}")
    private int partitions;

    @Value("${spring.kafka.topic.replication-factor:1}")
    private short replicationFactor;

    // KafkaAdmin will automatically use the configuration from application.properties
    @Bean
    public KafkaAdmin kafkaAdmin() {
        return new KafkaAdmin(new java.util.HashMap<>());
    }

    @Bean
    public NewTopic approvalTopic() {
        return new NewTopic(topicName, partitions, replicationFactor);
    }
}
