package ru.freedom.acpanel.pojoProcessingComponent.nodes;

public class NodeFactoryMain implements NodeFactory {
    @Override
    public NodeMain createNode(long id, String name, int batteryCapacity, int totalNumberOfLogins, int numberOf) {
        return new NodeMain(id, name, batteryCapacity, totalNumberOfLogins, numberOf);
    }

    @Override
    public NodeMain createNode(long id, String name, int totalNumberOfLogins, int numberOf) {
        return new NodeMain(id, name, totalNumberOfLogins, numberOf);
    }
}
