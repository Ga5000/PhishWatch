package com.ga5000.api.phishwatch.domain.model.review;

import com.ga5000.api.phishwatch.domain.model.email.suspicious.SuspiciousEmail;
import com.ga5000.api.phishwatch.domain.model.review.riskLevel.RiskLevel;
import com.ga5000.api.phishwatch.domain.model.review.status.PhishingReviewStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "email_id", nullable = false)
    private SuspiciousEmail email;

    // When the review (phishing analysis) took place
    @Column(nullable = false)
    private LocalDateTime reviewDate;

    // Outcome of the phishing review
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PhishingReviewStatus reviewStatus;

    private String summary; // summary created by the AI

    // Confidence score from AI indicating likelihood of phishing
    private Double score; // 0 - 10

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RiskLevel riskLevel;

    private LocalDateTime updatedAt;
}
