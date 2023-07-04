package com.facebookclonejava.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Data
@Table(name = "Comment")
@ToString
public class Comment {


    @Id
    @GeneratedValue
    private Long id;
    private String text;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @NotNull
    private User user;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;


    @ManyToOne
    @JoinColumn(name = "parent_comment_id")
    private Comment parentComment;


}
