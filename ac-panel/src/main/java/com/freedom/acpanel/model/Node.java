package com.freedom.acpanel.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity(name = "nodesDataTable")
public class Node {
    @Id
    private long id;

    private String name;
    private int batteryCapacity = 0;
    private int totalNumberOfLogins = 0;
    private int numberOfLogins = 0;

    public Node() {}
    @Override
    public String toString() {
        return "Device{" + 
                "id=" + this.id + 
                ", name='" + this.name + '\'' +
                ", batteryCapacity='" + this.batteryCapacity + '\'' +
                ", totalNumberOfLogins='" + this.totalNumberOfLogins + '\'' +
                ", numberOfLogins='" + this.numberOfLogins +
                '}';
    }
}