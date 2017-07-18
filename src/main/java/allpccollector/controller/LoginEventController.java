package allpccollector.controller;

import allpccollector.model.*;
import allpccollector.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/logins")
public class LoginEventController {

    @Autowired
    private ComputerRepository computerRepo;

    @Autowired
    private ComputerParamRepository computerParamRepo;

    @Autowired
    private ParamTypeRepository paramTypeRepo;

    @Autowired
    private DomainUsersRepository domainUsersRepo;

    @Autowired
    LoginEventRepository loginEventRepo;

    @RequestMapping(method = RequestMethod.GET)
    public List<LoginEvent> findAll(){


        return loginEventRepo.findAll();
    }
}
