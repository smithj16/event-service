package com.om.exeception;

import io.quarkus.logging.Log;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class GlobalExceptionMapper implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(Exception exception) {
        Log.error("Unhandled exception", exception);

        if (exception instanceof NoEventFoundException) {
            return handleNoEventViolation();
        } else if (exception instanceof EventAlreadyExistException) {
            return handleEventExistException();
        } else if (exception instanceof NotFoundException)
            return handleNoEventViolation();

        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity("Internal Server Error")
                .build();
    }

    private Response handleNoEventViolation() {

        return Response.status(Response.Status.BAD_REQUEST)
                .entity("No event found")
                .build();
    }

    private Response handleEventExistException() {
        return Response.status(Response.Status.CONFLICT)
                .entity("Event already exists")
                .build();
    }
}
