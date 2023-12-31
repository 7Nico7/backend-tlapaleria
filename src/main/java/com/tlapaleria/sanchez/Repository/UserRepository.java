package com.tlapaleria.sanchez.Repository;

import com.tlapaleria.sanchez.Models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
}
