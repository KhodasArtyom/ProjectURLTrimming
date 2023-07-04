package model;

import lombok.Value;

import java.net.URI;

@Value
public class URLModel {
    private long id;
    URI longUrlAddress;
}
