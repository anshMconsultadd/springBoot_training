package com.ansh.restSpring.controllers;

import com.ansh.restSpring.dto.AuthRequestDTO;
import com.ansh.restSpring.dto.JwtResponseDTO;
import com.ansh.restSpring.dto.TableDTO;
import com.ansh.restSpring.entities.UserInfo;
import com.ansh.restSpring.repositories.UserRoleRepository;
import com.ansh.restSpring.services.JwtService;
import com.ansh.restSpring.services.TableService;
import com.ansh.restSpring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
    private final UserService userService;  // New UserService injected

    @Autowired
    public UserController(AuthenticationManager authenticationManager, JwtService jwtService, TableService tableService, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.tableService = tableService;
        this.userService = userService;
    }

    @Autowired
    private UserRoleRepository userRoleRepository; // Inject the UserRoleRepository

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(path = "/tables")
    public List<TableDTO> getAllTableBookings() {
        return tableService.getAllTableBookings();
    }

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @PostMapping(path = "/book/tables")
    public TableDTO createTableBooking(@RequestBody TableDTO tableDTO) {
        return tableService.createTableBooking(tableDTO);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PatchMapping(path = "/modify/tables/{id}")
    public TableDTO updateTableBooking(@PathVariable("id") int id, @RequestBody TableDTO tableDTO) {
        return tableService.updateTableBooking(tableDTO);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/remove/tables/{id}")
    public Boolean deleteTableBooking(@PathVariable("id") int id) {
        return tableService.deleteTableBooking(id);
    }

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @GetMapping("/searchByName/tables")
    public List<TableDTO> searchTableBookingByName(@RequestParam("name") String name) {
        return tableService.searchTableBookingByName(name);
    }


//    // Signup API to register a new user with role assignment
//    @PostMapping("/api/v1/signup")
//    public void signup(@RequestBody UserInfo userInfo) {
//        // Assign default role USER, you can change this as needed
//        Set<UserRole> roles = new HashSet<>();
//        UserRole userRole = userRoleRepository.findByName("USER");  // Assuming 'USER' role is always available
//        roles.add(userRole);
//
//        userInfo.setRoles(roles);
//
//        // Encode the password before saving
//        userService.signupUser(userInfo);
//    }
//
//    // Login API to authenticate user and generate token
//    @PostMapping("/api/v1/login")
//    public JwtResponseDTO authenticateAndGetToken(@RequestBody AuthRequestDTO authRequestDTO) {
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(authRequestDTO.getUsername(), authRequestDTO.getPassword())
//        );
//        if (authentication.isAuthenticated()) {
//            return new JwtResponseDTO(jwtService.generateToken(authRequestDTO.getUsername()));
//        } else {
//            throw new UsernameNotFoundException("Invalid user request..!!");
//        }
//    }

    // Other existing routes (like table-related routes) ...

    // Updated Signup API
    @PostMapping("/api/v1/signup")
    public void signup(@RequestBody UserInfo userInfo, @RequestParam("role") String role) {
        userService.signupUser(userInfo, role);
    }

    // Login route for authentication
    @PostMapping("/api/v1/login")
    public JwtResponseDTO authenticateAndGetToken(@RequestBody AuthRequestDTO authRequestDTO) {
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
