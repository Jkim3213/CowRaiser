package io.github.jkim3213.cowraiser;

public class StoreItem {
    String name;
    int imageId;
    int cost;
    int level;
    String type;

    StoreItem(String name, int imageId, int cost, int level, String type) {
        this.name = name;
        this.imageId = imageId;
        this.cost = cost;
        this.level = level;
        this.type = type;
    }
}
