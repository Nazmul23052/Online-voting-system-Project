package com.ovs.model;

public class User {
    public final long id;
    public final String email;
    public final String fullName;
    public final String role;
    public final boolean verified;
    public final boolean voted;

    public User(long id, String email, String fullName, String role, boolean verified, boolean voted) {
        this.id = id;
        this.email = email;
        this.fullName = fullName;
        this.role = role;
        this.verified = verified;
        this.voted = voted;
    }

    public boolean isAdmin() {
        return "ADMIN".equalsIgnoreCase(role);
    }
}
