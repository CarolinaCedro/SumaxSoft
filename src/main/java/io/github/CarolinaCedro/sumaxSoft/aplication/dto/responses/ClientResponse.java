package io.github.CarolinaCedro.sumaxSoft.aplication.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}
