package com.ismailjacoby.ecommercebackend.dal.repositories;

import com.ismailjacoby.ecommercebackend.dal.models.entities.NewsletterSubscriberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsletterSubscriberRepository extends JpaRepository<NewsletterSubscriberEntity, Long> {
    boolean existsByEmail(String email);
}
