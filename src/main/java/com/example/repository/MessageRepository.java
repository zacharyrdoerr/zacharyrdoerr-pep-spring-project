package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.entity.Message;

public interface MessageRepository extends JpaRepository<Message, Integer>{

    // custom query for delete in order to return the amount of rows updated
    // returns 1 for successful deletion, 0 for unsuccesful deletion/message does not exist
    @Query("DELETE FROM Message WHERE messageId = :id")
    int deleteMessageById(@Param("id") int id);

    // custom query for update in order to return the amount of rows updated
    // returns 1 for succesful update, 0 for unsuccesful
    @Query("UPDATE Message SET messageText = :newMessageText WHERE messageID = :id")
    int updateMessageById(@Param("id") int id, @Param("newMessageText") String newMessageText);
}
