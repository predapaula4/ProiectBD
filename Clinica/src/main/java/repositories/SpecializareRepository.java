package repositories;

import entities.Specializare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecializareRepository extends JpaRepository<Specializare, Long> {
}