package com.ga5000.api.phishwatch.domain.model.email.trusted;

import com.ga5000.api.phishwatch.domain.model.email.Email;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "trusted_emails")
public class TrustedEmail extends Email {

    @Column(nullable = false)
    private String trustedAddress;

    @Column(length = 300)
    private String description;

    private LocalDateTime createdAt;
}
