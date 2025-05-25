package com.om.service;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.reactive.PartType;
import org.jboss.resteasy.reactive.RestForm;
import org.jboss.resteasy.reactive.RestResponse;

import java.io.File;

@RegisterRestClient(configKey = "bucket-service")
@Path("/s3")
public interface BucketServiceClient {

    @POST
    @Path("upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    Response uploadFile(@RestForm @PartType(MediaType.APPLICATION_OCTET_STREAM) File file,
                        @RestForm("filename") @PartType(MediaType.TEXT_PLAIN) String filename,
                        @RestForm("mimetype") @PartType(MediaType.TEXT_PLAIN) String mimetype);


}
