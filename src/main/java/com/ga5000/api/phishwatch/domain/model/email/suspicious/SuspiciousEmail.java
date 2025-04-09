package com.ga5000.api.phishwatch.domain.model.email.suspicious;

import com.ga5000.api.phishwatch.domain.model.email.Email;
import com.ga5000.api.phishwatch.domain.model.email.suspicious.status.EmailStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "suspicious_emails")
public class SuspiciousEmail extends Email {

    private String sender;

    private String subject;

    private String body;

    private LocalDateTime receivedDate;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EmailStatus emailStatus;

}
