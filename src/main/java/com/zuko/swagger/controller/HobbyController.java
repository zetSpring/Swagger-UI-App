package com.zuko.swagger.controller;

import com.zuko.swagger.model.Hobby;
import com.zuko.swagger.services.HobbyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/hobbies")
@Api("This is the hobby controller for me REST API.")
public class HobbyController {

    @Autowired
    private HobbyService hobbyService;


    @GetMapping("/")
    @ApiOperation("This method returns all hobbies save in the database.")
    public List<Hobby> findAll(){
        return hobbyService.findAllHobbies();
    }

    @GetMapping("/find/{hobbyId}")
    @ApiOperation("This method return a hobby by the given id.")
    public Hobby findHobby(@PathVariable Long hobbyId){
        return hobbyService.findHobby(hobbyId);
    }

    @PostMapping("/")
    @ApiOperation("This method saves a new hobby into the database.")
    public Hobby createHobby(@RequestBody Hobby hobby){
        return hobbyService.createHobby(hobby);
    }

    @DeleteMapping("/{hobbyId}")
    @ApiOperation("This method deletes hobby from the database using the given id.")
    public void deleteHobby(@PathVariable Long hobbyId){
        hobbyService.deleteHobby(hobbyId);
    }

}
