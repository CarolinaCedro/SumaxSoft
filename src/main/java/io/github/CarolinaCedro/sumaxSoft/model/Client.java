package io.github.CarolinaCedro.sumaxSoft.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 20)
    @NotNull(message = "{campo.name.obrigatorio}")
    @Size(min = 3, max = 20, message = "{campo.name.size}")
    private String name;

    @Column(nullable = false, length = 20)
    @NotNull(message = "{campo.lastName.obrigatorio}")
    @Size(min = 3, max = 20, message = "{campo.lastName.size}")
    private String lastName;

    @Column(nullable = false, length = 11)
    @NotNull(message = "{campo.logradouro.obrigatorio}")
    @Size(min = 11, max = 11, message = "{campo.logradouro.size}")
    @CPF
    private String cpf;

    @Column(nullable = false, length = 50)
    @NotNull(message = "{campo.city.obrigatorio}")
    @Size(min = 4, max = 50, message = "{campo.city.size}")
    private String city;

    @Column(nullable = false, length = 20)
    @NotNull(message = "{campo.telephone.obrigatorio}")
    @Size(min = 7, max = 20, message = "{campo.telephone.size}")
    private String telephone;

    @Column(nullable = false, length = 50)
    @NotNull(message = "{campo.celullar.obrigatorio}")
    @Size(min = 7, max = 20, message = "{campo.celullar.size}")
    private String celullar;

    @Column(nullable = false, length = 30)
    @Email
    @NotNull(message = "{campo.logradouro.obrigatorio}")
    @Size(min = 7, max = 30, message = "{campo.logradouro.size}")
    private String email;

    @Column(name = "date_register", updatable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate date_register;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<ServiceProvided> items = new ArrayList<>();



    @PrePersist
    public void prePersist(){
        setDate_register(LocalDate.now());
    }

}
