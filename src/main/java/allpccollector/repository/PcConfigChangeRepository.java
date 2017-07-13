package allpccollector.repository;

import allpccollector.model.PcConfigChange;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PcConfigChangeRepository extends JpaRepository<PcConfigChange, Long> {
}
