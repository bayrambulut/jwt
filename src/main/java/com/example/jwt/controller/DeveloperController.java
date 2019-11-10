package com.example.jwt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.jwt.model.Developer;
import com.example.jwt.repository.DeveloperRepository;

@RestController
@RequestMapping("/developers")
public class DeveloperController {

	@Autowired
    private DeveloperRepository developerRepository;
    
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	
    @RequestMapping(value = "/sign-up", method = RequestMethod.POST)
    public Developer signUp(@RequestBody Developer developer) {
        developer.setPassword(bCryptPasswordEncoder.encode(developer.getPassword()));
        developerRepository.save(developer);
        return developer;
    }
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Developer> get() {
    	return developerRepository.findAll();
    }
}