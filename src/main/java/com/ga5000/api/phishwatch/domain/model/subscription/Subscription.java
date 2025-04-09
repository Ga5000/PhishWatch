package com.ga5000.api.phishwatch.domain.model.subscription;

import com.ga5000.api.phishwatch.domain.model.payment.Payment;
import com.ga5000.api.phishwatch.domain.model.subscription.subscriptionStatus.SubscriptionStatus;
import com.ga5000.api.phishwatch.domain.model.plan.Plan;
import com.ga5000.api.phishwatch.domain.model.user.User;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "subscriptions")
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "plan_id", referencedColumnName = "id", nullable = false)
    private Plan plan;

    @Column(unique = true)
    private String stripeSubscriptionId; // From Stripe upon creating a subscription

    private String stripeCustomerId;

    @Column(nullable = false)
    private LocalDateTime startDate;

    private LocalDateTime endDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SubscriptionStatus subscriptionStatus;

    @OneToMany(mappedBy = "subscription", fetch = FetchType.LAZY)
    private List<Payment> payments;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
