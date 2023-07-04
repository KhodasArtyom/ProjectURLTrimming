package repository;

import model.URLModel;

import java.net.URI;

public interface UrlRepository {

    URLModel createUrl(URI url);
}
