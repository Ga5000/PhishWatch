package com.ga5000.api.phishwatch.domain.model.review.status;

public enum PhishingReviewStatus {
    PENDING,         // Review not yet performed
    SAFE,            // Email considered safe
    PHISHING,        // Email confirmed as phishing
    INCONCLUSIVE     // Unable to determine with confidence
}
