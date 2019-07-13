package com.zuko.swagger.controller;

import com.zuko.swagger.model.Person;
import com.zuko.swagger.services.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/person")
public class PersonController {
    private PersonService personService;

    @GetMapping("/")
    public List<Person>findAll(){
        return personService.findAll();
    }

    @PostMapping("/")
    public Person create(@RequestBody Person person){
        return personService.createPerson(person);
    }

    @GetMapping("/{personId")
    public Person findOne(@PathVariable Long id){
        return personService.findOne(id);
    }

    @GetMapping("/find/{personName}")
    public List<Person> findByName(@PathVariable String personName){
        return personService.findByFirstName(personName);
    }

    @DeleteMapping("/{personId}")
    public void deletePerson(@PathVariable Long personId){
        personService.deletePerson(personId);
    }
}

