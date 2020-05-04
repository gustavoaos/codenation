package com.github.gustavoaos.logviewer.service;

import com.github.gustavoaos.logviewer.model.Level;
import com.github.gustavoaos.logviewer.model.LogViewer;
import com.github.gustavoaos.logviewer.repository.LogViewerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class LogViewerService implements LogViewerServiceInterface {

    @Autowired
    private LogViewerRepository repository;

    @Override
    public LogViewer save(LogViewer logViewer) {
        return this.repository.save(logViewer);
    }

    @Override
    public Optional<LogViewer> findById(Long id) {
        return this.repository.findById(id);
    }

    @Override
    public Page<LogViewer> findAll(Pageable pageable) {
        return this.repository.findAll(pageable);
    }

    @Override
    public Page<LogViewer> findByLevel(Level level, Pageable pageable) {
        return this.repository.findByLevel(level, pageable);
    }

    @Override
    public Page<LogViewer> findByDescription(String description, Pageable pageable) {
        return this.repository.findByDescription(description, pageable);
    }

    @Override
    public Page<LogViewer> findByUserName(String userName, Pageable pageable) {
        return this.repository.findByUserName(userName, pageable);
    }

    @Override
    public Page<LogViewer> findByDate(LocalDateTime date, Pageable pageable) {
        return this.repository.findByDate(date, pageable);
    }

    @Override
    public Page<LogViewer> findByQuantity(Integer quantity, Pageable pageable) {
        return this.repository.findByQuantity(quantity, pageable);
    }
    
}