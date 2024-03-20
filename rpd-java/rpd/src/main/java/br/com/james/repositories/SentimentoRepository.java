package br.com.james.repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.james.models.Sentimento;

@Repository
public interface SentimentoRepository extends JpaRepository<Sentimento, Long> {
	
	Set<Sentimento> findByHumoresId(Long id);

}
