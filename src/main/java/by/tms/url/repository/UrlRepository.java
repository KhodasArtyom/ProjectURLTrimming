package by.tms.url.repository;

//import org.springframework.stereotype.Repository;

import by.tms.url.model.URLModel;

import java.net.URI;
import java.util.Optional;

public interface UrlRepository {

    URLModel createUrl(URI url);

    Optional<URLModel> findUrlById(long id);

    Optional<URLModel> getShortUrlByLongUrl(URI fullUrl);
}
