package com.todoapp.entities;

import com.todoapp.enums.Priority;
import com.todoapp.enums.TaskStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name = "tasks")
@Table(name = "tb_tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private LocalDate dueDate;
    @Enumerated
    private TaskStatus taskStatus;
    @Enumerated
    private Priority priority;
}
