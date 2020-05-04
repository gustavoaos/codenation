package com.github.gustavoaos.logviewer.controller;

import com.github.gustavoaos.logviewer.model.LogViewer;
import com.github.gustavoaos.logviewer.service.LogViewerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import java.util.List;

@RestController
@RequestMapping("v1/logViewer")
public class LogViewerController {

    @Autowired
    private LogViewerService service;

    private final String DEFAULT_PAGE_SIZE = "2";
    private final String DEFAULT_PAGE = "0";

    @PostMapping(
        value = "",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<LogViewer> create(@Valid @RequestBody LogViewer logViewer) {
        return new ResponseEntity<LogViewer>(
            this.service.save(logViewer),
            HttpStatus.CREATED);
    }

    @GetMapping(
        value = "/{id}",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<LogViewer> findById(@PathVariable("id") Long id) {
        return new ResponseEntity<LogViewer>(
            this.service.findById(id)
                .orElseThrow(() -> new RuntimeException("LogViewer " + id + " not found")),
            HttpStatus.OK);
    }

    @GetMapping(
        value = "",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<LogViewer> findAll(
            @RequestParam(defaultValue = DEFAULT_PAGE, name = "page") Integer pageNo,
            @RequestParam(defaultValue = DEFAULT_PAGE_SIZE, name = "size") Integer pageSize,
            @RequestParam(defaultValue = "unsorted", name = "sort") String sortBy) {

        Sort sort = sortBy.equals("unsorted") ? Sort.unsorted() : Sort.by(sortBy);

        return this.service
                .findAll(PageRequest.of(pageNo, pageSize, sort))
                .getContent();
    }
    
}