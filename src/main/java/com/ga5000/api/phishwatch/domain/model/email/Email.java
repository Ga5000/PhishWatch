package com.ga5000.api.phishwatch.domain.model.email;


import com.ga5000.api.phishwatch.domain.model.user.User;
import jakarta.persistence.*;

import java.util.UUID;

@MappedSuperclass
public abstract class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
