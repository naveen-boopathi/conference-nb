package com.example.conference.controllers;

import com.example.conference.models.Session;
import com.example.conference.repositories.SessionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sessions")
public class SessionsController {
    @Autowired
    private SessionRepository sessionRepository;

    @GetMapping
    public List<Session> getAllSessions() {
        return this.sessionRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Session getSession(@PathVariable Long id) {
        return this.sessionRepository.getOne(id);
    }

    @PostMapping
    public Session createSession(@RequestBody final Session session){
        return this.sessionRepository.saveAndFlush(session);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Session updateSession(@PathVariable Long id, @RequestBody Session session) {
        Session existingSession = this.sessionRepository.getOne(id);
        BeanUtils.copyProperties(session, existingSession, "session_id");
        System.out.println(existingSession);
        return this.sessionRepository.saveAndFlush(existingSession);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void deleteSession(@PathVariable Long id) {
        this.sessionRepository.deleteById(id);
    }
}
