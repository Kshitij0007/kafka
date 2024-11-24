package model;

import lombok.Data;

@Data
public class ApprovalRequest {
    private String approvalId;
    private String requester;
    private String details;
}
