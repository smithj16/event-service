package com.om.service;


import com.om.dto.EventRequestDTO;
import com.om.dto.EventResponseDTO;
import com.om.exeception.EventAlreadyExistException;
import com.om.exeception.NoEventFoundException;
import com.om.mapper.EventMapper;
import com.om.model.Event;
import com.om.repository.EventRepository;
import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@ApplicationScoped
public class EventService {
    @Inject
    EventRepository repo;
    @Inject
    EventRepository eventRepository;

    public EventService(EventRepository repo) {
        this.repo = repo;
    }

    public List<EventResponseDTO> getAllEvents(){
        return repo.listAll()
                .stream()
                .map(EventMapper::toEventResponseDTO)
                .collect(Collectors.toList());
    }

    public EventResponseDTO getEventById(UUID id){
        Event event = repo.findById(id);

        if(event == null){
            throw new NoEventFoundException("Event with id " + id + " not found");
        }
        return EventMapper.toEventResponseDTO(event);
    }

    public EventResponseDTO createEvent(EventRequestDTO event) {

        //event must be unique
        if(repo.findByName(event.getName()) != null){
            throw new EventAlreadyExistException("Event with name " + event.getName() + " already exists");
        }

        Event newEvent = EventMapper.toEvent(event);
        repo.persist(newEvent);
        Log.info("Created new event: " + newEvent);

        if(!repo.isPersistent(newEvent))
            return null;

        return EventMapper.toEventResponseDTO(repo.findByName(event.getName()));
    }

    public EventResponseDTO updateEvent(UUID id, EventRequestDTO event) {
        //event must exist
        Event updateEvent = repo.findById(id);

        if(updateEvent == null){
            throw new NoEventFoundException("Event with id " + id + " not found");
        }

        updateEvent.setName(event.getName());
        updateEvent.setCity(event.getCity());
        updateEvent.setCountry(event.getCountry());
        updateEvent.setState(event.getState());
        updateEvent.setZip(event.getZip());
        updateEvent.setStartDateTime(LocalDateTime.parse(event.getStartDateTime()));
        updateEvent.setEndDateTime(LocalDateTime.parse(event.getEndDateTime()));
        updateEvent.setDescription(event.getDescription());
        updateEvent.setWebsiteUrl(event.getWebsiteUrl());
        updateEvent.setAttendees(event.getAttendees());
        updateEvent.setImageKey(event.getImageKey());

        repo.persist(updateEvent);
        return EventMapper.toEventResponseDTO(eventRepository.findById(updateEvent.getId()));
    }

    public void deleteEvent(UUID id) {
        repo.deleteById(id);
    }
}
