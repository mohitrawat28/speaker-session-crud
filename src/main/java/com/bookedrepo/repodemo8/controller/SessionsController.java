package com.bookedrepo.repodemo8.controller;

import com.bookedrepo.repodemo8.models.Session;
import com.bookedrepo.repodemo8.repositories.SessionRepository;
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
    public List<Session> list() {
        return sessionRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Session get(@PathVariable Long id) {
        return sessionRepository.getOne(id);
    }

    @PostMapping
    public Session create(@RequestBody final Session session) {
        return sessionRepository.saveAndFlush(session);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {

        // check records before deleting
        sessionRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Session update(@PathVariable Long id, @RequestBody final Session session) {
        // we expect all attributes to be passed in PUT req.
        //TODO: Add validation that all attr are passed otherwise return 400 bad payload
        Session existingSession = sessionRepository.getOne(id);

        // bean utils copies the value from session to existing session but ignores the 3rd param provided
        BeanUtils.copyProperties(session, existingSession, "session_id", "speaker_id");

        return sessionRepository.saveAndFlush(existingSession);
    }
}
