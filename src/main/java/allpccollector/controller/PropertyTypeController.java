package allpccollector.controller;

import allpccollector.model.PropertyType;
import allpccollector.repository.PropertyTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/propertytypes")
public class PropertyTypeController {

    @Autowired
    PropertyTypeRepository propertyTypeRepository;

    @RequestMapping(method = RequestMethod.GET)
    List<PropertyType> findAll(){
        return propertyTypeRepository.findAll();
    }

}
