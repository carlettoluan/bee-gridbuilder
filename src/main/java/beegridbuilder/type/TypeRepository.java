package beegridbuilder.type;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface TypeRepository extends JpaRepository<Type, Long>{
  
}
