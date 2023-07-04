package com.facebookclonejava.models;

import jakarta.persistence.*;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Data
@Table(name = "friendship")
@IdClass(FriendshipId.class)
public class Friendship {


    @Id
    @ManyToOne
    @JoinColumn(name = "user_id")
    @NotNull
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "friend_id")
    @NotNull
    private User friend;

    @NotNull
    private FriendStatus status;
}
