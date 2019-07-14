package com.zuko.swagger.controller;

import com.zuko.swagger.model.Person;
import com.zuko.swagger.services.PersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/person")
@Api("This is the controller for the Person.")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/")
    @ApiOperation("This method returns all persons from the database")
    public List<Person>findAll(){
        return personService.findAll();
    }

    @PostMapping("/")
    @ApiOperation("This method saves a new person into the database.")
    public Person create(@RequestBody Person person){
        return personService.createPerson(person);
    }

    @GetMapping("/{personId}")
    @ApiOperation("This method return a person by a given id.")
    public Person findPerson(@PathVariable Long personId){
        return personService.findOne(personId);
    }

    @GetMapping("/find/{personName}")
    @ApiOperation("This method return a list persons by the given name.")
    public List<Person> findByName(@PathVariable String personName){
        return personService.findByFirstName(personName);
    }

    @DeleteMapping("/{personId}")
    @ApiOperation("This method deletes a person from the database using the given id.")
    public void deletePerson(@PathVariable Long personId){
        personService.deletePerson(personId);
    }
}

