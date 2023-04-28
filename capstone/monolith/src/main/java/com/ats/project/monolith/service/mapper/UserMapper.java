package com.ats.project.monolith.service.mapper;

import org.mapstruct.Mapper;

import com.ats.project.monolith.entity.User;
import com.ats.project.monolith.service.dto.UserDTO;

@Mapper(componentModel = "spring", uses = {})
public interface UserMapper extends EntityMapper<UserDTO,User>{

}
