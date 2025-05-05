package com.om.repository;

import com.om.model.Event;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.UUID;

@ApplicationScoped
public class EventRepository implements PanacheRepositoryBase<Event, UUID> {
    public Event findByName(String name) {
        return find("name", name).firstResult();
    }
}
