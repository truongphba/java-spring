package truongph.java_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import truongph.java_spring.entity.Account;

public interface AccountRepository extends JpaRepository<Account, String> {
}
