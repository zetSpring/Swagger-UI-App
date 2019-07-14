package com.zuko.swagger.services;

import com.zuko.swagger.model.Hobby;
import com.zuko.swagger.repositories.HobbyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class HobbyService {

    @Autowired
    private HobbyRepository hobbyRepository;

    public HobbyService(HobbyRepository hobbyRepository) {
        this.hobbyRepository = hobbyRepository;
    }

    public Hobby createHobby(Hobby hobby){
        return hobbyRepository.save(hobby);
    }

    public List<Hobby> findAllHobbies(){
        return hobbyRepository.findAll();
    }

    public Hobby findHobby(Long hobbyId){
        return hobbyRepository.findById(hobbyId).get();
    }

    public void deleteHobby(Long hobbyId){
        hobbyRepository.deleteById(hobbyId);
    }


}
