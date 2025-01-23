package com.ansh.restSpring.controllers;

import com.ansh.restSpring.dto.TableDTO;
import com.ansh.restSpring.services.TableService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class UserController {

    private final TableService tableService;

    public UserController(TableService tableService) {
        this.tableService = tableService;
    }

    @GetMapping(path="/tables")
    public List<TableDTO> getAllTableBookings() {
       return tableService.getAllTableBookings();
    }

    @PostMapping(path="/book/tables")
    public TableDTO createTableBooking(@RequestBody TableDTO tableDTO) {
        return tableService.createTableBooking(tableDTO);
    }

    @PatchMapping(path = "/modify/tables/{id}")
    public TableDTO updateTableBooking(@PathVariable("id") int id, @RequestBody TableDTO tableDTO) {
        return tableService.updateTableBooking(tableDTO);
    }

    @DeleteMapping("/remove/tables/{id}")
    public Boolean deleteTableBooking(@PathVariable("id") int id) {
        return tableService.deleteTableBooking(id);
    }

    @GetMapping("/searchByName/tables")
    public List<TableDTO> searchTableBookingByName(@RequestParam("name") String name) {
        return tableService.searchTableBookingByName(name);
    }

}
