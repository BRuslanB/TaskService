package kz.bitlab.portal.task.service;

import kz.bitlab.portal.task.dto.UserDto;
import kz.bitlab.portal.task.feign.UserFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserFeignClient userFeignClient;

    public List<UserDto> getAllUsers() {
        return userFeignClient.getUsers();
    }

    public UserDto getUser(Long id) {
        return userFeignClient.getUser(id);
    }
}
