package com.bot.watsappbot.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bot.watsappbot.NEW.Main;


@Repository
public interface MainRepository extends JpaRepository<Main,Integer> {
    
}
