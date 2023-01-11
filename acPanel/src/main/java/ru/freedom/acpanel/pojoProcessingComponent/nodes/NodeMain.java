package ru.freedom.acpanel.pojoProcessingComponent.nodes;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class NodeMain implements Node {
    private long id;
    private String name;
    private int batteryCapacity = 0;
    private int totalNumberOfLogins;
    private int numberOfLogins;

    public NodeMain(long id, String name, int totalNumberOfLogins, int numberOf) {
        this.id = id;
        this.name = name;
        this.totalNumberOfLogins = totalNumberOfLogins;
        this.numberOfLogins = numberOf;
    }

    @Override
    public String getInfo() {
        return "{ \"id\": \"" + id +
                "\",\"name\": \"" + name +
                "\",\"batteryCapacity\": " + batteryCapacity +
                ",\"totalNumberOfLogins\": " + totalNumberOfLogins +
                ",\"numberOfLogins\": " + numberOfLogins + " }";
    }
}
