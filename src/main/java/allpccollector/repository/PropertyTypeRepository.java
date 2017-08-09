package allpccollector.repository;

import allpccollector.model.PropertyType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyTypeRepository extends JpaRepository<PropertyType, Long> {
    PropertyType findByName(String name);
}
