package com.trainingApi.Column;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/column")
@AllArgsConstructor
public class ColumnController {
    private final ColumnService columnService;
    @PostMapping("/add")
    public ResponseEntity<ColumnResponse> addColumn(@RequestBody @Valid ColumnRequest columnRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(columnService.addColumn(columnRequest));
    }
    @GetMapping("/{id}")
    public ResponseEntity<List<ColumnResponse>>getColumnsByProjectId(@PathVariable UUID id){
        return ResponseEntity.status(HttpStatus.OK).body(columnService.getColumnsByProject(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity <ColumnResponse>updateColumn(@PathVariable UUID id, @RequestBody @Valid ColumnRequest columnRequest){
        return ResponseEntity.status(HttpStatus.OK).body(columnService.updateColumn(id,columnRequest));
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Void> deleteColumn(@PathVariable UUID id){
        columnService.deleteColumn(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
