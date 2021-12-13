package com.andre.os.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.andre.os.domain.Cliente;
import com.andre.os.domain.OS;
import com.andre.os.domain.Tecnico;
import com.andre.os.domain.enums.Prioridade;
import com.andre.os.domain.enums.Status;
import com.andre.os.repositories.ClienteRepository;
import com.andre.os.repositories.OSRepository;
import com.andre.os.repositories.TecnicoRepository;

@Service
public class DBService {

	@Autowired
	private TecnicoRepository tecnicoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private OSRepository osRepository;

	public void instanciaDB() {
		Tecnico t1 = new Tecnico(null, "André Luis Lacerda", "935.388.300-88", "(61) 98587-8097");
		Cliente c1 = new Cliente(null, "Roberto Vagner", "550.412.490-59", "(61) 99909-7474");
		OS os1 = new OS(null, Prioridade.ALTA, Status.ANDAMENTO, "Teste create OS", t1, c1);

		t1.getList().add(os1);
		c1.getList().add(os1);

		tecnicoRepository.saveAll(Arrays.asList(t1));
		clienteRepository.saveAll(Arrays.asList(c1));
		osRepository.saveAll(Arrays.asList(os1));
	}

}
