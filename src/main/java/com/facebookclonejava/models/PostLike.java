package com.facebookclonejava.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@DiscriminatorValue("POST")
@Data
public class PostLike extends Like {
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    // Constructors, getters, setters, etc.
}
