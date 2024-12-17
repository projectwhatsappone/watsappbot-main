package com.bot.watsappbot.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bot.watsappbot.NEW.Data;

@Repository
public interface DataRepository extends JpaRepository<Data,Integer> {
    Optional<Data> findByPreviusIDAndUserText(String previusID, String userText);
    Optional<Data> findCurrentByPreviusIDAndUserText(String previusID, String userText);
}
