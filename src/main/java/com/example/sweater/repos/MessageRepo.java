package com.example.sweater.repos;

import com.example.sweater.domain.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called messageRepo
// CRUD refers Create, Read, Update, Delete

public interface MessageRepo extends CrudRepository<Message, Integer> {
    List<Message> findByTag(String tag);
}