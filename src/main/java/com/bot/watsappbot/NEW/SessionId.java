package com.bot.watsappbot.NEW;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "SESSIONID")
public class SessionId {
    @Id
    private int id;
    private String sessionId;
    private String sender;
    private int status;
}
