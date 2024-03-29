package br.com.james.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.james.models.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {


}
