package allpccollector.controller;


import allpccollector.model.Computer;
import allpccollector.repository.ComputerRepository;
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
