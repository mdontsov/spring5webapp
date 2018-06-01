package com.example.spring5webapp.repositories;

import com.example.spring5webapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by maxim on 31.05.2018.
 */
public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
