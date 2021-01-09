package com.example.sweater.repos;

import com.example.sweater.domain.Message;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called messageRepo
// CRUD refers Create, Read, Update, Delete
@Transactional(readOnly = true)
public interface MessageRepo extends CrudRepository<Message, Integer> {
    List<Message> findByTag(String tag);

    @Modifying
    @Transactional
    @Query("delete from Message m where m.tag=:tag")
    void deleteByTag(@Param("tag") String tag);
}