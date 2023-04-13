package com.ats.project.monolith.service.mapper;

import org.mapstruct.Mapper;

import com.ats.project.monolith.entity.Booking;
import com.ats.project.monolith.service.dto.BookingDTO;

@Mapper(componentModel = "spring", uses = {PassengerMapper.class,ScheduleMapper.class})
public interface BookingMapper extends EntityMapper<BookingDTO, Booking> {

}
