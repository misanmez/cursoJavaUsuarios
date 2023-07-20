package com.example.prueba.dao;

import java.util.List;

import com.example.prueba.models.Usuario;

public interface UsuarioDao {
	
	List<Usuario> getUsuarios();

	void eliminarUsuario(Long id);

	Usuario getUsuario(Long id);

	void registrarUsuario(Usuario usario);

}
