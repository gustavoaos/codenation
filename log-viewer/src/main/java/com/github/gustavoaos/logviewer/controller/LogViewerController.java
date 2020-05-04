package com.github.gustavoaos.logviewer.controller;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.github.gustavoaos.logviewer.dto.LogViewerDTO;
import com.github.gustavoaos.logviewer.mapper.LogViewerMapper;
import com.github.gustavoaos.logviewer.model.Level;
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

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("v1/logViewer")
public class LogViewerController {

    private final String DEFAULT_PAGE_SIZE = "2";
    private final String DEFAULT_PAGE = "0";

    @Autowired
    private LogViewerService service;

    @Autowired
    private LogViewerMapper mapper;
    
    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LogViewer> create(@Valid @RequestBody LogViewer logViewer) {
        return new ResponseEntity<LogViewer>(
            this.service.save(logViewer),
            HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LogViewer> findById(@PathVariable("id") Long id) {
        return new ResponseEntity<LogViewer>(
            this.service.findById(id)
                .orElseThrow(() -> new RuntimeException("LogViewer not found")),
            HttpStatus.OK);
    }

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<LogViewerDTO> findAll(
            @RequestParam(defaultValue = DEFAULT_PAGE, name = "page") Integer pageNo,
            @RequestParam(defaultValue = DEFAULT_PAGE_SIZE, name = "size") Integer pageSize,
            @RequestParam(defaultValue = "unsorted", name = "sort") String sortBy) {

        Sort sort = sortBy.equals("unsorted") ? Sort.unsorted() : Sort.by(sortBy);

        return this.mapper.map(this.service.findAll(PageRequest.of(pageNo, pageSize, sort)).getContent());
    }

    @GetMapping(value = "/level/{level}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<LogViewerDTO> findByLevel(
            @PathVariable("level") Level level,
            @RequestParam(defaultValue = DEFAULT_PAGE, name = "page") Integer pageNo,
            @RequestParam(defaultValue = DEFAULT_PAGE_SIZE, name = "size") Integer pageSize,
            @RequestParam(defaultValue = "unsorted", name = "sort") String sortBy) {

        Sort sort = sortBy.equals("unsorted") ? Sort.unsorted() : Sort.by(sortBy);

        return this.mapper.map(this.service.findByLevel(level, PageRequest.of(pageNo, pageSize, sort)).getContent());
    }

    @GetMapping(value = "/description/{description}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<LogViewerDTO> findByDescription(
            @PathVariable("description") String description,
            @RequestParam(defaultValue = DEFAULT_PAGE, name = "page") Integer pageNo,
            @RequestParam(defaultValue = DEFAULT_PAGE_SIZE, name = "size") Integer pageSize,
            @RequestParam(defaultValue = "unsorted", name = "sort") String sortBy) {

        Sort sort = sortBy.equals("unsorted") ? Sort.unsorted() : Sort.by(sortBy);

        return this.mapper.map(this.service.findByDescription(description, PageRequest.of(pageNo, pageSize, sort)).getContent());
    }

    @GetMapping(value = "/origin/{origin}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<LogViewerDTO> findByOrigin(
            @PathVariable("origin") String origin,
            @RequestParam(defaultValue = DEFAULT_PAGE, name = "page") Integer pageNo,
            @RequestParam(defaultValue = DEFAULT_PAGE_SIZE, name = "size") Integer pageSize,
            @RequestParam(defaultValue = "unsorted", name = "sort") String sortBy) {

        Sort sort = sortBy.equals("unsorted") ? Sort.unsorted() : Sort.by(sortBy);

        return this.mapper.map(this.service.findByUserName(origin, PageRequest.of(pageNo, pageSize, sort)).getContent());
    }

    @GetMapping(value = "/date/{date}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<LogViewerDTO> findByDate(
            @PathVariable("date") String date,
            @RequestParam(defaultValue = DEFAULT_PAGE, name = "page") Integer pageNo,
            @RequestParam(defaultValue = DEFAULT_PAGE_SIZE, name = "size") Integer pageSize,
            @RequestParam(defaultValue = "unsorted", name = "sort") String sortBy) {

        Sort sort = sortBy.equals("unsorted") ? Sort.unsorted() : Sort.by(sortBy);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.parse(date, formatter);

        return this.mapper.map(this.service.findByDate(localDateTime, PageRequest.of(pageNo, pageSize, sort)).getContent());
    }

    @GetMapping(value = "/quantity/{quantity}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<LogViewerDTO> findByQuantity(
            @PathVariable("quantity") Integer quantity,
            @RequestParam(defaultValue = DEFAULT_PAGE, name = "page") Integer pageNo,
            @RequestParam(defaultValue = DEFAULT_PAGE_SIZE, name = "size") Integer pageSize,
            @RequestParam(defaultValue = "unsorted", name = "sort") String sortBy) {

        Sort sort = sortBy.equals("unsorted") ? Sort.unsorted() : Sort.by(sortBy);

        return this.mapper.map(this.service.findByQuantity(quantity, PageRequest.of(pageNo, pageSize, sort)).getContent());
    }
    
}