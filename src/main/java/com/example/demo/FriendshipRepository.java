package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface FriendshipRepository extends CrudRepository<Friendship, Integer> {
	  @Query("select t from Friendship t where (t.userId1 = :id1 OR t.userId2 = :id1)")
	  List<Friendship> findFriendshipById(@Param("id1") String id1);
	  
	  @Query("select t from Friendship t where ((t.userId1 = :id1 AND t.userId2 = :id2) OR (t.userId1 = :id2 AND t.userId2 = :id1))")
	  Friendship findFriendshipWithIdPair(@Param("id1") String id1, @Param("id2") String id2);
}