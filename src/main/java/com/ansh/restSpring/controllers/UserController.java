package com.ansh.restSpring.controllers;

import com.ansh.restSpring.dto.AuthRequestDTO;
import com.ansh.restSpring.dto.JwtResponseDTO;
import com.ansh.restSpring.dto.TableDTO;
import com.ansh.restSpring.dto.UserSignupDTO;
import com.ansh.restSpring.entities.UserInfo;
import com.ansh.restSpring.services.JwtService;
import com.ansh.restSpring.services.TableService;
import com.ansh.restSpring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final TableService tableService;
    private final UserService userService;

    @Autowired
    public UserController(AuthenticationManager authenticationManager, JwtService jwtService, TableService tableService, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.tableService = tableService;
        this.userService = userService;
    }

    // Route to get all table bookings (No role-based access required)
    @GetMapping(path = "/tables")
    public List<TableDTO> getAllTableBookings() {
        return tableService.getAllTableBookings();
    }

    // Route to create table booking (No role-based access required)
    @PostMapping(path = "/book/tables")
    public TableDTO createTableBooking(@RequestBody TableDTO tableDTO) {
        return tableService.createTableBooking(tableDTO);
    }

    // Route to update table booking (No role-based access required)
    @PatchMapping(path = "/modify/tables/{id}")
    public TableDTO updateTableBooking(@PathVariable("id") int id, @RequestBody TableDTO tableDTO) {
        return tableService.updateTableBooking(tableDTO);
    }

    // Route to delete table booking (No role-based access required)
    @DeleteMapping("/remove/tables/{id}")
    public Boolean deleteTableBooking(@PathVariable("id") int id) {
        return tableService.deleteTableBooking(id);
    }

    // Route to search for table bookings by name (No role-based access required)
    @GetMapping("/searchByName/tables")
    public List<TableDTO> searchTableBookingByName(@RequestParam("name") String name) {
        return tableService.searchTableBookingByName(name);
    }

    @PostMapping("/api/v1/signup")
    public void signup(@RequestBody  UserSignupDTO userSignupDTO) {
        // Debug log to inspect the received object
        System.out.println("Received signup payload: " + userSignupDTO);
        System.out.println("Password: " + userSignupDTO.getPassword());

        // Convert DTO to Entity
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(userSignupDTO.getUsername());
        userInfo.setPassword(userSignupDTO.getPassword());

        // Call service layer to process the request
        userService.signupUser(userInfo);
    }


    // Login route for authentication
    @PostMapping("/api/v1/login")
    public JwtResponseDTO authenticateAndGetToken(@RequestBody AuthRequestDTO authRequestDTO) {
        System.out.println("login attempts for "+authRequestDTO.getUsername()+"and the password is "+authRequestDTO.getPassword());
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequestDTO.getUsername(), authRequestDTO.getPassword())
        );
        if (authentication.isAuthenticated()) {
            return new JwtResponseDTO(jwtService.generateToken(authRequestDTO.getUsername()));
        } else {
            throw new UsernameNotFoundException("Invalid user request..!!");
        }
    }
}
