package io.github.CarolinaCedro.sumaxSoft.aplication.controller;

import io.github.CarolinaCedro.sumaxSoft.aplication.dto.requests.ClientRequest;
import io.github.CarolinaCedro.sumaxSoft.aplication.dto.responses.ClientResponse;
import io.github.CarolinaCedro.sumaxSoft.aplication.service.impl.ClientServiceImpl;
import io.github.CarolinaCedro.sumaxSoft.config.modelMapper.ModelMapperConfig;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@AllArgsConstructor
@Api(value="Clientes")
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/clients")
public class ClientController {

    private final ClientServiceImpl clientService;
    private final ModelMapperConfig mapper;

    @GetMapping
    @ApiOperation(value = "Lista todos os clientes")
    public ResponseEntity<Page<ClientResponse>> getAll(@PageableDefault(page = 0, size = 15, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(clientService.getAll(pageable));
    }

    @GetMapping("/filter")
    public ResponseEntity<List<ClientResponse>> getByNameFilter(@RequestParam("name") String name) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(clientService.findCustomerByName(name));
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Lista somente 1 cliente")
    public ResponseEntity<ClientResponse> getById(@PathVariable Long id) {
        ClientResponse client = clientService.getById(id).orElse(null);
        return client != null ? ResponseEntity.ok(client) : ResponseEntity.notFound().build();
    }

    @PostMapping
    @ApiOperation(value = "Cria um cliente")
    public ResponseEntity<ClientResponse>saveClient(@RequestBody @Valid ClientRequest request) throws IOException {
        ClientResponse newAddress = clientService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.convert().map(newAddress,ClientResponse.class));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Faz alterações em um cliente existente")
    public ResponseEntity<ClientResponse>updateClient(@PathVariable Long id, @RequestBody @Valid ClientRequest request) throws IOException {
        request.setId(id);
        return ResponseEntity.ok().body(mapper.convert().map(clientService.update(id,request),ClientResponse.class));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Deleta um cliente existente")
    public ResponseEntity<ClientResponse>deleteById(@PathVariable Long id){
        clientService.deleteById(id);
        return ResponseEntity.noContent().build();
    }



}
