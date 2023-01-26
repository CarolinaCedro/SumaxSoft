package io.github.CarolinaCedro.sumaxSoft.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;


    @Entity
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class ServiceProvided {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false, length = 150)
        private String description;

        @ManyToOne
        @JoinColumn(name = "id_client")
        private Client client;

        @Column
        private BigDecimal valueService;

        @Column
        @JsonFormat(pattern = "dd/MM/yyyy")
        private LocalDate date;
    }