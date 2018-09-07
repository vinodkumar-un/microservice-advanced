package com.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

import com.cache.repository.PersonRepository;

@SpringBootApplication
@ComponentScan("com.cache")
@EnableCaching
public class SpringBootCacheApplication implements CommandLineRunner {

	private static final Logger LOG = LoggerFactory.getLogger(SpringBootCacheApplication.class);

	@Autowired
	private PersonRepository personRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCacheApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		LOG.info("... fetching persons");
		LOG.info("isbn-1233	--->"+personRepository.getPersonDetails("vinod"));

	}

}
