package com.manulife.lmj.basic.stream;

import java.util.List;

public class Cases {

    public Cases(String id, String number, String name, List<Attachments> attachments) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.attachments = attachments;
    }

    public Cases(List<Attachments> attachments) {
        this.attachments = attachments;
    }

    @Override
    public String toString() {
        return "Cases{" +
                "id='" + id + '\'' +
                ", number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", attachments=" + attachments +
                '}';
    }

    private String id;
    private String number;
    private String name;
    private List<Attachments> attachments;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Attachments> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Attachments> attachments) {
        this.attachments = attachments;
    }
}
