package com.ismailjacoby.ecommercebackend.pl.controllers;

import com.ismailjacoby.ecommercebackend.bll.services.NewsletterSubscriberService;
import com.ismailjacoby.ecommercebackend.pl.models.forms.EmailForm;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/newsletter")
public class NewsletterSubscriberController {

    private NewsletterSubscriberService newsletterSubscriberService;

    public NewsletterSubscriberController(NewsletterSubscriberService newsletterSubscriberService) {
        this.newsletterSubscriberService = newsletterSubscriberService;
    }

    @PostMapping("/subscribe")
    public void subscribeToNewsletter(@RequestBody @Valid EmailForm form) {
        newsletterSubscriberService.subscribeToNewsletter(form);
    }
}
