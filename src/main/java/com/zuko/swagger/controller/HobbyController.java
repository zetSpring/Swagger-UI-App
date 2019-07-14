package com.zuko.swagger.controller;

import com.zuko.swagger.model.Hobby;
import com.zuko.swagger.services.HobbyService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/hobbies")
public class HobbyController {

    @Autowired
    private HobbyService hobbyService;


    @GetMapping("/")
    public List<Hobby> findAll(){
        return hobbyService.findAllHobbies();
    }

    @GetMapping("/find/{hobbyId}")
    public Hobby findHobby(@PathVariable Long hobbyId){
        return hobbyService.findHobby(hobbyId);
    }

    @PostMapping("/")
    public Hobby createHobby(@RequestBody Hobby hobby){
        return hobbyService.createHobby(hobby);
    }

    @DeleteMapping("/{hobbyId}")
    public void deleteHobby(@PathVariable Long id){
        hobbyService.deleteHobby(id);
    }

}
