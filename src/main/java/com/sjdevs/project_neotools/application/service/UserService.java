package com.sjdevs.project_neotools.application.service;

import com.sjdevs.project_neotools.application.mapper.UserMapper;
import com.sjdevs.project_neotools.application.dto.UserDTO;
import com.sjdevs.project_neotools.domain.model.User;
import com.sjdevs.project_neotools.infrastructure.persistence.repository.JpaUserRepository;
import com.sjdevs.project_neotools.domain.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private JpaUserRepository userRepository;

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(UserMapper::toDomain)
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public UserDTO getUserById(Long id) {
        return userRepository.findById(id)
                .map(UserMapper::toDomain)
                .map(this::toDTO)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
    }

    public UserDTO getUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .map(UserMapper::toDomain)
                .map(this::toDTO)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with username: " + username));
    }

    public UserDTO saveOrUpdateUser(UserDTO userDTO) {
        User user = fromDTO(userDTO);
        return toDTO(UserMapper.toDomain(userRepository.save(UserMapper.toEntity(user))));
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    private UserDTO toDTO(User user) {
        if (user == null) return null;
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        dto.setPassword(user.getPassword());
        dto.setEstado(user.getEstado());
        dto.setCreatedAt(user.getCreatedAt());
        dto.setLastLogin(user.getLastLogin());
        return dto;
    }

    private User fromDTO(UserDTO dto) {
        if (dto == null) return null;
        return new User(dto.getId(), dto.getUsername(), dto.getEmail(), dto.getPassword(), 
                dto.getEstado(), dto.getCreatedAt(), dto.getLastLogin());
    }
}
