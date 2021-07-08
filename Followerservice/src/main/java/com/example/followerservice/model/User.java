package com.example.followerservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="users")
public class User {

    @Id
    @SequenceGenerator(name="seq_user", sequenceName = "seq_user", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_user")
    private Integer id;

    @Column
    private Boolean isprivate;


    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="UserRel",
            joinColumns={@JoinColumn(name="mojId")},
            inverseJoinColumns={@JoinColumn(name="kogapratimId")})
    private Set<User> followers = new HashSet<User>();

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="UserRel",
            joinColumns={@JoinColumn(name="mojId")},
            inverseJoinColumns={@JoinColumn(name="kogapratimId")})
    private Set<User> following = new HashSet<User>();


    public Boolean getPrivate() {
        return isprivate;
    }

    public void setPrivate(Boolean aPrivate) {
        isprivate = aPrivate;
    }

    public Set<User> getFollowers() {
        return followers;
    }

    public void setFollowers(Set<User> followers) {
        this.followers = followers;
    }

    public Set<User> getFollowing() {
        return following;
    }

    public void setFollowing(Set<User> following) {
        this.following = following;
    }

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
