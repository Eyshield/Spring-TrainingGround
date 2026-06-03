package com.trainingApi.Column;

import com.trainingApi.Task.TaskMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ColumnMapper {
    private final TaskMapper taskMapper;
    public ColumnResponse toColumnResponse(Column column){
        return ColumnResponse.builder()
                .id(column.getId())
                .title(column.getTitle())
                .position(column.getPosition())
                .taskResponses(column.getTasks()
                        .stream()
                        .map(taskMapper::toTaskResponse)
                        .toList())
                .build();
    }

    public Column toColumn(ColumnRequest columnRequest){
        return Column.builder()
                .title(columnRequest.getTitle())
                .position(columnRequest.getPosition())
                .build();
    }
}
