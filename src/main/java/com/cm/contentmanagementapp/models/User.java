package com.cm.contentmanagementapp.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    private EnumRole role;

    @NotBlank
    @Column(name="username")
    private String username;

    @NotBlank
    @Column(name="password")
    private String password;

    @Column(name="email")
    private String email;

    private String profileImageUrl;

    private LocalDate userJoinDate;

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "post_list_id")
    private PostList postList;

    public User() {
        this.role = EnumRole.ROLE_USER;
        postList = new PostList();
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        userJoinDate = LocalDate.now();
        this.role = EnumRole.ROLE_USER;
        postList = new PostList();
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.password = password;
        this.email = email;
        userJoinDate = LocalDate.now();
        this.role = EnumRole.ROLE_USER;
        postList = new PostList();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EnumRole getRole() {
        return role;
    }

    public void setRole(EnumRole role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public LocalDate getUserJoinDate() {
        return userJoinDate;
    }

    public void setUserJoinDate(LocalDate userJoinDate) {
        this.userJoinDate = userJoinDate;
    }

    public PostList getPostList() {
        return postList;
    }

    public void setPostList(PostList postList) {
        this.postList = postList;
    }
}
