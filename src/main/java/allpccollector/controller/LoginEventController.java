package allpccollector.controller;

import allpccollector.model.*;
import allpccollector.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/logins")
public class LoginEventController {

    @Autowired
    private ComputerRepository computerRepo;

    @Autowired
    private ComputerPropertyRepository computerParamRepo;

    @Autowired
    private PropertyTypeRepository paramTypeRepo;

    @Autowired
    private DomainUsersRepository domainUsersRepo;

    @Autowired
    LoginEventRepository loginEventRepo;

    @RequestMapping(method = RequestMethod.GET)
    public List<LoginEvent> findAll(){


        return loginEventRepo.findAll();
    }
}
