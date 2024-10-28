package ms_clients.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ms_clients.models.dto.ClientSaveRequest;
import ms_clients.models.entity.Client;
import ms_clients.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
@Slf4j
public class ClientController {
    private final ClientService service;

    @GetMapping
    public String status() {
        return "Ok";
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody ClientSaveRequest client) {
        service.save(client);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Client> getClient(@PathVariable String cpf) {
        return ResponseEntity.ok(
                service.getByCpf(cpf)
        );
    }
}
