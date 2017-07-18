package allpccollector.controller;

import allpccollector.model.Computer;
import allpccollector.model.DomainUser;
import allpccollector.model.LoginEvent;
import allpccollector.repository.*;
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
    ComputerParamRepository computerParamRepo;
//
//    @Autowired
//    PcConfigChangeRepository pcConfigChangeRepo;

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public void getComputerInfo(@Valid @RequestBody LoginEvent loginEvent){

        //DomainUser user = loginEvent.getUser();

//        DomainUser existUser = domainUsersRepo.findDomainUserByUsername(loginEvent.getUser().getUsername());
//        if(existUser == null) existUser = domainUsersRepo.save(loginEvent.getUser());

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
            if(computer.getComputerName() != existComputer.getComputerName()) existComputer.setComputerName(computer.getComputerName());
            //sku дергаем из Computername
        }else{
            existComputer = new Computer();
            existComputer.setSku("");
            existComputer.setComputerName(computer.getComputerName());
            existComputer.setCpuId(computer.getCpuId());
        }

        computerRepo.saveAndFlush(existComputer);

//        Computer existComputer = computerRepo.findComputerByCpuId(computer.getCpuId());
//        System.out.println(existComputer != null);





        /*if(existComputer == null) {
            Computer comp = new Computer();
            comp.setSku("");
            comp.setCpuId(computer.getCpuId());
            comp.setComputerName(computer.getComputerName());

            existComputer = computer;
            computerRepo.save(existComputer);
        }
        else{
            computerRepo.save(existComputer);

            HashSet<ComputerProperty> incomingSet = new HashSet<>();
            incomingSet.addAll(computer.getComputerProperties());

            HashSet<ComputerProperty> existSet = new HashSet<>();
            existSet.addAll(existComputer.getComputerProperties());

            incomingSet.removeAll(existSet);

            for (ComputerProperty prop: incomingSet) {
                for (ComputerProperty exprop : existSet){
                    if(prop.getParamType().getName() == exprop.getParamType().getName()){
                        //заносим данные в таблицу изменений, которой пока нет), пока просто сохраняем новую запись
                        exprop.setValue(prop.getValue());
                        exprop.setComputer(computer);
                        computerParamRepo.save(exprop);
                    }
                }

            }
        }*/






       loginEventRepo.save(new LoginEvent(existUser, existComputer, loginEvent.getDatetime()));

      //  loginEventRepo.save(loginEvent);

    }

}
