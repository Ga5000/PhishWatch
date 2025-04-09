package com.ga5000.api.phishwatch.domain.model.company;

import com.ga5000.api.phishwatch.domain.model.user.User;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "companies")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String name;

    @OneToOne
    private User manager;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<User> employees;

    private LocalDateTime createdAt;
}
