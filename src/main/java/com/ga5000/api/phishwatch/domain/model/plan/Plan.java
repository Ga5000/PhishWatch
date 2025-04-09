package com.ga5000.api.phishwatch.domain.model.plan;

import com.ga5000.api.phishwatch.domain.model.plan.planType.PlanType;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "plans")
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private int reviewLimit;

    private boolean hasReviews;

    private boolean managerSupported;

    @Enumerated(EnumType.STRING)
    private PlanType planType;

    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal price;
}
