package br.ifmg.rad.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ApoliceSeguro implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codigo;
	private Double vrFranquia;
	private Boolean terceiro;
	private Boolean causasNaturais;
	private Boolean roubo;
	
	public ApoliceSeguro() {
	
	}

	public ApoliceSeguro(Integer codigo, Double vrFranquia, Boolean terceiro, Boolean causasNaturais, Boolean roubo) {
		this.codigo = codigo;
		this.vrFranquia = vrFranquia;
		this.terceiro = terceiro;
		this.causasNaturais = causasNaturais;
		this.roubo = roubo;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Double getVrFranquia() {
		return vrFranquia;
	}

	public void setVrFranquia(Double vrFranquia) {
		this.vrFranquia = vrFranquia;
	}

	public Boolean getTerceiro() {
		return terceiro;
	}

	public void setTerceiro(Boolean terceiro) {
		this.terceiro = terceiro;
	}

	public Boolean getCausasNaturais() {
		return causasNaturais;
	}

	public void setCausasNaturais(Boolean causasNaturais) {
		this.causasNaturais = causasNaturais;
	}

	public Boolean getRoubo() {
		return roubo;
	}

	public void setRoubo(Boolean roubo) {
		this.roubo = roubo;
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
		if (!(obj instanceof ApoliceSeguro)) {
			return false;
		}
		ApoliceSeguro other = (ApoliceSeguro) obj;
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
		return "Seguro [Franquia: " + vrFranquia + ", terceiro: " + terceiro + ", causas naturais:"
				+ causasNaturais + ", roubo: " + roubo + "]";
	}
	
	
	
	
	
	
	
}
