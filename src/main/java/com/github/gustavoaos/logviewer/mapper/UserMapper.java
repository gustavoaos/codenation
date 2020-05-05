package com.github.gustavoaos.logviewer.mapper;

import com.github.gustavoaos.logviewer.dto.UserDTO;
import com.github.gustavoaos.logviewer.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mappings({
        @Mapping(source = "email", target = "login"),
        @Mapping(source = "password", target = "password")
    })

    UserDTO map(User user);
    
}