package io.github.CarolinaCedro.sumaxSoft.aplication.service.impl;

import io.github.CarolinaCedro.sumaxSoft.aplication.dto.requests.ServiceProvidedDtoRequest;
import io.github.CarolinaCedro.sumaxSoft.aplication.dto.responses.ServiceProvidedDtoResponse;
import io.github.CarolinaCedro.sumaxSoft.aplication.service.ServiceProvidedService;
import io.github.CarolinaCedro.sumaxSoft.aplication.utils.BigDecimalConverter;
import io.github.CarolinaCedro.sumaxSoft.config.modelMapper.ModelMapperConfig;
import io.github.CarolinaCedro.sumaxSoft.model.Client;
import io.github.CarolinaCedro.sumaxSoft.model.ServiceProvided;
import io.github.CarolinaCedro.sumaxSoft.repository.ClientRepository;
import io.github.CarolinaCedro.sumaxSoft.repository.ServiceProvidedRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ServiceProvidedServiceImpl implements ServiceProvidedService {

    private final ClientRepository clienteRepository;
    private final ServiceProvidedRepository serviceProvidedRepository;

    private final ModelMapperConfig mapper;
    private final BigDecimalConverter bigDecimalConverter;

    @Override
    public ServiceProvidedDtoResponse saveServiceProvided(ServiceProvidedDtoRequest serviceProvidedDtoRequest) {
        LocalDate data = LocalDate.parse(serviceProvidedDtoRequest.getDate(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        Long idCliente = serviceProvidedDtoRequest.getId_client();

        Client client =
                clienteRepository
                        .findById(idCliente)
                        .orElseThrow(() ->
                                new ResponseStatusException(
                                        HttpStatus.BAD_REQUEST, "Cliente inexistente."));


        ServiceProvided serviceProvided = new ServiceProvided();
        serviceProvided.setDescription(serviceProvidedDtoRequest.getDescription());
        serviceProvided.setDate( data );
        serviceProvided.setClient(client);
        serviceProvided.setValueService( bigDecimalConverter.converter(serviceProvidedDtoRequest.getValueService())  );

         ServiceProvided service = serviceProvidedRepository.save(serviceProvided);
         return mapper.convert().map(service,ServiceProvidedDtoResponse.class);
    }

    @Override
    public List<ServiceProvidedDtoResponse> searchServiceProvided(String nome, Integer mes) {
        return serviceProvidedRepository.findByNameClienteAndMonth("%" + nome + "%", mes).stream().map(this::dtoServiceProviderForEntity).collect(Collectors.toList());
    }

    public ServiceProvidedDtoResponse dtoServiceProviderForEntity(ServiceProvided serviceProvided) {
        return mapper.convert().map(serviceProvided, ServiceProvidedDtoResponse.class);
    }
}
