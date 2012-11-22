package com.geored.persistencia;

import java.util.ArrayList;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.Query;

import com.geored.dominio.Usuario;
import com.geored.dto.TematicaDTO;
import com.geored.dto.UsuarioDTO;
import com.geored.exceptions.DaoException;
import com.geored.persistencia.core.GenericDAOBase;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class UsuarioDAOImpl extends GenericDAOBase<Usuario, UsuarioDTO> implements UsuarioDAO
{
	@EJB
	private TematicaDAO tematicaDAO;
	
	@EJB
	private OfertaDAO ofertaDAO;
	
	@Override
	public void toEntity(UsuarioDTO source, Usuario target)
	{
		target.setEmail(source.getEmail());
		target.setPass(source.getPass());
		target.setNombre(source.getNombre());
		target.setUrlImagen(source.getUrlImagen());
	}

	@Override
	public void toDto(Usuario source, UsuarioDTO target)
	{
		target.setId(source.getId());
		target.setEmail(source.getEmail());
		target.setPass(source.getPass());
		target.setNombre(source.getNombre());
		target.setUrlImagen(source.getUrlImagen());
		
		target.setListaTematicasDTO(new ArrayList<TematicaDTO>());
		if(source.getListaTematicas() != null)
		{
			target.setListaTematicasDTO(tematicaDAO.toDtoList(source.getListaTematicas()));
		}
	}
	
	public Object obtenerUsuarioPorEmailYPass(String email, String pass, boolean toDTO) throws DaoException
	{
		try
		{
			Query query = em.createQuery("select u from com.geored.dominio.Usuario u where u.email = ?1 and u.pass = ?2");        
	        query.setParameter(1, email);        
	        query.setParameter(2, pass);
	        
	        Usuario usuarioEntity = ((Usuario) query.getSingleResult());
	        
	        if(toDTO)
	        {
	             return toDto(usuarioEntity);
	        }
	       
	        return usuarioEntity;
		}
		catch(Throwable e)
		{
			throw new DaoException(e.getMessage());
		
		}		
    }
}