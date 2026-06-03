package com.trainingApi.Column;

import java.util.List;
import java.util.UUID;

public interface ColumnService {
    ColumnResponse addColumn(ColumnRequest columnRequest);
    ColumnResponse updateColumn(UUID id,ColumnRequest columnRequest);
    List<ColumnResponse> getColumnsByProject(UUID projectId);
    void  deleteColumn(UUID id);
}
