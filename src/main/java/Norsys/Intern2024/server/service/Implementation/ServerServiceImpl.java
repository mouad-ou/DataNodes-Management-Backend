package Norsys.Intern2024.server.service.Implementation;

import Norsys.Intern2024.server.enumeration.Status;
import Norsys.Intern2024.server.model.Server;
import Norsys.Intern2024.server.repo.ServerRepo;
import Norsys.Intern2024.server.service.ServerService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.type.TrueFalseConverter;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Collection;
import java.util.Random;

import static Norsys.Intern2024.server.enumeration.Status.SERVER_DOWN;
import static Norsys.Intern2024.server.enumeration.Status.SERVER_UP;
import static java.lang.Boolean.TRUE;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class ServerServiceImpl implements ServerService {
    private final ServerRepo serverRepo; // Inject ServerRepo instance

    @Override
    public Server create(Server server) {
        log.info("Saving new server: {}",server.getName());
        server.setImageUrl(setServerImageUrl());
        return serverRepo.save(server); // Use the instance to call the method
    }

    @Override
    public Server ping(String ipAdress) throws IOException {
        log.info("Pinging Server's IP: {}",ipAdress);
        Server server = serverRepo.findByipAdress(ipAdress); // Use the instance to call the method
        InetAddress address = InetAddress.getByName(ipAdress);
        server.setStatus(address.isReachable(10000) ? SERVER_UP : SERVER_DOWN);
        serverRepo.save(server); // Use the instance to call the method
        return server;
    }

    @Override
    public Collection<Server> list(int limit) {
        log.info("Fetching all the servers");
        return serverRepo.findAll(PageRequest.of(0 ,limit)).toList(); // Use the instance to call the method
    }

    @Override
    public Server get(Long id) {
        log.info("fetch Adress by ID");
        return serverRepo.findById(id).get();
    }

    @Override
    public Server update(Server server) {
        log.info("Updating Server {}", server.getName());
        return serverRepo.save(server);
    }

    @Override
    public boolean delete(Long id) {
        log.info("Deleting Server by ID {}", id);
        serverRepo.deleteById(id);
        return true; // You need to implement this method
    }
    private String setServerImageUrl() {
        String[] imageNames = {"server1.jpg", "server2.jpg","server3.jpg","server4.jpg"};
        return ServletUriComponentsBuilder.fromCurrentContextPath().path("/server/image" + imageNames[new Random().nextInt(4)]).toUriString(); // You need to implement this method
    }
}