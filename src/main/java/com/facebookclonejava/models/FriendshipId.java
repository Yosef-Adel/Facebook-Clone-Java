package com.facebookclonejava.models;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

import java.io.Serializable;

@Data
public class FriendshipId implements Serializable {

    private User user;
    private User friend;
}
