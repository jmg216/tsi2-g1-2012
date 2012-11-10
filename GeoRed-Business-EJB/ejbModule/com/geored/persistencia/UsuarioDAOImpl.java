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
	public Usuario toEntity(UsuarioDTO source)
	{
		Usuario target = new Usuario();
		
		target.setEmail(source.getEmail());
		target.setPass(source.getPass());
		target.setNombre(source.getNombre());
		target.setUrlImagen(source.getUrlImagen());
		
		return target;
	}

	@Override
	public UsuarioDTO toDto(Usuario source)
	{
		UsuarioDTO target = new UsuarioDTO();
		
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
			
		return target;
	}
	
	public Object obtenerUsuarioPorEmailYPass(String email, String pass, boolean toDTO)
	{
		Query query = em.createQuery("select u from Usuario u where u.email = ?1 and u.pass = ?2");        
        query.setParameter(1, email);        
        query.setParameter(2, pass);
        
        Usuario usuarioEntity = ((Usuario) query.getSingleResult());
        
        if(toDTO)
        {
             return toDto(usuarioEntity);
        }
       
        return usuarioEntity;
    }
}