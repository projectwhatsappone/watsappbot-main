package com.bot.watsappbot.NEW;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "DATA")
public class Data {
    @Id
    private int ID;
    private String previusID;
    private String CurrentID;
    private String userText;
    private String CONTENT;
    
}
