package io.github.CarolinaCedro.sumaxSoft.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    private String cpf;
    private String city;
    private String telephone;
    private String celullar;
    private String email;

    @Column(columnDefinition = "TIMESTAMP")
    private Timestamp creationService;

}
