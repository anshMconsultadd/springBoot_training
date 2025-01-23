package com.ansh.restSpring.services;

import com.ansh.restSpring.dto.TableDTO;
import com.ansh.restSpring.entities.TableEntity;
import com.ansh.restSpring.exception.TableNotFoundException;
import com.ansh.restSpring.repositories.TableRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TableService {

    final TableRepository tableRepository;
    final ModelMapper modelMapper;

    public TableService(TableRepository tableRepository, ModelMapper modelMapper) {
        this.tableRepository = tableRepository;
        this.modelMapper = modelMapper;
    }

    //    public TableService(TableRepository tableRepository) {
//        this.tableRepository = tableRepository;
//    }

    public List<TableDTO> getAllTableBookings() {
        List<TableEntity> entities = tableRepository.findAll();
        if(entities.isEmpty()) {
            throw  new TableNotFoundException("No Table Bookings Found");
        }
        else {
            return entities.stream()
                    .map(entity -> new TableDTO(
                            entity.getTableId(),
                            entity.getCapacity(),
                            entity.getBookedBy(),
                            entity.getTableNumber()
                    ))
                    .collect(Collectors.toList());
        }
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
     else {
         throw new TableNotFoundException("Table Booking Not Found");
     }
    }

    public Boolean deleteTableBooking(int id) {
       Optional <TableEntity> tableEntity = tableRepository.findById(id);
       if(tableEntity.isPresent()) {
           tableRepository.deleteById(id);
           return true;
       }
         else{
                throw new TableNotFoundException("Table Booking Not Found");
       }
    }

    public List<TableDTO> searchTableBookingByName(String name) {
        return tableRepository.findByBookedBy(name)
                .stream()
                .map(entity-> modelMapper.map(entity, TableDTO.class))
                .collect(Collectors.toList());

    }


}
