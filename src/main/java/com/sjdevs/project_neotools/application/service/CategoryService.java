package com.sjdevs.project_neotools.application.service;

import com.sjdevs.project_neotools.domain.model.Category;
import com.sjdevs.project_neotools.domain.exceptions.ResourceNotFoundException;
import com.sjdevs.project_neotools.application.dto.CategoryDTO;
import com.sjdevs.project_neotools.application.mapper.CategoryMapper;
import com.sjdevs.project_neotools.infrastructure.persistence.repository.JpaCategoryRepository;
import com.sjdevs.project_neotools.infrastructure.persistence.entity.CategoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private JpaCategoryRepository jpaCategoryRepository;

    public List<CategoryDTO> getAllCategories() {
        return jpaCategoryRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public CategoryDTO getCategoryById(Long id) {
        CategoryEntity categoryEntity = jpaCategoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Categoría no encontrada con ID: " + id));
        return toDTO(categoryEntity);
    }

    public CategoryDTO getCategoryByNombre(String nombre) {
        CategoryEntity categoryEntity = jpaCategoryRepository.findByNombre(nombre)
                .orElseThrow(() -> new ResourceNotFoundException("Categoría no encontrada con nombre: " + nombre));
        return toDTO(categoryEntity);
    }

    public CategoryDTO saveOrUpdateCategory(CategoryDTO categoryDTO) {
        Category category = CategoryMapper.toDomainFromDTO(categoryDTO);
        CategoryEntity categoryEntity = CategoryMapper.toEntity(category);
        CategoryEntity savedEntity = jpaCategoryRepository.save(categoryEntity);
        return toDTO(savedEntity);
    }

    public void deleteCategory(Long id) {
        jpaCategoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Categoría no encontrada con ID: " + id));
        jpaCategoryRepository.deleteById(id);
    }

    private CategoryDTO toDTO(CategoryEntity categoryEntity) {
        Category category = CategoryMapper.toDomain(categoryEntity);
        return CategoryMapper.toDTO(category);
    }
}
