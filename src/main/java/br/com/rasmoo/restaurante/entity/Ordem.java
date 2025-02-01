package br.com.rasmoo.restaurante.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ordens")
public class Ordem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column(name = "valor_total")
    private BigDecimal valorTotal;

    @Column(name = "data_de_cricao")
    private LocalDateTime dataDeCriacao = LocalDateTime.now();

    @ManyToOne
    private Cliente cliente;

    @OneToMany(mappedBy = "ordem", cascade = CascadeType.ALL)
    private List<OrdensCardapio> ordensCardapioList = new ArrayList<>();

    public Ordem() {
    }

    public void addOrdensCardapio(OrdensCardapio ordensCardapio){
        ordensCardapio.setOrdem(this);
        this.ordensCardapioList.add(ordensCardapio);
    }

    public Ordem(Cliente cliente) {
        this.cliente = cliente;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public LocalDateTime getDataDeCriacao() {
        return dataDeCriacao;
    }

    public void setDataDeCriacao(LocalDateTime dataDeCriacao) {
        this.dataDeCriacao = dataDeCriacao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<OrdensCardapio> getOrdensCardapioList() {
        return ordensCardapioList;
    }

    public void setOrdensCardapioList(List<OrdensCardapio> ordensCardapioList) {
        this.ordensCardapioList = ordensCardapioList;
    }

    @Override
    public String toString() {
        return "Ordem{" +
                "Id=" + Id +
                ", valorTotal=" + valorTotal +
                ", dataDeCriacao=" + dataDeCriacao +
                ", cliente=" + cliente +
                '}';
    }
}
