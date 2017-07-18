package allpccollector.controller;

import allpccollector.model.Computer;
import allpccollector.model.ComputerProperty;
import allpccollector.model.DomainUser;
import allpccollector.model.LoginEvent;
import allpccollector.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

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
    ComputerParamRepository computerParamRepo;
//
//    @Autowired
//    PcConfigChangeRepository pcConfigChangeRepo;

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public void getComputerInfo(@Valid @RequestBody LoginEvent loginEvent){


        DomainUser existUser = domainUsersRepo.findDomainUserByUsername(loginEvent.getUser().getUsername());
        if(existUser == null) {
            DomainUser user = new DomainUser();
            user.setUsername(loginEvent.getUser().getUsername());
            existUser = user;
            domainUsersRepo.save(existUser);
        }

        Computer computer = loginEvent.getComputer();
        Computer existComputer = computerRepo.findComputerByCpuId(computer.getCpuId());
        if(existComputer != null){
            if(!computer.getComputerName().equals(existComputer.getComputerName())) existComputer.setComputerName(computer.getComputerName());
            //sku дергаем из Computername, нужно добавить потом
        }else{
            existComputer = new Computer();
            existComputer.setSku("");
            existComputer.setComputerName(computer.getComputerName());
            existComputer.setCpuId(computer.getCpuId());
        }

        computerRepo.saveAndFlush(existComputer);


        //Properties from Request computer
        Set<ComputerProperty> incomingSet = computer.getComputerProperties();
        //Properties from exist computer
        Set<ComputerProperty> existSet = existComputer.getComputerProperties();

        if(existSet == null) existSet = Collections.emptySet();

        for (ComputerProperty prop : incomingSet) {
            for (ComputerProperty exprop : existSet) {
                String propName = prop.getParamType().getName();
                if (propName.equals(exprop.getParamType().getName())) {
                        //заносим данные в таблицу изменений, которой пока нет), пока просто сохраняем новую запись
                        exprop.setValue(prop.getValue());
                        exprop.setComputer(existComputer);
                        prop = exprop;
                        break;
                    }
                }
                prop.setComputer(existComputer);
                computerParamRepo.saveAndFlush(prop);
            }

       loginEventRepo.save(new LoginEvent(existUser, existComputer, loginEvent.getDatetime()));

      //  loginEventRepo.save(loginEvent);

    }

}
