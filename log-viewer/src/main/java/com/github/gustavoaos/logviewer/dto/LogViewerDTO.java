package com.github.gustavoaos.logviewer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LogViewerDTO {

    private Long id;
    private String level;
    private String description;
    private String origin;
    private LocalDateTime date;
    private Integer quantity;
    private LocalDateTime createdAt;
    
}