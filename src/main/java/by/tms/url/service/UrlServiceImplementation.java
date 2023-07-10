package by.tms.url.service;

import by.tms.url.config.BlackListConfig;
import by.tms.url.model.URLModel;
import by.tms.url.repository.UrlRepository;
import lombok.AllArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Service;

import java.net.URI;
@AllArgsConstructor
@Service

public class UrlServiceImplementation implements UrlService{
    private  UrlRepository urlRepository;
    private BlackListConfig blackListConfig;
    @Override
    public URLModel addUrl(URI url) {

        return null;
    }

    @Override
    public URLModel findUrl(long id) {
        return null;
    }
}
