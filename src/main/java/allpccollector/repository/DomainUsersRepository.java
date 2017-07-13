package allpccollector.repository;

import allpccollector.model.DomainUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DomainUsersRepository extends JpaRepository<DomainUser, Long>{

    public DomainUser findDomainUserByUsername(String username);
}
