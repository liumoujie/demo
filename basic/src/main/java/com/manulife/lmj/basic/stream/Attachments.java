package com.manulife.lmj.basic.stream;

public class Attachments {

    public Attachments(String name, String type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Attachments{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private String type;

}
