package mongo.controllers;

import mongo.models.Person;
import mongo.repositories.PersonRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonRespository personRespository;

    @GetMapping
    public Flux<Person> index() {
        return personRespository.findAll();
    }
}
