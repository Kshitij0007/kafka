package service;

import model.ApprovalRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Value("${spring.kafka.topic.name:approval-topic}") // Default to "approval-topic"
    private String topic;
    public void publishToKafka(ApprovalRequest approvalRequest) {
        kafkaTemplate.send(topic, approvalRequest);
    }
}