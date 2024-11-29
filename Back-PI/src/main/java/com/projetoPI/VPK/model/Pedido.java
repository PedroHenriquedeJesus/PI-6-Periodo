package com.projetoPI.VPK.model;

import com.projetoPI.VPK.model.Enum.StatusDoPedido;
import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name="TB_PEDIDO")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Instant data; //validar a nescessidade

    @Enumerated(EnumType.STRING)
    private StatusDoPedido statusDoPedido;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "entregador_id")
    private Entregador entregador;


}
