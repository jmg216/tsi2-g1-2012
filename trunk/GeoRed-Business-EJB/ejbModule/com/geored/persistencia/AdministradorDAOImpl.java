package com.geored.persistencia;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.Query;

import com.geored.dominio.Administrador;
import com.geored.dto.AdministradorDTO;
import com.geored.persistencia.core.GenericDAOBase;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class AdministradorDAOImpl extends GenericDAOBase<Administrador, AdministradorDTO> implements AdministradorDAO
{	
	@Override
	public Administrador toEntity(AdministradorDTO source)
	{
		Administrador target = new Administrador();
		
		target.setEmail(source.getEmail());
		target.setPass(source.getPass());
		target.setNombre(source.getNombre());
		
		return target;
	}

	@Override
	public AdministradorDTO toDto(Administrador source)
	{
		AdministradorDTO target = new AdministradorDTO();
		
		target.setId(source.getId());		
		target.setEmail(source.getEmail());
		target.setPass(source.getPass());
		target.setNombre(source.getNombre());
		
		if(source.getTipoAdministrador() != null)
		{
			target.setIdTipoAdministrador(source.getTipoAdministrador().getId());
			target.setNombreTipoAdministrador(source.getTipoAdministrador().getNombre());
		}
		
		return target;
	}

	@Override
	public Object obtenerAdminPorEmailYPass(String email, String pass, boolean toDTO)
	{
		Query query = em.createQuery("select a from Administrador a where a.email = ?1 and a.pass = ?2");        
        query.setParameter(1, email);        
        query.setParameter(2, pass);
        
        Administrador adminEntity = (Administrador) query.getSingleResult();
        
        if(toDTO)
        {        	
        	return toDto(adminEntity);
        }
        
        return adminEntity;
	}
}