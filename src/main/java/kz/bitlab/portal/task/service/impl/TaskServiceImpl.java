package kz.bitlab.portal.task.service.impl;

import kz.bitlab.portal.task.dto.TaskDto;
import kz.bitlab.portal.task.dto.UserDto;
import kz.bitlab.portal.task.exeption.TaskNotFoundException;
import kz.bitlab.portal.task.exeption.UserNotFoundException;
import kz.bitlab.portal.task.feign.UserFeignClient;
import kz.bitlab.portal.task.mapper.TaskMapper;
import kz.bitlab.portal.task.repository.TaskRepository;
import kz.bitlab.portal.task.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;
    private final UserFeignClient userFeignClient;

    public List<TaskDto> getAllTasks() {
        return taskMapper.toDtoList(taskRepository.findAll());
    }

    public TaskDto getTask(Long id) {
        return taskMapper.toDto(taskRepository.findById(id).orElse(null));
    }

    public TaskDto addTask(TaskDto taskDto) {

        UserDto userDto = userFeignClient.getUser(taskDto.getAuthorId());

        if (userDto != null) {
            if (getTask(taskDto.getId()) != null) {
                taskDto.setStatus(0);
                return taskMapper.toDto(taskRepository.save(taskMapper.toEntity(taskDto)));
            } else {
                throw new TaskNotFoundException(taskDto.getId());
            }
        } else {
            throw new UserNotFoundException(taskDto.getAuthorId());
        }
    }

    public TaskDto updateTask(TaskDto taskDto) {

        UserDto userDto = userFeignClient.getUser(taskDto.getAuthorId());

        if (userDto != null) {
            if (getTask(taskDto.getId()) != null) {
                return taskMapper.toDto(taskRepository.save(taskMapper.toEntity(taskDto)));
            } else {
                throw new TaskNotFoundException(taskDto.getId());
            }
        } else {
            throw new UserNotFoundException(taskDto.getAuthorId());
        }
    }

    public void deleteTask(Long id) {
        taskRepository.findById(id).ifPresent(taskRepository::delete);
    }
}
