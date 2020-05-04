package com.github.gustavoaos.logviewer.service;

import com.github.gustavoaos.logviewer.model.LogViewer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface LogViewerServiceInterface {

    LogViewer save(LogViewer logViewer);

    Optional<LogViewer> findById(Long id);

    Page<LogViewer> findAll(Pageable pageable);
    
}