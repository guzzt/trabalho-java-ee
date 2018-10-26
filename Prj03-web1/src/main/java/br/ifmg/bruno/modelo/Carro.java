package br.ifmg.bruno.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Carro implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codigo;
	private String placa;
	private String chassi;
	private String cor;
    @ManyToOne
    @JoinColumn(name="codModelo")
	private Modelo modelo;
    private Double vrDiaria;
	@ManyToMany
	@JoinTable(
			name="CarroAcessorio",
			joinColumns=@JoinColumn(name="codCarro"),
			inverseJoinColumns=@JoinColumn(name="codAcessorio")
			)	
    private List<Acessorio> acessorios = 
                      new ArrayList<Acessorio>();
    
	@OneToMany(mappedBy="carro")
	private List<Aluguel> alugueis = 
                      new ArrayList<Aluguel>();
	
	@Lob
	private byte[] foto;
	
    
    public Carro() {
		
	}

	public Carro(Integer codigo, String placa, String chassi, String cor, Modelo modelo) {
		this.codigo = codigo;
		this.placa = placa;
		this.chassi = chassi;
		this.cor = cor;
		this.modelo = modelo;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public Double getVrDiaria() {
		return vrDiaria;
	}

	public void setVrDiaria(Double vrDiaria) {
		this.vrDiaria = vrDiaria;
	}

	public List<Acessorio> getAcessorios() {
		return acessorios;
	}

	public void setAcessorios(List<Acessorio> acessorios) {
		this.acessorios = acessorios;
	}

	public List<Aluguel> getAlugueis() {
		return alugueis;
	}

	public void setAlugueis(List<Aluguel> alugueis) {
		this.alugueis = alugueis;
	}


	
	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
	
	public boolean hasFoto(){
		return this.foto != null && foto.length > 0;
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
		if (!(obj instanceof Carro)) {
			return false;
		}
		Carro other = (Carro) obj;
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
		
		String aux="\n\n";
		for (Acessorio a : acessorios) {
			aux += a.getDescricao()+"\n";
		}
		
		return "Placa: " + placa + ", Modelo: " + modelo+
				aux;
	}	
	
    
    
}
