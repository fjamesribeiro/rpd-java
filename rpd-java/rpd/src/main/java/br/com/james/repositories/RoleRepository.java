package br.com.james.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.james.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
