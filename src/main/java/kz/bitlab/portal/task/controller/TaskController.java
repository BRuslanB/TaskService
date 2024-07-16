package kz.bitlab.portal.task.controller;

import kz.bitlab.portal.task.dto.TaskDto;
import kz.bitlab.portal.task.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/task")
public class TaskController {

    private final TaskService taskService;

    @GetMapping
    public List<TaskDto> getTasks(){
        return taskService.getAllTasks();
    }

    @GetMapping(value = "{id}")
    public TaskDto getTask(@PathVariable(name = "id") Long id){
        return taskService.getTask(id);
    }

    @PostMapping
    public ResponseEntity<Object> addTask(@RequestBody TaskDto taskDto){
        try {
            return new ResponseEntity<>(taskService.addTask(taskDto), HttpStatus.OK);

        } catch(Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping
    public ResponseEntity<Object> updateTask(@RequestBody TaskDto taskDto){
        try {
            return new ResponseEntity<>(taskService.updateTask(taskDto), HttpStatus.OK);

        } catch(Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "{id}")
    public void deleteTask(@PathVariable(name = "id") Long id){
        taskService.deleteTask(id);
    }
}
