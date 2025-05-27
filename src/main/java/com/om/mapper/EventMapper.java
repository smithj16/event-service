package com.om.mapper;

import com.om.dto.EventRequestDTO;
import com.om.dto.EventResponseDTO;
import com.om.model.Event;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class EventMapper {

    public static EventResponseDTO toEventResponseDTO(Event event) {
        EventResponseDTO eventResponseDTO = new EventResponseDTO();
        eventResponseDTO.setId(event.getId().toString());
        eventResponseDTO.setName(event.getName());
        eventResponseDTO.setStreet(event.getStreet());
        eventResponseDTO.setCity(event.getCity());
        eventResponseDTO.setState(event.getState());
        eventResponseDTO.setZip(event.getZip());
        eventResponseDTO.setCountry(event.getCountry());
        eventResponseDTO.setDescription(event.getDescription());
        eventResponseDTO.setStartDateTime(event.getStartDateTime().toString());
        eventResponseDTO.setEndDateTime(event.getEndDateTime().toString());
        eventResponseDTO.setWebsiteUrl(event.getWebsiteUrl());
        eventResponseDTO.setImage(event.getImage());
        eventResponseDTO.setLikes(event.getLikes());
        eventResponseDTO.setRating(event.getRating());
        eventResponseDTO.setAttendees(event.getAttendees());
        eventResponseDTO.setType(event.getType());

        return eventResponseDTO;
    }

    public static Event toEvent(EventRequestDTO eventRequestDTO) {
        Event event = new Event();
        event.setAccountId(eventRequestDTO.getAccountId());
        event.setName(eventRequestDTO.getName());
        event.setCreationDate(LocalDate.parse(eventRequestDTO.getCreationDate()));
        event.setStreet(eventRequestDTO.getStreet());
        event.setCity(eventRequestDTO.getCity());
        event.setState(eventRequestDTO.getState());
        event.setZip(eventRequestDTO.getZip());
        event.setCountry(eventRequestDTO.getCountry());
        event.setDescription(eventRequestDTO.getDescription());
        event.setStartDateTime(LocalDateTime.parse(eventRequestDTO.getStartDateTime()));
        event.setEndDateTime(LocalDateTime.parse(eventRequestDTO.getEndDateTime()));
        event.setWebsiteUrl(eventRequestDTO.getWebsiteUrl());
        event.setImage(eventRequestDTO.getImage());
        event.setAttendees(eventRequestDTO.getAttendees());
        event.setType(eventRequestDTO.getType());
        return event;
    }
}
