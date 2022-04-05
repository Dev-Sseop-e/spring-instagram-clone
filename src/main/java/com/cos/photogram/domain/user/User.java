package com.cos.photogram.domain.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity // Create table on DB
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Strategy of increasing number follow the DB
    private int id;

    @Column(unique = true)
    private String username;
    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;
    private String bio;
    private String gender;

    @Column(nullable = false)
    private String email;
    private String phone;
    private String website;

    private String profileImageUrl;
    private String role;

    private LocalDateTime createDate;

    @PrePersist // Executed before inserting db
    public void createDate() {
        this.createDate = LocalDateTime.now();
    }

}
