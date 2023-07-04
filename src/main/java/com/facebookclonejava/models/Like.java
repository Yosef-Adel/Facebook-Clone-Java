package com.facebookclonejava.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Data
@Table(name = "Likes")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "likable_type")
@ToString
public class Like {
    @Id
    @GeneratedValue
    private Long id;
    private String text;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @NotNull
    private User user;

}
