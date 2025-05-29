package com.om.service;


import com.om.dto.EventRequestDTO;
import com.om.dto.EventResponseDTO;
import com.om.exeception.EventAlreadyExistException;
import com.om.exeception.NoEventFoundException;
import com.om.mapper.EventMapper;
import com.om.model.Event;
import com.om.repository.EventRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@ApplicationScoped
public class EventService {
    @Inject
    EventRepository repo;

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
        Optional<Event> event = repo.findByIdOptional(id);

        if(event.isPresent()){
            return EventMapper.toEventResponseDTO(event.get());
        }else
            throw new NoEventFoundException("No event found with id " + id);

    }

    public EventResponseDTO createEvent(EventRequestDTO event) {

        //event must be unique
        if(repo.findByName(event.getName()) != null){
            throw new EventAlreadyExistException("Event with name " + event.getName() + " already exists");
        }

        Event newEvent = EventMapper.toEvent(event);
        repo.persist(newEvent);

        if(!repo.isPersistent(newEvent))
            return null;

        return EventMapper.toEventResponseDTO(repo.findByName(event.getName()));
    }

    public EventResponseDTO updateEvent(UUID id, EventRequestDTO newEvent) {
        //event must exist
        Optional<Event> oldEvent = repo.findByIdOptional(id);

        if(!oldEvent.isPresent())
            throw new NoEventFoundException("No event found with id " + id);

        Event updatedEvent = oldEvent.get();

        updatedEvent.setName(newEvent.getName());
        updatedEvent.setCity(newEvent.getCity());
        updatedEvent.setCountry(newEvent.getCountry());
        updatedEvent.setState(newEvent.getState());
        updatedEvent.setZip(newEvent.getZip());
        updatedEvent.setStartDateTime(LocalDateTime.parse(newEvent.getStartDateTime()));
        updatedEvent.setEndDateTime(LocalDateTime.parse(newEvent.getEndDateTime()));
        updatedEvent.setDescription(newEvent.getDescription());
        updatedEvent.setWebsiteUrl(newEvent.getWebsiteUrl());
        updatedEvent.setAttendees(newEvent.getAttendees());
        updatedEvent.setImage(newEvent.getImage());

        repo.persist(updatedEvent);
        return EventMapper.toEventResponseDTO(updatedEvent);
    }

    public boolean deleteEvent(UUID id) {
        return repo.deleteById(id);
    }
}
