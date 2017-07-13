package allpccollector.repository;

import allpccollector.model.PropertyType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParamTypeRepository extends JpaRepository<PropertyType, Long> {
}
