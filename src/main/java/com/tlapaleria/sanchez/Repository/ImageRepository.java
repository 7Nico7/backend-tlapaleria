package com.tlapaleria.sanchez.Repository;

import com.tlapaleria.sanchez.Models.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
