package com.ga5000.api.phishwatch.domain.model.user;

import com.ga5000.api.phishwatch.domain.model.company.Company;
import com.ga5000.api.phishwatch.domain.model.email.suspicious.SuspiciousEmail;
import com.ga5000.api.phishwatch.domain.model.email.trusted.TrustedEmail;
import com.ga5000.api.phishwatch.domain.model.user.role.Role;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    private Role role;

    private int reviewsUsed;

    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private Company company;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<SuspiciousEmail> suspiciousEmails;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<TrustedEmail> trustedEmails;

    private LocalDateTime createdAt;


}
