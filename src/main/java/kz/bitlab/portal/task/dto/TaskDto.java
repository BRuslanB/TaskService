package kz.bitlab.portal.task.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto {

    private Long id;

    private String title;

    private String description;

    private LocalDateTime dueDate;

    private int status;

    private Long authorId;
}