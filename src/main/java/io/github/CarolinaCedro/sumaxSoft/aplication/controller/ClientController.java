package io.github.CarolinaCedro.sumaxSoft.aplication.controller;

import io.github.CarolinaCedro.sumaxSoft.aplication.dto.responses.ClientResponse;
import io.github.CarolinaCedro.sumaxSoft.aplication.service.impl.ClientServiceImpl;
import io.github.CarolinaCedro.sumaxSoft.model.Client;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/clients")
public class ClientController {


    private final ClientServiceImpl clientService;


    @GetMapping
    public ResponseEntity<Page<ClientResponse>> getAll(@PageableDefault(page = 0, size = 15, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(clientService.getAll(pageable));
    }



}
