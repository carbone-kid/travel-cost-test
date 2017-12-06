package com.sfirsov.klmtest.model;

import java.io.Serializable;

public class Location implements Serializable{
    private String code, name, description;
    private Coordinates coordinates;
    private Location parent;
    private Location children;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Location getParent() {
        return parent;
    }

    public void setParent(Location parent) {
        this.parent = parent;
    }

    public Location getChildren() {
        return children;
    }

    public void setChildren(Location children) {
        this.children = children;
    }
}
