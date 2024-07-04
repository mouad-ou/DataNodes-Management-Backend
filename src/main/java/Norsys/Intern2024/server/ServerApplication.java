package Norsys.Intern2024.server;

import Norsys.Intern2024.server.enumeration.Status;
import Norsys.Intern2024.server.model.Server;
import Norsys.Intern2024.server.repo.ServerRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}
	@Bean
	CommandLineRunner run(ServerRepo serverRepo){
		return args -> 	{
			serverRepo.save(new Server(null, "192.168.1.160", "Ubuntu Linux","16GB", "Personal PC", "http://localhost:8080/server/image/server1.png", Status.SERVER_UP));
			serverRepo.save(new Server(null, "192.168.1.161", "Fedora Linux","16GB", "Dell PC", "http://localhost:8080/server/image/server1.png", Status.SERVER_UP));
			serverRepo.save(new Server(null, "192.168.1.162", "MS 2008","32GB", "Web PC", "http://localhost:8080/server/image/server1.png", Status.SERVER_UP));
			serverRepo.save(new Server(null, "192.168.1.163", "Red Hat Entr Linux","64GB", "Maim server", "http://localhost:8080/server/image/server1.png", Status.SERVER_UP));
		};
	}
}
