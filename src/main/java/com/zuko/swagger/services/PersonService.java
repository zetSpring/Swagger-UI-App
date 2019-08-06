package com.zuko.swagger.services;

import com.zuko.swagger.model.Person;
import com.zuko.swagger.repositories.HobbyRepository;
import com.zuko.swagger.repositories.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private HobbyRepository hobbyRepository;

    public Person createPerson(Person person){
        Person savedPerson = personRepository.save(person);
        if(!CollectionUtils.isEmpty(person.getHobbies())){
            person.getHobbies().forEach(hobby ->  {
                hobby.setPerson(savedPerson);
                hobbyRepository.save(hobby);
            });
        }
        return savedPerson;
    }

    public List<Person> findAll(){
        return personRepository.findAll();
    }

    public Person findOne(Long personId){
        return personRepository.findById(personId).get();
    }

    public List<Person> findByFirstName(String firstName){
        return personRepository.findByFirstName(firstName);
    }

    public void deletePerson(Long personId){
        personRepository.deleteById(personId);
    }
}
