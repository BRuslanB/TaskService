package kz.bitlab.portal.task.service;

import kz.bitlab.portal.task.dto.TaskDto;
import kz.bitlab.portal.task.model.Task;

import java.util.List;

public interface TaskService {

    List<TaskDto> getAllTasks();
    TaskDto getTask(Long id);
    TaskDto addTask(TaskDto task);
    TaskDto updateTask(TaskDto task);
    void deleteTask(Long id);
}
