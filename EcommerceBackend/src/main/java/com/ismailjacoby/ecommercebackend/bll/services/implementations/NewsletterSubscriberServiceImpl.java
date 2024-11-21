package com.ismailjacoby.ecommercebackend.bll.services.implementations;

import com.ismailjacoby.ecommercebackend.bll.exceptions.EmailAlreadySubscribedException;
import com.ismailjacoby.ecommercebackend.bll.services.NewsletterSubscriberService;
import com.ismailjacoby.ecommercebackend.dal.models.entities.NewsletterSubscriberEntity;
import com.ismailjacoby.ecommercebackend.dal.repositories.NewsletterSubscriberRepository;
import com.ismailjacoby.ecommercebackend.pl.models.forms.EmailForm;
import org.springframework.stereotype.Service;

@Service
public class NewsletterSubscriberServiceImpl implements NewsletterSubscriberService {

    private NewsletterSubscriberRepository newsletterSubscriberRepository;

    public NewsletterSubscriberServiceImpl(NewsletterSubscriberRepository newsletterSubscriberRepository) {
        this.newsletterSubscriberRepository = newsletterSubscriberRepository;
    }

    @Override
    public void subscribeToNewsletter(EmailForm form) {
        if(!newsletterSubscriberRepository.existsByEmail(form.getEmail())){
            NewsletterSubscriberEntity subscriber = new NewsletterSubscriberEntity();
            subscriber.setEmail(form.getEmail());
            newsletterSubscriberRepository.save(subscriber);
        } else{
            throw new EmailAlreadySubscribedException("Email already subscribed");
        }
    }
}
