package com.example.prueba.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.prueba.models.Usuario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
@Transactional
public class UsuarioDaoImp implements UsuarioDao{

	@PersistenceContext
	EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Usuario> getUsuarios() {
		String query = "FROM Usuario";
		return entityManager.createQuery(query).getResultList();
	}

	@Override
	public void eliminarUsuario(Long id) {
		Usuario usuario = entityManager.find(Usuario.class, id);
		entityManager.remove(usuario);
		
	}

	@Override
	public Usuario getUsuario(Long id) {
		return entityManager.find(Usuario.class, id);
	}

	@Override
	public void registrarUsuario(Usuario usario) {
		entityManager.merge(usario);
		
	}

}
