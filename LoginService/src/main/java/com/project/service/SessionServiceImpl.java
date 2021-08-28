package com.project.service;

import com.project.model.UrlResponse;
import com.project.repository.SessionRepository;
import com.project.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionServiceImpl implements SessionService{

    @Autowired
    private SessionRepository sessionRepository;
    @Autowired
    private UrlRepository urlRepository;


    @Override
    public void saveUrl(String url, String response) {
        urlRepository.save(new UrlResponse(response,url, sessionRepository.findByUserName(UserService.username)));
    }
}
