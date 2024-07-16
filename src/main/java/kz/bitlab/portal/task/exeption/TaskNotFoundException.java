package kz.bitlab.portal.task.exeption;

public class TaskNotFoundException extends RuntimeException {

    private Long id;

    public TaskNotFoundException(Long id){
        this.id = id;
    }

    @Override
    public String getMessage() {
        return "Task with id " + id + " not found";
    }
}
