package restfulapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import restfulapi.entity.Local;

import java.util.Optional;

public interface LocalRepository extends JpaRepository<Local, Long>, JpaSpecificationExecutor<Local> {
    @Query("select l from Local l where upper(l.name) = upper(:name)")
    Optional<Local> findByNameIgnoreCase(String name);

}
