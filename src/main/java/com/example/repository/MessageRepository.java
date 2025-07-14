package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.entity.Message;

public interface MessageRepository extends JpaRepository<Message, Integer>{

    // custom query for delete in order to return the amount of rows updated
    // returns 1 for successful deletion, 0 for unsuccesful deletion/message does not exist
    @Modifying
    @Query("DELETE FROM Message m WHERE m.messageId = :id")
    int deleteMessageById(@Param("id") int id);

    // custom query for update in order to return the amount of rows updated
    // returns 1 for succesful update, 0 for unsuccesful
    @Modifying
    @Query("UPDATE Message m SET m.messageText = :newMessageText WHERE m.messageId = :id")
    int updateMessageById(@Param("id") int id, @Param("newMessageText") String newMessageText);

    @Query("SELECT m FROM Message m WHERE m.postedBy = :id")
    List<Message> getMessagesByPostedBy(@Param("id") int id);
}
