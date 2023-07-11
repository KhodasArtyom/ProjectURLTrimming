package by.tms.url.controller;

import by.tms.url.model.URLModel;
import by.tms.url.service.UrlService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Controller
@AllArgsConstructor
public class UrlController {

    private final UrlService urlService;


    @GetMapping("/to/{id}")
    public ResponseEntity<?> redirect(@PathVariable long id) {
        URLModel urlModel = urlService.findUrl(id);
        return ResponseEntity.status(HttpStatus.FOUND)
                .location(urlModel.getLongUrlAddress())
                .build();
    }

    @GetMapping("/add-url")
    public ResponseEntity<?> addUrl(@RequestParam URI url, UriComponentsBuilder uriComponentsBuilder) {
        URLModel urlModel = urlService.addUrl(url);
        URI redirectUrl = uriComponentsBuilder
                .path("/")
                .queryParam("id", urlModel.getId())
                .build()
                .toUri();
        return ResponseEntity.status(HttpStatus.FOUND)
                .location(redirectUrl)
                .build();
    }

    public ModelAndView getHomePage(@RequestParam(required = false) Long id, UriComponentsBuilder uriComponentsBuilder) {
        URLModel shortLink = id == null ? null : urlService.findUrl(id);
        String baseShortUrl = uriComponentsBuilder.path("/to")
                .build()
                .toUriString();

        Map<String, Object> model = new HashMap<>();
        model.put("shortLink", shortLink);
        model.put("baseShortLinkUrl", baseShortUrl);


        return new ModelAndView("main-page", model);
    }


}