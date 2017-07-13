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

        Computer computer = new Computer();
        computer.setComputerName("vrn-1111");
        computer.setCpuId("d23423d");
        computer.setSku("1111");

        PropertyType propertyTypeIP = new PropertyType();
        propertyTypeIP.setName("ip");
        propertyTypeIP.setTitle("IP address");


        paramTypeRepo.save(propertyTypeIP);



        ComputerProperty paramIP = new ComputerProperty();

        paramIP.setParamType(propertyTypeIP);
        paramIP.setValue("192.168.22.9");
        paramIP.setComputer(computer);
        // paramTypeRepo.save(paramTypeIP);

        Set<ComputerProperty> params = new HashSet<>();
        params.add(paramIP);


        Iterator<ComputerProperty> paramIterator = params.iterator();
        while (paramIterator.hasNext()){
            computerParamRepo.save(paramIterator.next());
        }

        computer.setComputerProperties(params);

        computerRepo.save(computer);

        DomainUser user = new DomainUser();
        user.setUsername("apecherskih");
        domainUsersRepo.save(user);

        String time = "12.12.2014 15:15";

        LoginEvent loginEvent = new LoginEvent();

        loginEvent.setComputer(computer);
        loginEvent.setUser(user);
        loginEvent.setTime(time);

        loginEventRepo.save(loginEvent);

        LoginEvent loginEvent1 = new LoginEvent();
        String time2 = "14.12.2014 16:11";

        loginEvent1.setTime(time2);
        loginEvent1.setComputer(computer);
        loginEvent1.setUser(user);

        loginEventRepo.save(loginEvent1);

        return loginEventRepo.findAll();
    }
}
