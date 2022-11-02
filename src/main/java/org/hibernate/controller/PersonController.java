package org.hibernate.controller;

import org.hibernate.model.Person;
import org.hibernate.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/data")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/get")
    public List<Person> getAll() {
        return personService.getPeople();
    }

    @PostMapping("/save")
    public String save(@RequestBody Person person) {
        personService.save(person);
        return "Saved the data";
    }
}
