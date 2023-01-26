package io.github.CarolinaCedro.sumaxSoft.aplication.service;

import io.github.CarolinaCedro.sumaxSoft.aplication.dto.requests.ServiceProvidedDtoRequest;
import io.github.CarolinaCedro.sumaxSoft.aplication.dto.responses.ServiceProvidedDtoResponse;
import io.github.CarolinaCedro.sumaxSoft.model.ServiceProvided;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

public interface ServiceProvidedService {

    ServiceProvidedDtoResponse saveServiceProvided(@RequestBody @Valid ServiceProvidedDtoRequest serviceProvidedDto );
    List<ServiceProvidedDtoResponse> searchServiceProvided(
            @RequestParam(value = "nome", required = false, defaultValue = "") String nome,
            @RequestParam(value = "mes", required = false) Integer mes
    );

}
