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
@Table(name = "MAIN")
public class Main {
    @Id
    private int ID;
    private int SESSIONID;
    private String NMAE;
    
}
