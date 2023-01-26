package io.github.CarolinaCedro.sumaxSoft.aplication.dto.responses;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.github.CarolinaCedro.sumaxSoft.model.Client;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceProvidedDtoResponse {

    private Long id;
    private String description;
    private Client client;
    private BigDecimal valueService;

    @Column
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate date;
}
