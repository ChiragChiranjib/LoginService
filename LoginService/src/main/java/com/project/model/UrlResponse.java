package com.project.model;

import javax.persistence.*;

@Entity
public class UrlResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int slno;

    private String response;
    private String URL;

    @ManyToOne
    @JoinColumn(name = "userId")
    private Session session;

    public UrlResponse(String response, String URL, Session session) {
        this.response = response;
        this.URL = URL;
        this.session = session;
    }

    public UrlResponse() {
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public int getSlno() {
        return slno;
    }

    public void setSlno(int slno) {
        this.slno = slno;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }
}
