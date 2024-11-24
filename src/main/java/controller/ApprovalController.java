package controller;

import model.ApprovalRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.ApprovalService;

@RestController
public class ApprovalController {

    @Autowired
    private ApprovalService approvalService;

    @PostMapping("/api/approvals/push")
    public ResponseEntity<String> pushApproval(@RequestBody ApprovalRequest approvalRequest) {
        approvalService.processApproval(approvalRequest);
        return ResponseEntity.ok("Approval pushed to Kafka successfully");
    }
}
