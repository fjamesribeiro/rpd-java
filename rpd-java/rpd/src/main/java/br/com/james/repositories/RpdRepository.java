package br.com.james.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.james.models.Rpd;

@Repository
public interface RpdRepository extends JpaRepository<Rpd, Long> {

}
