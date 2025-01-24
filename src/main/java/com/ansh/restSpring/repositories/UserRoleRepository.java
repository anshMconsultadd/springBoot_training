package com.ansh.restSpring.repositories;

import com.ansh.restSpring.entities.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

    UserRole findByName(String name);  // Method to find a role by name (e.g., "USER", "ADMIN")

}
