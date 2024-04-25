package com.projectiss.domain;

import java.util.Objects;

public class Angajat extends Entity{
    private String username;
    private String password;
    private AccessLevel accessLevel;

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

    public AccessLevel getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(AccessLevel accessLevel) {
        this.accessLevel = accessLevel;
    }

    public Angajat(String username, String password, AccessLevel accessLevel) {
        this.username = username;
        this.password = password;
        this.accessLevel = accessLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Angajat angajat = (Angajat) o;
        return Objects.equals(username, angajat.username) && Objects.equals(password, angajat.password) && accessLevel == angajat.accessLevel;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), username, password, accessLevel);
    }
}
