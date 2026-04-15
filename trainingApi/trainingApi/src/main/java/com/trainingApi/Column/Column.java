package com.trainingApi.Column;

import com.trainingApi.Project.Project;
import com.trainingApi.Task.Task;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@Table(name = "columns_table")
public class Column {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String title;
    private String position;
    @ManyToOne
    private Project project;
    @OneToMany(mappedBy = "column")
    private Collection<Task>tasks=new ArrayList<>();

}

