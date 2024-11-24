package service;

import model.ApprovalRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApprovalService {

    @Autowired
    private KafkaService kafkaService; // Dependency on KafkaService

    // This method processes the incoming approval request and pushes it to Kafka
    public void processApproval(ApprovalRequest approvalRequest) {
        // You can perform any necessary business logic here (e.g., validation, transformation)
        // For simplicity, we directly push the approval request to Kafka
        kafkaService.publishToKafka(approvalRequest); // Pass the request to KafkaService
    }
}