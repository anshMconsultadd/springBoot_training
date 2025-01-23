package com.ansh.restSpring.repositories;

import com.ansh.restSpring.entities.TableEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TableRepository extends JpaRepository<TableEntity, Integer> {

      List<TableEntity> findByBookedBy(String bookedBy);

}
