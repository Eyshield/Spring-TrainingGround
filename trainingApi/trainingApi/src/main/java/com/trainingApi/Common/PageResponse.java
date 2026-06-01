package com.trainingApi.Common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PageResponse <T>{
    List<T> content;
    int page;
    int size;
    long totalElements;
    int totalPages;
    boolean isFirst;
    boolean isLast;
}
