package io.github.CarolinaCedro.sumaxSoft.aplication.service.impl;

import io.github.CarolinaCedro.sumaxSoft.aplication.dto.requests.ClientRequest;
import io.github.CarolinaCedro.sumaxSoft.aplication.dto.responses.ClientResponse;
import io.github.CarolinaCedro.sumaxSoft.aplication.errors.exception.ClientNotFoundException;
import io.github.CarolinaCedro.sumaxSoft.aplication.service.ClientService;
import io.github.CarolinaCedro.sumaxSoft.config.app.AppConstants;
import io.github.CarolinaCedro.sumaxSoft.config.modelMapper.ModelMapperConfig;
import io.github.CarolinaCedro.sumaxSoft.model.Client;
import io.github.CarolinaCedro.sumaxSoft.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {


    private final ClientRepository clientRepository;

    private final ModelMapperConfig mapper;
    private final ModelMapper modelMapper;

    @Cacheable("addresses")
    @Override
    public Page<ClientResponse> getAll(Pageable pageable) {
        if (!pageable.getSort().isSorted()) {
            pageable = PageRequest.of(pageable.getPageNumber(),
                    pageable.getPageSize(), Sort.by(AppConstants.UPDATED_ON).descending());
        }

        Page<Client> page = clientRepository.findAll(pageable);
        return page.map(this::dto);
    }

    public Optional<ClientResponse> getById(Long id) {
        return clientRepository.findById(id).map(this::convertClient);
    }




    @Override
    @Transactional
    @Caching(evict = {
            @CacheEvict(value = "addresses", allEntries = true),
            @CacheEvict(value = "address", allEntries = true)})
    public ClientResponse save(ClientRequest request) throws IOException {
        Client client = clientRepository.save(mapper.convert().map(request,Client.class));
        return mapper.convert().map(client,ClientResponse.class);
    }

    @Override
    @Transactional
    @Caching(evict = {
            @CacheEvict(value = "addresses", allEntries = true),
            @CacheEvict(value = "address", allEntries = true)})
    public ClientResponse update(Long id, ClientRequest request) throws IOException {
        Assert.notNull(id, "Unable to update registration");
        Optional<Client> optional = Optional.ofNullable(clientRepository.findById(id).orElseThrow(
                () -> new ClientNotFoundException("Cliente não encontrado")
        ));

        Client response = new Client();
        if (optional.isPresent()) {
            Client db = optional.get();

            db.setName(request.getName());
            db.setLastName(request.getLastName());
            db.setCelullar(request.getCelullar());
            db.setCity(request.getCity());
            db.setCpf(request.getCpf());
            db.setEmail(request.getEmail());
            db.setTelephone(request.getTelephone());

            clientRepository.save(db);
            response = db;
        }
        return mapper.convert().map(response,ClientResponse.class);
    }


    @Transactional
    @Override
    @Caching(evict = {
            @CacheEvict(value = "addresses", allEntries = true),
            @CacheEvict(value = "address", allEntries = true)})
    public void deleteById(Long id) {
        Optional<Client> customer = clientRepository.findById(id);
        if (customer.isPresent()) {
            clientRepository.deleteById(id);
        }
    }


    public ClientResponse dto(Client client) {
        return mapper.convert().map(client,ClientResponse.class);
    }

    public ClientResponse convertClient(Client client) {
        return modelMapper.map(client, ClientResponse.class);
    }


}
