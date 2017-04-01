package com.cooper.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooper.entities.Usuario;
import com.cooper.repository.UsuarioRepository;
import com.cooper.vo.CredentialsVO;

@Service
public class UsuarioService {
  
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<Usuario> findAll(){
		return usuarioRepository.findAll();
	}

	public Usuario findUsuario(CredentialsVO credentials){
		Usuario found = new Usuario();
		
		List<Usuario> query = usuarioRepository.findByNickAndPassword(credentials.getNick(), credentials.getPassword());
		
		if(query!=null && !query.isEmpty()){
			found=query.get(0);
			found.setIsValid(Boolean.TRUE);
		}else{
			found.setIsValid(Boolean.FALSE);
		}
		
		return found;
	}
	
	public Usuario save(Usuario u){
		return usuarioRepository.save(u);
	}

}
