package com.om.model;

import org.jboss.resteasy.reactive.RestForm;

import java.io.File;

public class Image {
    @RestForm
    public File file;
    @RestForm
    public String filename;
    @RestForm
    public String mimetype;
}
