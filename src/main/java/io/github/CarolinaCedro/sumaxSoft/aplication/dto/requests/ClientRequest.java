package io.github.CarolinaCedro.sumaxSoft.aplication.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientRequest {

    private Long id;

    @NotEmpty(message = "{campo.name.obrigatorio}")
    @Size(min = 3, max = 20, message = "{campo.name.size}")
    private String name;

    @NotEmpty(message = "{campo.lastName.obrigatorio}")
    @Size(min = 3, max = 20, message = "{campo.lastName.size}")
    private String lastName;
    @NotEmpty(message = "{campo.cpf.obrigatorio}")
    @Size(min = 11, max = 11, message = "{campo.cpf.size}")
    private String cpf;
    @NotEmpty(message = "{campo.city.obrigatorio}")
    @Size(min = 4, max = 50, message = "{campo.city.size}")
    private String city;

    @NotEmpty(message = "{campo.telephone.obrigatorio}")
    @Size(min = 7, max = 20, message = "{campo.telephone.size}")
    private String telephone;

    @NotEmpty(message = "{campo.celullar.obrigatorio}")
    @Size(min = 7, max = 20, message = "{campo.celullar.size}")
    private String celullar;

    @NotEmpty(message = "{campo.email.obrigatorio}")
    @Size(min = 7, max = 30, message = "{campo.email.size}")
    private String email;

    public ClientRequest(Long id) {
        this.id = id;
    }

    public ClientRequest(String name, String lastName, String cpf, String city, String telephone, String celullar, String email) {
        this.name = name;
        this.lastName = lastName;
        this.cpf = cpf;
        this.city = city;
        this.telephone = telephone;
        this.celullar = celullar;
        this.email = email;
    }
}
