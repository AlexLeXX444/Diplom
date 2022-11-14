package com.freedom.acpanel.model;


import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.Value;

@Data
@Entity(name = "devicesDataTable")
public class Device {
    @Id
    private long id;
    
    private String name;
    private int hostId;
    private int usCode;
    private long nodeId;
    private String nodeName;
    private String type;
    private String model;
    private String ipAddress;
    private int totalNumberOfLogins;
    private int numberOfLogins;

    @Override
    public String toString() {
        return "Device{" + 
                "id=" + this.id + 
                ", name='" + this.name + '\'' +
                ", hostId='" + this.hostId + '\'' +
                ", usCode='" + this.usCode + '\'' +
                ", nodeId=" + this.nodeId + '\'' +
                ", nodeName='" + this.nodeName + '\'' +
                ", type='" + this.type + '\'' +
                ", model='" + this.model + '\'' +
                ", ipAddress='" + this.ipAddress + '\'' +
                ", totalNumberOfLogins='" + this.totalNumberOfLogins + '\'' +
                ", numberOfLogins='" + this.numberOfLogins +
                '}';
    }
}