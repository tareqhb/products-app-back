package be.bt.repository;

import be.bt.domain.security.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityReository extends JpaRepository<Authority, Long> {
}
