package br.com.james.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.james.models.Humor;

@Repository
public interface HumorRepository extends JpaRepository<Humor, Long> {

}
