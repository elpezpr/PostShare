package com.elpezpr.PostShare.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id
            ;
    private String title;

    @Column
    private String content;

    @Embedded
    private PostMetadata metadata;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<Comment> comments = new HashSet<>();

    private String author;

    @PrePersist
    protected void onCreate() {
        if (metadata != null && metadata.getCreatedDate() == null) {
            metadata.setCreatedDate(LocalDateTime.now());
        }
    }
}
