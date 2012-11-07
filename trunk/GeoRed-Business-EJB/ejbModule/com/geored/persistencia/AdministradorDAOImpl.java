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
	public void dtoToEntity(AdministradorDTO source, Administrador target)
	{
		target.setEmail(source.getEmail());
		target.setPass(source.getPass());
		target.setNombre(source.getNombre());		
	}

	@Override
	public void entityToDto(Administrador source, AdministradorDTO target)
	{
		target.setId(source.getId());		
		target.setEmail(source.getEmail());
		target.setPass(source.getPass());
		target.setNombre(source.getNombre());
		
		if(source.getTipoAdministrador() != null)
		{
			target.setIdTipoAdministrador(source.getTipoAdministrador().getId());
			target.setNombreTipoAdministrador(source.getTipoAdministrador().getNombre());
		}
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
        	AdministradorDTO adminDTO = new AdministradorDTO();
        	
        	entityToDto(adminEntity, adminDTO);
        	
        	return adminDTO;
        }
        
        return adminEntity;
	}
}