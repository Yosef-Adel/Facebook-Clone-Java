package com.facebookclonejava.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "users")
@ToString
public class User {
    @Id
    @GeneratedValue
    private   Long id;
    private String name;

    @Column(unique = true)
    private String email;

    private String password;
    private String picture;



    //bidiraction
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JsonIgnore
    @ToString.Exclude
    private List<Post> PostList;





    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at", nullable = false)
    private Date updatedAt;

}
