package com.schedule.barbershop.security;

import com.schedule.barbershop.model.Employee;
import com.schedule.barbershop.model.Role;
import com.schedule.barbershop.model.User;
import com.schedule.barbershop.repository.EmployeeRepository;
import com.schedule.barbershop.repository.RoleRepository;
import com.schedule.barbershop.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInit implements CommandLineRunner {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final EmployeeRepository employeeRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInit(UserRepository userRepository, RoleRepository roleRepository, EmployeeRepository employeeRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.employeeRepository = employeeRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public void run(String... args) throws Exception {
        User adminUser = userRepository.findByEmail("admin@example.com");
        if (adminUser == null) {
            Role adminRole = roleRepository.findByName("Admin");
            if (adminRole == null) {
                adminRole = new Role();
                adminRole.setName("Admin");
                roleRepository.save(adminRole);
            }

            // Create new Employee first
            Employee newAdminEmployee = new Employee();
            newAdminEmployee.setName("Admin");

            // Create new User
            adminUser = new User();
            adminUser.setEmail("admin@example.com");
            adminUser.setPassword(passwordEncoder.encode("123"));
            adminUser.setRole(adminRole);

            // Set the relationship on both sides
            newAdminEmployee.setUser(adminUser);
            adminUser.setEmployee(newAdminEmployee);

            // Now you can save the User entity, and Hibernate should take care of the rest
            userRepository.save(adminUser);
        }
    }





}


