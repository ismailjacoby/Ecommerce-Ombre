package com.ismailjacoby.ecommercebackend.bll.services;

import com.ismailjacoby.ecommercebackend.pl.models.forms.EmailForm;

public interface NewsletterSubscriberService {
    void subscribeToNewsletter(EmailForm form);
}
