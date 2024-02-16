package br.com.james.config.seed;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import br.com.james.models.Admin;
import br.com.james.models.Role;
import br.com.james.models.RoleName;
import br.com.james.repositories.AdminRepository;
import br.com.james.repositories.RoleRepository;

@Component
public class DatabaseSeeder {

	@Autowired
	public RoleRepository roleRepository;

	@Autowired
	public AdminRepository adminRepository;

	@EventListener
	public void seed(ContextRefreshedEvent event) {
		seedAdminRoleTable();
	}

	public void seedAdminRoleTable() {

		if (roleRepository.count() == 0) {
			Role roleAdm = new Role();
			roleAdm.setNome(RoleName.ADMIN);
			roleRepository.save(roleAdm);

			Role rolePsc = new Role();
			rolePsc.setNome(RoleName.PSC);
			roleRepository.save(rolePsc);

			Role rolePac = new Role();
			rolePac.setNome(RoleName.PAC);
			roleRepository.save(rolePac);

			if (adminRepository.count() == 0) {
				Admin admin = new Admin();
				admin.setEmail("jamesribeiro@gmail.com");
				admin.setNome("James");
				admin.setSobrenome("Ribeiro");
				admin.setSenha("senha123");
				admin.setRoles(Set.of(roleAdm));
				adminRepository.save(admin);
			}

		}
	}

}
