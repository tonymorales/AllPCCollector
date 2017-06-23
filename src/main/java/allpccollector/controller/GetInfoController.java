package allpccollector.controller;

import allpccollector.model.Computer;
import allpccollector.model.DomainUser;
import allpccollector.model.LoginEvent;
import allpccollector.model.PcInfoRequest;
import allpccollector.repository.ComputerRepository;
import allpccollector.repository.DomainUsersRepository;
import allpccollector.repository.LoginEventRepository;
import allpccollector.repository.PcConfigChangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sendInfo")
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
    public void getComputerInfo(PcInfoRequest requestBody){

        String username = requestBody.getUsername();
        String logonTime = requestBody.getLogonTime();

        DomainUser domainUser = domainUsersRepo.findDomainUserByUsername(username);
        if(domainUser == null ) {
            domainUser = new DomainUser(username);
            domainUsersRepo.save(domainUser);}

        Computer computer = computerRepo.findComputerBuCpuId(requestBody.getCpuId());
        /* Создаем компьютер из реквеста, вызываем компьютер из репозитория
        * Нужно переписать метод equals, а лучше сделать свой метод сравнения, который будет возвращать
        * List<PcConfigChange>  по этому списку мы будем делать запись в таблицу.
        * Если записей с таким id мы не найдем, то просто записываем новый компьютр в базу.*/

        //loginEventRepo.save(new LoginEvent(domainUser, logonTime, computer));

        computerRepo.sa

    }
}
