package com.example.conference.controllers;

import com.example.conference.models.Speaker;
import com.example.conference.repositories.SpeakerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/speakers")
public class SpeakersController {
    @Autowired
    private SpeakerRepository speakerRepository;

    @GetMapping
    public List<Speaker> getAllSpeakers() {
        return this.speakerRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Speaker getSpeaker(@PathVariable Long id) {
        return this.speakerRepository.getOne(id);
    }

    @PostMapping
    public Speaker createSpeaker(@RequestBody final Speaker speaker) {
        return this.speakerRepository.saveAndFlush(speaker);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Speaker updateSpeaker(@PathVariable Long id, @RequestBody Speaker speaker) {
        Speaker existingSpeaker = this.speakerRepository.getOne(id);
        BeanUtils.copyProperties(speaker, existingSpeaker, "speaker_id");
        System.out.println(existingSpeaker);
        return this.speakerRepository.saveAndFlush(existingSpeaker);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void deleteSpeaker(@PathVariable Long id) {
        this.speakerRepository.deleteById(id);
    }
}
