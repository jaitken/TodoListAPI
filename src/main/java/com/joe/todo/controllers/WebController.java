package com.joe.todo.controllers;

import com.joe.todo.models.Item;
import com.joe.todo.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class WebController {

    @Autowired
    ItemService service;

    @GetMapping("/")
    public String home(){
        return "Current Mappings: " +
                "\n /add   " +
                "\n /addMultiple   " +
                "\n /all   " +
                "\n /update/{id}   " +
                "\n /delete/{id}   " +
                "\n /deleteAll   ";
    }

    @PostMapping("/add")
    public Item addItem(@RequestBody Item item){
        service.add(item);
        return item;
    }

    @PostMapping("/addMultiple")
    public List<Item> addMultipleItems(@RequestBody List<Item> items){
        return service.addMultipleItems(items);
    }

    @GetMapping("/all")
    public List<Item> getALl(){
        return service.getAll();
    }

    @PutMapping("/update/{id}")
    public Item updateItem(@PathVariable String id, @RequestBody Item item){
        Item _item = service.updateItem(id, item);
        return _item;
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id){
        service.deleteItem(id);
    }

    @DeleteMapping("/deleteAll")
    public void deleteAll(){
        service.deleteAll();
    }
}
