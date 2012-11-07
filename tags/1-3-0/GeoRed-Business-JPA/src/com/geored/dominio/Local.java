package com.geored.dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="local")
public class Local implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3213036910497098601L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID", nullable=false)
	private Long id;
	
	@Column(name="NOMBRE", nullable=false)
	private String nombre;
	
	@Column(name="UBICACION_GEOGRAFICA", nullable=false)
	private String ubicacionGeografica; 
	
	@JoinColumn(name="EMPRESA_FK", nullable=false)
	@ManyToOne(fetch=FetchType.LAZY)
	private Empresa empresa;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getNombre()
	{
		return nombre;
	}

	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}

	public Empresa getEmpresa()
	{
		return empresa;
	}

	public void setEmpresa(Empresa empresa)
	{
		this.empresa = empresa;
	}

	public String getUbicacionGeografica()
	{
		return ubicacionGeografica;
	}

	public void setUbicacionGeografica(String ubicacionGeografica)
	{
		this.ubicacionGeografica = ubicacionGeografica;
	}
    
	public String getLatitud()
    {
        String cleanCoord = ubicacionGeografica.replace("(", "").replace(")", "");

		String[] array = cleanCoord.split(",");
  
        return array[0];
    }

    public String getLongitud()
    {
        String cleanCoord = ubicacionGeografica.replace("(", "").replace(")", "");
    	
		String[] array = cleanCoord.split(",");
  
        return array[1];
    }
    
    
}