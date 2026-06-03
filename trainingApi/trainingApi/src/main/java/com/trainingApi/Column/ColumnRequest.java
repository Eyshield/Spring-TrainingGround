package com.trainingApi.Column;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.UUID;
@AllArgsConstructor
@Data
@NoArgsConstructor
@SuperBuilder
public class ColumnRequest {
    private UUID id;
    private String title;
    private String position;
    private UUID projectId;
}
