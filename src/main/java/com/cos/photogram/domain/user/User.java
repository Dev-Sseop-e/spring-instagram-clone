package com.cos.photogram.domain.user;

import com.cos.photogram.domain.image.Image;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

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

    // mappedBy user: doesn't build table (this is not owner)
    // take all images in an User id when selecting User
    // LAZY: doesn't take the image in an specific User id when selecting User
    //       instead, take images when getImages() function's images are called
    // EAGER: take all images in an User id when selecting User by Joining them
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"user"}) // protect infinite recursion
    private List<Image> images;

    private LocalDateTime createDate;

    @PrePersist // Executed before inserting db
    public void createDate() {
        this.createDate = LocalDateTime.now();
    }

}
