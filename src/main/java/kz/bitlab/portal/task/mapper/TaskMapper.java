package kz.bitlab.portal.task.mapper;

import kz.bitlab.portal.task.dto.TaskDto;
import kz.bitlab.portal.task.model.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    @Mapping(source = "deadlineDateTime", target = "dueDate")
    @Mapping(source = "userId", target = "authorId")
    TaskDto toDto(Task task);

    @Mapping(source = "dueDate", target = "deadlineDateTime")
    @Mapping(source = "authorId", target = "userId")
    Task toEntity(TaskDto taskDto);

    @Mapping(source = "deadlineDateTime", target = "dueDate")
    @Mapping(source = "userId", target = "authorId")
    List<TaskDto> toDtoList(List<Task> tasks);
}
