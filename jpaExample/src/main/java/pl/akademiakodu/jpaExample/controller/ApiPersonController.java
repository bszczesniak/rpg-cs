package pl.akademiakodu.jpaExample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.akademiakodu.jpaExample.dao.PersonDao;
import pl.akademiakodu.jpaExample.model.Person;

@RestController
public class ApiPersonController {

    @Autowired
    private PersonDao personDao;

    @GetMapping("/api/person/search")
    public @ResponseBody
    Person serch(@RequestParam String surname) {
        return personDao.findFirstBySurname(surname);
    }

}

