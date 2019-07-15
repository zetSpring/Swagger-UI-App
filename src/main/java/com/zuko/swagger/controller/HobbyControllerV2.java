package com.zuko.swagger.controller;

import com.zuko.swagger.model.Hobby;
import com.zuko.swagger.services.HobbyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v2/hobbies")
@Api("This is the hobby controller for me REST API V2.")
public class HobbyControllerV2 {
    @Autowired
    private HobbyService hobbyService;


    @GetMapping("/")
    @ApiOperation("This method returns all hobbies save in the database V2.")
    public List<Hobby> findAll(){
        return hobbyService.findAllHobbies();
    }

    @GetMapping("/find/{hobbyId}")
    @ApiOperation("This method return a hobby by the given id V2.")
    public Hobby findHobby(@PathVariable Long hobbyId){
        return hobbyService.findHobby(hobbyId);
    }

    @PostMapping("/")
    @ApiOperation("This method saves a new hobby into the database V2.")
    public Hobby createHobby(@RequestBody Hobby hobby){
        return hobbyService.createHobby(hobby);
    }

    @DeleteMapping("/{hobbyId}")
    @ApiOperation("This method deletes hobby from the database using the given id V2.")
    public void deleteHobby(@PathVariable Long hobbyId){
        hobbyService.deleteHobby(hobbyId);
    }
}
