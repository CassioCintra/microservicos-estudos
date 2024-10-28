package ms_clients.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import ms_clients.models.dto.ClientSaveRequest;
import ms_clients.models.entity.Client;
import ms_clients.repository.ClientRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository repository;

    @Transactional
    public void save(ClientSaveRequest client){
        repository.save(client.toEntity());
    }

    @Transactional
    public Client getByCpf(String cpf){
        return repository.findByCpf(cpf)
                .orElseThrow(
                        () -> new EntityNotFoundException("Client not found")
                );
    }
}
