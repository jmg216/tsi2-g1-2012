package com.geored.dto;

import java.util.ArrayList;
import java.util.List;

public class AmistadDTO
{
	private Long id;
	
	private Long idUsuarioA;
	
	private String nombreUsuarioA;
	
	private Long idUsuarioB;
	
	private String nombreUsuarioB;
	
	private List<MensajeAmistadDTO> listaMensajesDTO = new ArrayList<MensajeAmistadDTO>();

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public Long getIdUsuarioA()
	{
		return idUsuarioA;
	}

	public void setIdUsuarioA(Long idUsuarioA)
	{
		this.idUsuarioA = idUsuarioA;
	}

	public String getNombreUsuarioA()
	{
		return nombreUsuarioA;
	}

	public void setNombreUsuarioA(String nombreUsuarioA)
	{
		this.nombreUsuarioA = nombreUsuarioA;
	}

	public Long getIdUsuarioB()
	{
		return idUsuarioB;
	}

	public void setIdUsuarioB(Long idUsuarioB)
	{
		this.idUsuarioB = idUsuarioB;
	}

	public String getNombreUsuarioB()
	{
		return nombreUsuarioB;
	}

	public void setNombreUsuarioB(String nombreUsuarioB)
	{
		this.nombreUsuarioB = nombreUsuarioB;
	}

	public List<MensajeAmistadDTO> getListaMensajesDTO()
	{
		return listaMensajesDTO;
	}

	public void setListaMensajesDTO(List<MensajeAmistadDTO> listaMensajesDTO)
	{
		this.listaMensajesDTO = listaMensajesDTO;
	}
}