package com.trainingApi.Task;

import com.trainingApi.Column.Column;
import com.trainingApi.Project.Project;
import com.trainingApi.User.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uui;
    private String title;
    private String description;
    private String priority;
    @ManyToOne
    private Project project;
    @ManyToOne
    private Column column;
    @ManyToOne
    private User user;

}
