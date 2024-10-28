package ms_clients.models.dto;

import ms_clients.models.entity.Client;

public record ClientSaveRequest(
        String cpf,
        String name,
        Integer yearsOld
) {
    public Client toEntity(){
        return new Client(
                this.cpf,
                this.name,
                this.yearsOld
        );
    }
}
