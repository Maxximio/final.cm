package ec.edu.uce;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableAsync
public class Aplicativo implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(Aplicativo.class);

	

	public static void main(String[] args) {
		SpringApplication.run(Aplicativo.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


	}

}
