package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface MessageRepository extends CrudRepository<Message, Integer> {
	  @Query("select t from Message t where ((t.sender = :id1 AND t.recipient = :id2) OR (t.sender = :id2 AND t.recipient = :id1))")
	  List<Message> findMessagesWithUserPair(@Param("id1") String id1, @Param("id2") String id2);
}
