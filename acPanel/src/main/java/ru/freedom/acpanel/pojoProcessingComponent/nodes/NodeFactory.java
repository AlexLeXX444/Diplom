package ru.freedom.acpanel.pojoProcessingComponent.nodes;

public interface NodeFactory {
    NodeMain createNode(long id, String name, int batteryCapacity, int totalNumberOfLogins, int numberOf);
    NodeMain createNode(long id, String name, int totalNumberOfLogins, int numberOf);
}
