package rw.vladvisionlab.inzozi.repositories;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import rw.vladvisionlab.inzozi.models.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByEmail(String username);
}
