package allpccollector.repository;



import allpccollector.model.ComputerProperty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComputerParamRepository extends JpaRepository<ComputerProperty, Long> {
}
