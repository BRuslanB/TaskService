package kz.bitlab.portal.task.feign;

import kz.bitlab.portal.task.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "user-feign-client", url = "${feign.user.url}")
public interface UserFeignClient {

    @GetMapping
    List<UserDto> getUsers();

    @GetMapping(value = "{id}")
    UserDto getUser(@PathVariable(name = "id") Long id);
}
