package com.github.gustavoaos.logviewer.service;

import com.github.gustavoaos.logviewer.model.Level;
import com.github.gustavoaos.logviewer.model.LogViewer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.Optional;

public interface LogViewerServiceInterface {

    LogViewer save(LogViewer logViewer);

    Optional<LogViewer> findById(Long id);

    Page<LogViewer> findAll(Pageable pageable);

    Page<LogViewer> findByLevel(Level level, Pageable pageable);

    Page<LogViewer> findByDescription(String description, Pageable pageable);

    Page<LogViewer> findByUserName(String userName, Pageable pageable);

    Page<LogViewer> findByDate(LocalDateTime date, Pageable pageable);

    Page<LogViewer> findByQuantity(Integer quantity, Pageable pageable);
    
}