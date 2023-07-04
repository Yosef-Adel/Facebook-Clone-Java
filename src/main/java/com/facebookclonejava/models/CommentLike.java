package com.facebookclonejava.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@DiscriminatorValue("COMMENT")
@Data
public class CommentLike extends Like {
    @ManyToOne
    @JoinColumn(name = "comment_id")
    private Comment comment;

    // Constructors, getters, setters, etc.
}
