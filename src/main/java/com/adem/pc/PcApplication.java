package com.adem.pc;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.adem.pc.entities.Pc;
import com.adem.pc.service.PcService;

@SpringBootApplication
public class PcApplication  implements CommandLineRunner  {
	@Autowired
	PcService pcService;
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;
	public static void main(String[] args) {
		SpringApplication.run(PcApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {

		
		repositoryRestConfiguration.exposeIdsFor(Pc.class);
	}
}
