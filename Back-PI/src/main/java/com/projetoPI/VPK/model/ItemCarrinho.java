package com.projetoPI.VPK.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name="tb_item_carrinho")
public class ItemCarrinho {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name="quantidade")
        private int quantidade;

        @ManyToOne
        @JoinColumn(name = "id_carrinho", nullable = false)
        private Carrinho carrinho;

        @ManyToOne
        @JoinColumn(name="id_produto", nullable = false)
        private Produto produto;

        @Column(name="ativo")
        private boolean ativo;

        public ItemCarrinho() {
        }

        public ItemCarrinho(Long id, int quantidade, Carrinho carrinho, Produto produto, boolean ativo) {
                this.id = id;
                this.quantidade = quantidade;
                this.carrinho = carrinho;
                this.produto = produto;
                this.ativo = ativo;
        }


        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public int getQuantidade() {
                return quantidade;
        }

        public void setQuantidade(int quantidade) {
                this.quantidade = quantidade;
        }

        public Carrinho getCarrinho() {
                return carrinho;
        }

        public void setCarrinho(Carrinho carrinho) {
                this.carrinho = carrinho;
        }

        public Produto getProduto() {
                return produto;
        }

        public void setProduto(Produto produto) {
                this.produto = produto;
        }

        public boolean isAtivo() {
                return ativo;
        }

        public void setAtivo(boolean ativo) {
                this.ativo = ativo;
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                ItemCarrinho that = (ItemCarrinho) o;
                return quantidade == that.quantidade && ativo == that.ativo && Objects.equals(id, that.id) && Objects.equals(carrinho, that.carrinho) && Objects.equals(produto, that.produto);
        }

        @Override
        public int hashCode() {
                return Objects.hash(id, quantidade, carrinho, produto, ativo);
        }


        @Override
        public String toString() {
                return "ItemCarrinho{" +
                        "id=" + id +
                        ", quantidade=" + quantidade +
                        ", carrinho=" + carrinho +
                        ", produto=" + produto +
                        ", ativo=" + ativo +
                        '}';
        }
}
