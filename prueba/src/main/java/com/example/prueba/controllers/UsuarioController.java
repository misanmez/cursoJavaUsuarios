package com.example.prueba.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.prueba.dao.UsuarioDao;
import com.example.prueba.models.Usuario;

@RestController
public class UsuarioController {

	@Autowired
	private UsuarioDao usuarioDao;
	
	@RequestMapping(value = "api/usuarios/{id}")
	public Usuario getUsuario(@PathVariable Long id) {
		return usuarioDao.getUsuario(id);
	}
	
	@RequestMapping(value = "api/usuarios")
	public List<Usuario> getUsuarios() {	
		return usuarioDao.getUsuarios();
	}
	
	@RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.DELETE)
	public void eliminarUsuario(@PathVariable Long id) {
		usuarioDao.eliminarUsuario(id);
	}
	
	@RequestMapping(value = "api/usuarios", method = RequestMethod.POST)
	public void registrarUsuario(@RequestBody Usuario usario) {
		usuarioDao.registrarUsuario(usario);
	}
}
