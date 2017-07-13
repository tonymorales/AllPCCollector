package allpccollector.controller;


import allpccollector.model.Computer;
import allpccollector.repository.ComputerParamRepository;
import allpccollector.repository.ComputerRepository;
import allpccollector.repository.ParamTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//import javax.annotation.PostConstruct;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/computers")
public class ComputerController {

    @Autowired
    private ComputerRepository computerRepo;

 //    @PostConstruct
//    public void setUp(){
//        computerRepo.save(new Computer("vrn-2622", "192.168.22.111", "fffff1212fff", "admin", "windows 10", "Intel", "1541321", "2Gb", "Intel"/*, "12122211", ""*/));
//    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Computer> findAll(){

//        Computer computer = new Computer();
//        computer.setComputerName("vrn-1111");
//        computer.setCpuId("d23423d");
//        computer.setSku("1111");
//
//        ParamType paramTypeIP = new ParamType();
//        paramTypeIP.setName("ip");
//        paramTypeIP.setTitle("IP address");
//
//        Computer computer2 = new Computer();
//        computer2.setComputerName("vrn-2222");
//        computer2.setCpuId("a21312");
//        computer2.setSku("2222");
//
//        ComputerParam paramIP2 = new ComputerParam();
//        paramIP2.setParamType(paramTypeIP);
//        paramIP2.setValue("192.168.22.22");
//        paramIP2.setComputer(computer2);
//        paramTypeRepo.save(paramTypeIP);
//        Set<ComputerParam> params2 = new HashSet<>();
//        params2.add(paramIP2);
//
//        Iterator<ComputerParam> paramIterator2 = params2.iterator();
//        while (paramIterator2.hasNext()){
//            computerParamRepo.save(paramIterator2.next());
//        }
//
//        computer2.setComputerParams(params2);
////
//        ComputerParam paramIP = new ComputerParam();
//
//        paramIP.setParamType(paramTypeIP);
//        paramIP.setValue("192.168.22.9");
//        paramIP.setComputer(computer);
//       // paramTypeRepo.save(paramTypeIP);
//
//        Set<ComputerParam> params = new HashSet<>();
//        params.add(paramIP);
//
//
//        Iterator<ComputerParam> paramIterator = params.iterator();
//        while (paramIterator.hasNext()){
//            computerParamRepo.save(paramIterator.next());
//        }
//
//        computer.setComputerParams(params);
//

//
//
//        ComputerParam paramMAC = new ComputerParam();
//        ParamType paramTypeMAC = new ParamType();
//        paramTypeMAC.setName("mac");
//        paramTypeMAC.setTitle("MAC address");
//        paramMAC.setParamType(paramTypeMAC);
//        paramMAC.setComputer(computer);
//        paramTypeRepo.save(paramTypeMAC);
//        computerParamRepo.save(paramMAC);
//
//
//        Set<ComputerParam> params = new HashSet<>();
//        params.add(paramIP);
//        params.add(paramMAC);
//
//
//
//
//        Computer computer1 = computerRepo.findComputerByCpuId(computer.getCpuId());
//        if(computer1 != null) {
//            computer1.setSku("1112");
//            computer = computer1;
//        }
//
//        computer.setComputerParams(params);
//        computerRepo.save(computer);


        return computerRepo.findAll();

    }

    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    public Computer findComputerByName(@PathVariable("name") String name){
        return computerRepo.findComputerByComputerName(name);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public void getComputer(@Valid @RequestBody Computer requestBody){
        computerRepo.save(requestBody);
    }


}
