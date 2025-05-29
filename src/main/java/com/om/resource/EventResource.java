package com.om.resource;

import com.om.dto.EventRequestDTO;
import com.om.dto.EventResponseDTO;
import com.om.model.Event;
import com.om.service.EventService;
import com.om.validator.ValidationGroups;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.groups.ConvertGroup;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.jboss.resteasy.reactive.RestResponse;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@Path("api/events")
@Produces(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class EventResource {

    @Inject
    EventService eventService;

    public EventResource(EventService eventService) {
        this.eventService = eventService;
    }

    @GET
    @Operation(summary = "Get all events",
    description = "Returns a list of all events")
    @APIResponse(responseCode = "200", description = "List of events",
    content = @Content(
        mediaType = "application/json",
        schema = @Schema(implementation = Event.class)
    ))
    public RestResponse<List<EventResponseDTO>> getAllEvents() {
        return RestResponse.ok(eventService.getAllEvents());
    }

    @GET
    @Path("{id}")
    @Operation(summary = "Get event by id",
            description = "Returns a event")
    @APIResponse(responseCode = "200", description = "one event",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = Event.class)
            ))
    public RestResponse<EventResponseDTO> getEventById(UUID id) {
        return RestResponse.ok(eventService.getEventById(id));
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    @Operation(summary = "Create an event",
            description = "Creates an event")
    @APIResponse(responseCode = "200", description = "one event",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = Event.class)
            ))
    public RestResponse<EventResponseDTO> createEvent(@Valid @ConvertGroup(to = ValidationGroups.Create.class) EventRequestDTO newEvent) {
        EventResponseDTO event = eventService.createEvent(newEvent);

        if (event == null)
            return RestResponse.status(Response.Status.BAD_REQUEST);

        return RestResponse.created(URI.create("/event/" + event.getId()));
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    @Operation(summary = "Update an event by id",
            description = "Returns updated event")
    @APIResponse(responseCode = "200", description = "one event",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = Event.class)
            ))
    public RestResponse<EventResponseDTO> updateEvent(UUID id, @Valid @ConvertGroup(to = ValidationGroups.Update.class) EventRequestDTO event) {
        return RestResponse.ok(eventService.updateEvent(id, event));
    }

    @DELETE
    @Path("{id}")
    @Transactional
    @Operation(summary = "Delete an event by id",
            description = "Return no-content")
    @APIResponse(responseCode = "200", description = "one event",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = Event.class)
            ))
    public RestResponse deleteEvent(UUID id) {
        if(eventService.deleteEvent(id))
            return RestResponse.ok();

        return RestResponse.notFound();
    }


}
