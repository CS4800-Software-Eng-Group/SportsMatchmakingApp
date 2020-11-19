package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface FriendshipRepository extends CrudRepository<Friendship, Integer> {
	  @Query("select t from Friendship t where (userId1 = :id1 OR userId2 = :id1)")
	  List<Friendship> findFriendshipById(@Param("id1") int id1);
	  
	  @Query("select t from Friendship t where ((userId1 = :id1 AND userId2 = :id2) OR (userId1 = :id2 AND userId2 = :id1))")
	  Friendship findFriendshipWithIdPair(@Param("id1") int id1, @Param("id2") int id2);
}
	