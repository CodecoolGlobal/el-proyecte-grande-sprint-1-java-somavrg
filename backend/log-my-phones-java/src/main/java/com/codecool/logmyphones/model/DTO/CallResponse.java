package com.codecool.logmyphones.model.DTO;

import lombok.Data;

import java.util.List;

@Data
public class CallResponse {
    private List<CallDTO> content;
    private int pageNo;
    private int pageSize;
    private long totalElements;
    private int totalPages;
    private boolean last;
}
