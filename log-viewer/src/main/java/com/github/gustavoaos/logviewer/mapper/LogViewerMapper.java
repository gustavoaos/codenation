package com.github.gustavoaos.logviewer.mapper;

import com.github.gustavoaos.logviewer.dto.LogViewerDTO;
import com.github.gustavoaos.logviewer.model.LogViewer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LogViewerMapper {

    @Mappings({
        @Mapping(source = "id", target = "id"),
        @Mapping(source = "level", target = "level"),
        @Mapping(source = "description", target = "description"),
        @Mapping(source = "user.name", target = "origin"),
        @Mapping(source = "quantity", target = "quantity"),
        @Mapping(source = "createdAt", target = "createdAt", dateFormat = "yyyy-MM-dd HH:mm")
    })

    LogViewerDTO map(LogViewer logViewer);

    List<LogViewerDTO> map(List<LogViewer> logViewers);
    
}