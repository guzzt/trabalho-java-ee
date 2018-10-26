package br.ifmg.bruno.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Aluguel implements Serializable {

	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codigo;
    @Temporal(TemporalType.DATE)
	private Date dtPedido;
    @Temporal(TemporalType.TIMESTAMP)
	private Date dtEntrega;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtDevolucao;
	private Double vrTotal;
    @ManyToOne
	private Carro carro;
    
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="codApoliceSeguro")
    private ApoliceSeguro seguro;
    
    public Aluguel() {
		
	}

	public Aluguel(Integer codigo, Date dtPedido, Date dtEntrega, Carro carro, ApoliceSeguro seguro) {
		this.codigo = codigo;
		this.dtPedido = dtPedido;
		this.dtEntrega = dtEntrega;
		this.carro = carro;
		this.seguro = seguro;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Date getDtPedido() {
		return dtPedido;
	}

	public void setDtPedido(Date dtPedido) {
		this.dtPedido = dtPedido;
	}

	public Date getDtEntrega() {
		return dtEntrega;
	}

	public void setDtEntrega(Date dtEntrega) {
		this.dtEntrega = dtEntrega;
	}

	public Date getDtDevolucao() {
		return dtDevolucao;
	}

	public void setDtDevolucao(Date dtDevolucao) {
		this.dtDevolucao = dtDevolucao;
	}

	public Double getVrTotal() {
		return vrTotal;
	}

	public void setVrTotal(Double vrTotal) {
		this.vrTotal = vrTotal;
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public ApoliceSeguro getSeguro() {
		return seguro;
	}

	public void setSeguro(ApoliceSeguro seguro) {
		this.seguro = seguro;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Aluguel)) {
			return false;
		}
		Aluguel other = (Aluguel) obj;
		if (codigo == null) {
			if (other.codigo != null) {
				return false;
			}
		} else if (!codigo.equals(other.codigo)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Aluguel [codigo=" + codigo + ", dtPedido=" + dtPedido + ", dtEntrega=" + dtEntrega + ", dtDevolucao="
				+ dtDevolucao + ", vrTotal=" + vrTotal + ", carro=" + carro + ", seguro=" + seguro + "]";
	}
    
    
    
    
    
}
