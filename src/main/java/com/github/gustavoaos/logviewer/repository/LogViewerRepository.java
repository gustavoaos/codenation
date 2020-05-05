package com.github.gustavoaos.logviewer.repository;

import com.github.gustavoaos.logviewer.model.Level;
import com.github.gustavoaos.logviewer.model.LogViewer;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface LogViewerRepository extends JpaRepository<LogViewer, Long> {

    Optional<LogViewer> findById(Long id);
    
    Page<LogViewer> findAll(Pageable pageable);

    Page<LogViewer> findByLevel(Level level, Pageable pageable);

    Page<LogViewer> findByDescription(String description, Pageable pageable);

    Page<LogViewer> findByUserName(String userName, Pageable pageable);

    Page<LogViewer> findByDate(LocalDateTime date, Pageable pageable);

    Page<LogViewer> findByQuantity(Integer quantity, Pageable pageable);

}