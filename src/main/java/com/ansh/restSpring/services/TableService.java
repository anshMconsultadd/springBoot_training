package com.ansh.restSpring.services;

import com.ansh.restSpring.dto.TableDTO;
import com.ansh.restSpring.entities.TableEntity;
import com.ansh.restSpring.repositories.TableRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TableService {

    final TableRepository tableRepository;

    public TableService(TableRepository tableRepository) {
        this.tableRepository = tableRepository;
    }

    public List<TableDTO> getAllTableBookings() {
        List<TableEntity> entities = tableRepository.findAll();
        return entities.stream()
                .map(entity -> new TableDTO(
                        entity.getTableId(),
                        entity.getCapacity(),
                        entity.getBookedBy(),
                        entity.getTableNumber()
                ))
                .collect(Collectors.toList());
    }

    public TableDTO createTableBooking(TableDTO tableDTO) {
        TableEntity entity = new TableEntity(
                tableDTO.getCapacity(),
                tableDTO.getBookedBy(),
                tableDTO.getTableNumber()
        );
        TableEntity savedEntity = tableRepository.save(entity);
        return new TableDTO(
                savedEntity.getTableId(),
                savedEntity.getCapacity(),
                savedEntity.getBookedBy(),
                savedEntity.getTableNumber()
        );
    }


    public TableDTO updateTableBooking(TableDTO tableDTO) {
     Optional< TableEntity> exisitingEntityOptional = tableRepository.findById(tableDTO.getTableId());
     if(exisitingEntityOptional.isPresent()) {
         TableEntity existingEntity = exisitingEntityOptional.get();
         existingEntity.setCapacity(tableDTO.getCapacity());
         existingEntity.setBookedBy(tableDTO.getBookedBy());
         existingEntity.setTableNumber(tableDTO.getTableNumber());
        TableEntity updatedEntity = tableRepository.save(existingEntity);
        return new TableDTO(
                updatedEntity.getTableId(),
                updatedEntity.getCapacity(),
                updatedEntity.getBookedBy(),
                updatedEntity.getTableNumber()
        );
     }
        return null;
    }

}
