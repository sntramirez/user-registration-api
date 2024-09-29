package com.user.registration.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "app_user")
public class User {
        @Id
        @GeneratedValue(generator = "UUID")
        @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
        @Column(name = "id", updatable = false, nullable = false)
        private String id;

        private String name;
        private String email;
        private String password;

        @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
        private List<Phone> phones;

        private LocalDateTime created;
        private LocalDateTime modified;
        private LocalDateTime lastLogin;
        private String token;
        private boolean isActive;


}
