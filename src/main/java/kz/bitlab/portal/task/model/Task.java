package kz.bitlab.portal.task.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "t_task")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title", nullable = false, unique = true)
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "deadline_date_time", nullable = false)
    private LocalDateTime deadlineDateTime;

    @Column(name = "status", nullable = false)
    private int status; // 0-created, 1-in progress, 2-done, 3-failed

    @Column(name = "user_id", nullable = false)
    private Long userId; //ID пользователя на которого назначена эта задача
}
