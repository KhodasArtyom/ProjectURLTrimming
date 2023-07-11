package by.tms.url.service;

import by.tms.url.model.URLModel;

import java.net.URI;

public interface UrlService
{
    URLModel addUrl(URI url);

    URLModel findUrl(long id);
}
