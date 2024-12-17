package com.bot.watsappbot.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bot.watsappbot.NEW.SessionId;

@Repository
public interface SessionRepository extends JpaRepository<SessionId,Integer> {

    SessionId findBySender(String sender);
    
   
}
