package com.ansh.restSpring.repositories;

import com.ansh.restSpring.entities.TableEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableRepository extends JpaRepository<TableEntity, Integer> {

}
