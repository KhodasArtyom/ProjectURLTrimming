package by.tms.url.model;

import lombok.Value;

import java.net.URI;

@Value
public class URLModel {
    long id;
    URI longUrlAddress;
}
