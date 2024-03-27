package br.com.james.config.seed;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import br.com.james.models.Admin;
import br.com.james.models.Fisiologia;
import br.com.james.models.Humor;
import br.com.james.models.Paciente;
import br.com.james.models.Psicologo;
import br.com.james.models.Role;
import br.com.james.models.RoleName;
import br.com.james.models.Sentimento;
import br.com.james.repositories.AdminRepository;
import br.com.james.repositories.FisiologiaRepository;
import br.com.james.repositories.HumorRepository;
import br.com.james.repositories.PacienteRepository;
import br.com.james.repositories.PsicologoRepository;
import br.com.james.repositories.RoleRepository;
import br.com.james.repositories.SentimentoRepository;
import jakarta.transaction.Transactional;

@Component
public class DatabaseSeeder {

	@Autowired
	public RoleRepository roleRepository;

	@Autowired
	HumorRepository humorRepository;

	@Autowired
	FisiologiaRepository fisiologiaRepository;

	@Autowired
	SentimentoRepository sentimentoRepository;

	@Autowired
	public AdminRepository adminRepository;

	@Autowired
	public PsicologoRepository psicologoRepository;

	@Autowired
	public PacienteRepository pacienteRepository;

	@EventListener
	public void seed(ContextRefreshedEvent event) {
		seedAdminRoleTable();
	}

	@Transactional
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
				admin.setSenha("$2a$10$IGbm.HwIZ4a9BeYmwXrNleN/jzKVvoPSs0UeJka.7S6sC0FdqFIRy");
				admin.setRoles(Set.of(roleAdm));
				adminRepository.save(admin);

				Psicologo psicologo = new Psicologo();
				psicologo.setEmail("jamesribeiro2@gmail.com");
				psicologo.setNome("James2");
				psicologo.setSobrenome("Ribeiro2");
				psicologo.setSenha("$2a$10$IGbm.HwIZ4a9BeYmwXrNleN/jzKVvoPSs0UeJka.7S6sC0FdqFIRy");
				psicologo.setRoles(Set.of(rolePsc));
				psicologoRepository.save(psicologo);

				Paciente paciente = new Paciente();
				paciente.setEmail("jamesribeiro3@gmail.com");
				paciente.setNome("James3");
				paciente.setSobrenome("Ribeiro3");
				paciente.setSenha("$2a$10$IGbm.HwIZ4a9BeYmwXrNleN/jzKVvoPSs0UeJka.7S6sC0FdqFIRy");
				paciente.setPsicologo(psicologo);
				paciente.setRoles(Set.of(rolePac));
				pacienteRepository.save(paciente);
			}

		}

		if (sentimentoRepository.count() == 0) {
			Sentimento s1 = new Sentimento();
			Sentimento s2 = new Sentimento();
			Sentimento s3 = new Sentimento();
			Sentimento s4 = new Sentimento();

			s1.setTexto("Amoroso");
			s2.setTexto("Feliz");
			s3.setTexto("Medo");
			s4.setTexto("Triste");

			Humor humor1 = new Humor();
			Humor humor2 = new Humor();
			humor1.setTexto("Humor Positivo");
			humor2.setTexto("Humor Negativo");

			humor1.setSentimentos(Set.of(s1, s2));
			humor2.setSentimentos(Set.of(s3, s4));

			s1.setHumores(Set.of(humor1));
			s2.setHumores(Set.of(humor1));
			s3.setHumores(Set.of(humor2));
			s4.setHumores(Set.of(humor2));

			humorRepository.save(humor1);
			humorRepository.save(humor2);

			sentimentoRepository.save(s1);
			sentimentoRepository.save(s2);
			sentimentoRepository.save(s3);
			sentimentoRepository.save(s4);

		}

		if (fisiologiaRepository.count() == 0) {
			Fisiologia f1 = new Fisiologia();
			Fisiologia f2 = new Fisiologia();
			Fisiologia f3 = new Fisiologia();

			f1.setTexto("Tontura");
			f2.setTexto("Sudorese");
			f3.setTexto("Agitação");

			fisiologiaRepository.save(f1);
			fisiologiaRepository.save(f2);
			fisiologiaRepository.save(f3);
		}
	}

}
