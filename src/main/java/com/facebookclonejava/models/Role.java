package com.facebookclonejava.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * @created 06/07/2023 - 10:09 AM
 * @project Facebook-Clone-Java
 * @author Yosef Adel Mahmoud Saaid
 */


@Entity
@Table(name = "role")
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    public Role(String name) {
        this.name = name;
    }
}
