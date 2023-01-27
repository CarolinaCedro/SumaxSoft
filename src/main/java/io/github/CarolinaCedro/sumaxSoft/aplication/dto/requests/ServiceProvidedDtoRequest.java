package io.github.CarolinaCedro.sumaxSoft.aplication.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceProvidedDtoRequest {

    private Long id;

    @NotEmpty(message = "{campo.description.obrigatorio}")
    @Size(min = 7, max = 150, message = "{campo.description.size}")
    private String description;

    @NotEmpty(message = "{campo.valueService.obrigatorio}")
    private String valueService;

    @NotEmpty(message = "{campo.date.obrigatorio}")
    private String date;

    @NotNull(message = "{campo.client.obrigatorio}")
    private Long id_client;
}
