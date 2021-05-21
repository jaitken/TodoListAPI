package com.joe.todo.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "items")
public class Item {

    @Id
    private String id;
    private String title;
    private String[] thingsToDo;

    public Item(String id, String title, String[] thingsToDo) {
        this.id = id;
        this.title = title;
        this.thingsToDo = thingsToDo;
    }

    public Item() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getThingsToDo() {
        return thingsToDo;
    }

    public void setThingsToDo(String[] thingsToDo) {
        this.thingsToDo = thingsToDo;
    }

}
