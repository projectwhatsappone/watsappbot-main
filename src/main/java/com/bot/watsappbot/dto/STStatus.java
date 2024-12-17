package com.bot.watsappbot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class STStatus{
    public int groupId;
    public String groupName;
    public int id;
    public String name;
    public String description;
}
