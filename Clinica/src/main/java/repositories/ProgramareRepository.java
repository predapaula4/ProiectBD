package repositories;

import entities.Programare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramareRepository extends JpaRepository<Programare, Long> {
}