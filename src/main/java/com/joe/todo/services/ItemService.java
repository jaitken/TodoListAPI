package com.joe.todo.services;

import com.joe.todo.models.Item;
import com.joe.todo.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    public Item add(Item item){
        itemRepository.save(item);
        return item;
    }

    public List<Item> addMultipleItems(List<Item> items) {
        itemRepository.saveAll(items);
        return items;
    }

    public void deleteItem(String id){
        itemRepository.deleteById(id);
    }

    public List<Item> getAll(){
        return itemRepository.findAll();
    }

    public Item updateItem(String id, Item item) {
        Optional<Item> itemOpt = itemRepository.findById(id);

        if(!itemOpt.isPresent()) {
            return null;
        }

        Item _item = itemOpt.get();

        _item.setTitle(item.getTitle());
        _item.setThingsToDo(item.getThingsToDo());

        itemRepository.save(_item);
        return _item;
    }

    public void deleteAll() {
        itemRepository.deleteAll();
    }

}
