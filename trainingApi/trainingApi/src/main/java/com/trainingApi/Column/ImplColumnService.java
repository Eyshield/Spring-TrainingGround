package com.trainingApi.Column;

import com.trainingApi.Project.Project;
import com.trainingApi.Project.ProjectRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Service
@AllArgsConstructor
public class ImplColumnService implements ColumnService{
    private final ProjectRepo projectRepo;
    private final ColumnRepo columnRepo;
    private final ColumnMapper columnMapper;

    @Override
    public ColumnResponse addColumn(ColumnRequest columnRequest) {
        Column column = columnMapper.toColumn(columnRequest);
        Project project= projectRepo.findById(columnRequest.getProjectId()).orElseThrow();
        column.setProject(project);
        return columnMapper.toColumnResponse(columnRepo.save(column));
    }

    @Override
    public ColumnResponse updateColumn(UUID id, ColumnRequest columnRequest) {
        Column column= columnRepo.findById(id).orElseThrow();
        Project project= projectRepo.findById(columnRequest.getProjectId()).orElseThrow();
        column.setProject(project);
        column.setPosition(columnRequest.getPosition());
        column.setTitle(columnRequest.getTitle());
        return columnMapper.toColumnResponse( columnRepo.save(column));
    }

    @Override
    public List<ColumnResponse> getColumnsByProject(UUID projectId) {
        List<ColumnResponse> columnResponses =new ArrayList<>();
        List<Column> columns= columnRepo.findByProjectId(projectId);
        for (Column column: columns){
            columnResponses.add(columnMapper.toColumnResponse(column));
        }
        return columnResponses ;
    }

    @Override
    public void deleteColumn(UUID id) {
      columnRepo.deleteById(id);
    }
}
