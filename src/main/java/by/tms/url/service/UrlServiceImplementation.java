package by.tms.url.service;

import by.tms.url.config.BlackListConfig;
import by.tms.url.exception.BusinessException;
import by.tms.url.model.URLModel;
import by.tms.url.repository.UrlRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.net.URI;

@AllArgsConstructor
@Service
public class UrlServiceImplementation implements UrlService {
    private UrlRepository urlRepository;
    private BlackListConfig blackListConfig;


    @Override
    @Transactional
    public URLModel addUrl(URI url) {
        if(isUrlNotBannedAndHasHttpAndHttps(url)){
            return urlRepository.createUrl(url);
        }else {
            throw new BusinessException("Error!");
        }
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public URLModel findUrl(long id) {
        return urlRepository.findUrlById(id).
                orElseThrow(IllegalArgumentException::new);
    }

    private boolean isUrlNotBannedAndHasHttpAndHttps(URI url) {
        if (url.getScheme().equals("http") || url.getScheme().equals("https")) {
            for (String banned : blackListConfig.getBlackList()) {
                if (url.getHost().equals(banned)) {
                    return true;
                }
            }
        }
        return false;
    }
}
