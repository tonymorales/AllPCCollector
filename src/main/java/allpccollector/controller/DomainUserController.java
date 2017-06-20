package allpccollector.controller;

import allpccollector.model.DomainUser;
import allpccollector.repository.DomainUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class DomainUserController {

    @Autowired
    private DomainUsersRepository repo;

    @RequestMapping(method = RequestMethod.GET)
    public List<DomainUser> findAll(){
        return repo.findAll();
    }



}
