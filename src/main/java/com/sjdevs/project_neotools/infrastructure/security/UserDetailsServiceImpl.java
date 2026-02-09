package com.sjdevs.project_neotools.infrastructure.security;

import com.sjdevs.project_neotools.infrastructure.persistence.entity.UserEntity;
import com.sjdevs.project_neotools.infrastructure.persistence.repository.JpaUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private JpaUserRepository jpaUserRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// 1. Buscar el usuario en la BD por username
		UserEntity user = jpaUserRepository.findByUsername(username)
			.orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + username));

		// 2. Crear una lista de roles/permisos (autoridades)
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

		// 3. Construir y devolver un UserDetails de Spring Security
		return User.builder()
			.username(user.getUsername())
			.password(user.getPassword())
			.authorities(authorities)
			.accountExpired(false)
			.accountLocked(false)
			.credentialsExpired(false)
			.disabled(false)
			.build();
	}
}
