package allpccollector.repository;

import allpccollector.model.Computer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComputerRepository extends JpaRepository<Computer, Long>{

    Computer findComputerByComputerName(String name);
   // Computer findComputerByName(String name);
    Computer findComputerByCpuId(String cpuId);

}
