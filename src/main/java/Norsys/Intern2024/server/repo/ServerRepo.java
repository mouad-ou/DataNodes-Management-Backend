package Norsys.Intern2024.server.repo;

import Norsys.Intern2024.server.model.Server;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServerRepo extends JpaRepository<Server,Long> {
    Server findByipAdress(String ipAdress);
}
