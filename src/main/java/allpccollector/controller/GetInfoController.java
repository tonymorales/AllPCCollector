package allpccollector.controller;

import allpccollector.model.*;
import allpccollector.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Stream;

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
    ComputerPropertyRepository computerPropertyRepo;

    @Autowired
    PropertyTypeRepository propertyTypeRepo;


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
            //Todo: Add SKU definition from computer name, or something else.
        }else{
            existComputer = new Computer();
            existComputer.setSku("");
            existComputer.setComputerName(computer.getComputerName());
            existComputer.setCpuId(computer.getCpuId());
        }

        computerRepo.saveAndFlush(existComputer);

        Set<ComputerProperty> existSet = new HashSet<>();
        Set<ComputerProperty> set = existComputer.getComputerProperties();
        if(set != null)existSet.addAll(existComputer.getComputerProperties());

        Set<ComputerProperty> incomingSet = computer.getComputerProperties();

        Computer finalExistComputer = existComputer;
        incomingSet.stream().filter(newProperty -> {
            Supplier<Stream<ComputerProperty>> streamSupplier =  () -> existSet.stream().filter(p -> !p.isOld());

                   streamSupplier.get().filter(p->p.hasSameTypeAs(newProperty) && !p.equals(newProperty))
                    .peek(p -> p.setOld(true))
                    .forEach( p -> computerPropertyRepo.saveAndFlush(p));

                    return streamSupplier.get().noneMatch(p-> p.equals(newProperty)) || existSet.isEmpty();
        }).forEach(newProperty -> {
            newProperty.setComputer(finalExistComputer);
            newProperty.setDatetime(loginEvent.getDatetime());
            PropertyType pt = propertyTypeRepo.findByName(newProperty.getPropertyType().getName());
            if(pt!=null) newProperty.setPropertyType(pt);
            computerPropertyRepo.saveAndFlush(newProperty);
        });

       loginEventRepo.save(new LoginEvent(existUser, existComputer, loginEvent.getDatetime()));



    }

}
