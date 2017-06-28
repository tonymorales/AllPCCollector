package allpccollector.controller;

import allpccollector.model.LoginEvent;
import allpccollector.repository.ComputerRepository;
import allpccollector.repository.DomainUsersRepository;
import allpccollector.repository.LoginEventRepository;
import allpccollector.repository.PcConfigChangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/sendInfo")
public class GetInfoController {

    @Autowired
    DomainUsersRepository domainUsersRepo;

    @Autowired
    ComputerRepository computerRepo;

    @Autowired
    LoginEventRepository loginEventRepo;

    @Autowired
    PcConfigChangeRepository pcConfigChangeRepo;

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public void getComputerInfo(@Valid @RequestBody LoginEvent loginEvent){


        loginEventRepo.save(loginEvent);
//        String username = requestBody.getUsername();
//       //domainUsersRepo.save(new DomainUser(requestBody.getUsername()));
//
//        // String logonTime = requestBody.getDateTime();
//
//        DomainUser domainUser = domainUsersRepo.findDomainUserByUsername(username);
//        if(domainUser == null ) {
//            domainUser = new DomainUser(username);
//            domainUsersRepo.save(domainUser);
//        }
//
//
//        Computer computer = computerRepo.findComputerByCpuId(requestBody.getCpuId());
//        if(computer == null) computerRepo.save(new Computer(requestBody.getName(), requestBody.getIpAddress(), requestBody.getMacaddress(), requestBody.getOsVersion(), requestBody.getCpu(), requestBody.getCpuId(), requestBody.getRam(), requestBody.getGpu()));
//
//        String time = requestBody.getDatetime();
//        //time = "12321312";
//        LoginEvent loginEvent = loginEventRepo.save(new LoginEvent(domainUser, computer, time));
//        // Computer(String name, String ipAddress, String macaddress, String osVersion, String cpu, String cpuId, String ram, String gpu/)
//        /* Создаем компьютер из реквеста, вызываем компьютер из репозитория
//        * Нужно переписать метод equals, а лучше сделать свой метод сравнения, который будет возвращать
//        * List<PcConfigChange>  по этому списку мы будем делать запись в таблицу.
//        * Если записей с таким id мы не найдем, то просто записываем новый компьютр в базу.*/
//
//        //loginEventRepo.save(new LoginEvent(domainUser, logonTime, computer));



    }
}
