package com.facebookclonejava.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;

@Entity
@Data
@ToString
@Table(name = "post")
public class Post  {
    @Id
    @GeneratedValue
    private Long id;
    private String text;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @NotNull
    private User user;

    private String picture;

    @OneToMany(mappedBy = "post")
    private List<Comment> comments;



}
