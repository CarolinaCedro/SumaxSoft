package io.github.CarolinaCedro.sumaxSoft.aplication.service;

import io.github.CarolinaCedro.sumaxSoft.aplication.dto.requests.ClientRequest;
import io.github.CarolinaCedro.sumaxSoft.aplication.dto.responses.ClientResponse;
import io.github.CarolinaCedro.sumaxSoft.model.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface ClientService {

    Page<ClientResponse> getAll(Pageable pageable);

    List<ClientResponse> findCustomerByName(String name);

    Optional<ClientResponse> getById(Long id);

    ClientResponse save(ClientRequest request) throws IOException;

    void deleteById(Long id);

    ClientResponse update(Long id, ClientRequest request) throws IOException;


}
