package kz.bitlab.portal.task.controller;

import kz.bitlab.portal.task.dto.UserDto;
import kz.bitlab.portal.task.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserDto> getUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(value = "{id}")
    public UserDto getUser(@PathVariable(name = "id") Long id) {
        return userService.getUser(id);
    }
}
