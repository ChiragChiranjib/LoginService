package com.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int SessionId;

    private String userName;
    private String password;

    public int getSessionId() {
        return SessionId;
    }

    public void setSessionId(int sessionId) {
        SessionId = sessionId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Session() {
    }


}
