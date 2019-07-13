package com.zuko.swagger.controller;

import com.zuko.swagger.model.Hobby;
import com.zuko.swagger.services.HobbyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/hobbies")
public class HobbyController {

    private HobbyService hobbyService;

    @GetMapping("/")
    public List<Hobby> findAll(){
        return hobbyService.findAllHobbies();
    }

    @GetMapping("/{hobbyId}")
    public Hobby findHobby(@PathVariable Long id){
        return hobbyService.findHobby(id);
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
