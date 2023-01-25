package io.github.CarolinaCedro.sumaxSoft.aplication.service.impl;

import io.github.CarolinaCedro.sumaxSoft.aplication.dto.requests.ClientRequest;
import io.github.CarolinaCedro.sumaxSoft.aplication.dto.responses.ClientResponse;
import io.github.CarolinaCedro.sumaxSoft.aplication.service.ClientService;
import io.github.CarolinaCedro.sumaxSoft.config.app.AppConstants;
import io.github.CarolinaCedro.sumaxSoft.model.Client;
import io.github.CarolinaCedro.sumaxSoft.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {


    private final ClientRepository clientRepository;
    private ModelMapper mapper;

    @Override
    public Page<ClientResponse> getAll(Pageable pageable) {
        if (!pageable.getSort().isSorted()) {
            pageable = PageRequest.of(pageable.getPageNumber(),
                    pageable.getPageSize(), Sort.by(AppConstants.UPDATED_ON).descending());
        }

        Page<Client> page = clientRepository.findAll(pageable);
        return page.map(this::dto);
    }

    @Override
    public Optional<ClientResponse> getById(Long id) {
        return Optional.empty();
    }

    @Override
    public ClientResponse save(ClientRequest request) throws IOException {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public ClientResponse update(Long id, ClientRequest request) throws IOException {
        return null;
    }

    public ClientResponse dto(Client client) {
        return mapper.map(client,ClientResponse.class);
    }

}
