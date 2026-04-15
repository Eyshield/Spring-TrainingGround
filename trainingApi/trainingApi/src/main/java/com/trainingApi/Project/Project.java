package com.trainingApi.Project;

import com.trainingApi.Column.Column;
import com.trainingApi.Task.Task;
import com.trainingApi.User.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String description;
    private LocalDate created_At;
    private LocalDate updated_At;
    @ManyToMany
    private Collection<User>users=new ArrayList<>();
    @OneToMany(mappedBy = "project")
    private Collection<Column>columns=new ArrayList<>();
    @OneToMany(mappedBy = "project")
    private Collection<Task>tasks=new ArrayList<>();

}
