package io.github.CarolinaCedro.sumaxSoft.aplication.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientResponse {

    private Long id;
    private String name;
    private String lastName;
    private String cpf;
    private String city;
    private String telephone;
    private String celullar;
    private String email;
    private LocalDate date_register;
}
