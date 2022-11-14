package com.freedom.acpanel.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name = "nodesDataTable")
public class Node {
    @Id
    private long id;

    private String name;
    private int totalNumberOfLogins;
    private int numberOfLogins;

    @Override
    public String toString() {
        return "Device{" + 
                "id=" + this.id + 
                ", name='" + this.name + '\'' +
                ", totalNumberOfLogins='" + this.totalNumberOfLogins + '\'' +
                ", numberOfLogins='" + this.numberOfLogins +
                '}';
    }
}