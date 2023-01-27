package io.github.CarolinaCedro.sumaxSoft.aplication.controller;

import io.github.CarolinaCedro.sumaxSoft.aplication.dto.requests.ServiceProvidedDtoRequest;
import io.github.CarolinaCedro.sumaxSoft.aplication.dto.responses.ServiceProvidedDtoResponse;
import io.github.CarolinaCedro.sumaxSoft.aplication.service.impl.ServiceProvidedServiceImpl;
import io.github.CarolinaCedro.sumaxSoft.aplication.utils.BigDecimalConverter;
import io.github.CarolinaCedro.sumaxSoft.config.modelMapper.ModelMapperConfig;
import io.github.CarolinaCedro.sumaxSoft.model.ServiceProvided;
import io.github.CarolinaCedro.sumaxSoft.repository.ClientRepository;
import io.github.CarolinaCedro.sumaxSoft.repository.ServiceProvidedRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/servicos-prestados")
@CrossOrigin("http://localhost:4200")
@Api(value="Serviços prestados")
@RequiredArgsConstructor
public class ServiceProvidedController  {

    private final ClientRepository clienteRepository;
    private final ServiceProvidedServiceImpl service;
    private final ModelMapperConfig mapper;
    private final ServiceProvidedRepository serviceProvidedRepository;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Cria um serviço")
    public ServiceProvidedDtoResponse saveServiceProvided(@RequestBody @Valid ServiceProvidedDtoRequest serviceProvidedDtoRequest){
        ServiceProvidedDtoResponse serviceProvided = service.saveServiceProvided(serviceProvidedDtoRequest);
        return mapper.convert().map(serviceProvided,ServiceProvidedDtoResponse.class);
    }

    @GetMapping
    public List<ServiceProvidedDtoResponse> searchServiceProvided(
            @RequestParam(value = "nome", required = false, defaultValue = "") String nome,
            @RequestParam(value = "mes", required = false) Integer mes
    ) {
        return service.searchServiceProvided(nome,mes);
    }

}
