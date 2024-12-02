package com.projetoPI.VPK.controllers;
import com.projetoPI.VPK.model.dto.PedidoDTO;
import com.projetoPI.VPK.services.PedidoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<PedidoDTO> findById(@PathVariable Long id) {
        PedidoDTO dto = pedidoService.findById(id);
        return ResponseEntity.ok(dto);
    }


    @PostMapping
    public ResponseEntity<PedidoDTO >insert(@Valid @RequestBody PedidoDTO dto){

        dto =  pedidoService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
    @PutMapping (value = "/{id}")
    public ResponseEntity<PedidoDTO> update(@Valid @RequestBody PedidoDTO dto, @PathVariable Long id){
        dto = pedidoService.update(id,dto);
        return  ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<PedidoDTO>> findAll(){

        List<PedidoDTO> dto = pedidoService.findAll();
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping (value = "/{id}")
    public ResponseEntity<Void> Delete(@PathVariable Long id){
        pedidoService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
