package pl.jakubtomczyk.fixture;


import org.springframework.stereotype.Service;
import pl.jakubtomczyk.entity.Role;
import pl.jakubtomczyk.entity.User;
import pl.jakubtomczyk.service.RoleService;
import pl.jakubtomczyk.service.UserService;

import java.util.HashSet;
import java.util.Set;

@Service
public class InitDataFixture {

    private final UserService userService;
    private final RoleService roleService;

    public InitDataFixture(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    public void initRoles() {
        Role roleAdmin = new Role();
        roleAdmin.setName("ROLE_ADMIN");
        roleService.save(roleAdmin);

        Role roleUser = new Role();
        roleUser.setName("ROLE_USER");
        roleService.save(roleUser);
    }

    public void initUsers() {

        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(roleService.findOneByName("ROLE_ADMIN"));

        User admin = new User();
        admin.setFirstName("admin");
        admin.setPassword("admin");
        admin.setRoles(adminRoles);
        userService.save(admin);

        Set<Role> userRoles = new HashSet<>();
        userRoles.add(roleService.findOneByName("ROLE_USER"));

        User user = new User();
        user.setFirstName("user");
        user.setPassword("user");
        user.setRoles(userRoles);

        userService.save(user);

        user.getRoles().forEach(e -> System.out.println(e.getName()));
    }
}
