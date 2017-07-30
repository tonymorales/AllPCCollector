package allpccollector.controller;


import allpccollector.model.Computer;
import allpccollector.repository.ComputerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/computers")
public class ComputerController {

    @Autowired
    private ComputerRepository computerRepo;

    @RequestMapping(method = RequestMethod.GET)
    public List<Computer> findAll(){
        return computerRepo.findAll();

    }

    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    public Computer findComputerByName(@PathVariable("name") String name){
        return computerRepo.findComputerByComputerName(name);
    }


}
