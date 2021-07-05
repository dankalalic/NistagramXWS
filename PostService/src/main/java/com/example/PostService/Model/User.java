package com.example.PostService.Model;

import javax.persistence.*;

import static javax.persistence.DiscriminatorType.STRING;

@Entity
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="rolee", discriminatorType=STRING)
@Table(name="users")
public class User {

    @Id
    private Integer id;

    public User(Integer id) {
        this.id = id;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
