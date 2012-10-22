package com.geored.persistencia;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.Query;

import com.geored.dominio.Usuario;
import com.geored.dto.UsuarioDTO;
import com.geored.persistencia.core.GenericDAOBase;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class UsuarioDAOImpl extends GenericDAOBase<Usuario, UsuarioDTO> implements UsuarioDAO
{
	@Override
	public void dtoToEntity(UsuarioDTO source, Usuario target)
	{
		target.setId(source.getId());
		target.setEmail(source.getEmail());
		target.setNombre(source.getNombre());
		target.setPass(source.getPass());
	}

	@Override
	public void entityToDto(Usuario source, UsuarioDTO target)
	{
		target.setEmail(source.getEmail());
		target.setId(source.getId());
		target.setNombre(source.getNombre());
		target.setPass(source.getPass());
	}
	
	public Object obtenerUsuarioPorEmailYPass(String email, String pass, boolean toDTO)
	{
		Query query = em.createQuery("select u from Usuario u where u.email = ?1 and u.pass = ?2");        
        query.setParameter(1, email);        
        query.setParameter(2, pass);
        
        Usuario usuarioEntity = ((Usuario) query.getSingleResult());
        
        if(toDTO)
        {
        	 UsuarioDTO usuarioDTO = new UsuarioDTO();
        	 
             entityToDto(usuarioEntity, usuarioDTO);
             
             return usuarioDTO;
        }
       
        return usuarioEntity;
    }
}