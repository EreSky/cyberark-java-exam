package com.cyberark.items.services;

import com.cyberark.items.entities.Item;
import com.cyberark.items.entities.ItemType;
import com.cyberark.items.interfaces.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;


@Slf4j
@Service
public class InMemoryItemService implements ItemService, InitializingBean {
    private final ConcurrentMap<Long, Item> itemsMap;
    private final ItemUpdaterService itemUpdaterService;

    public InMemoryItemService(ItemUpdaterService itemUpdaterService) {
        this.itemUpdaterService = itemUpdaterService;
        this.itemsMap = new ConcurrentHashMap<>();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        long id = 1;
        itemsMap.put(id, new Item(id++, ItemType.T_SHIRT, 10, 20));
        itemsMap.put(id, new Item(id++, ItemType.SCOTCH_BOTTLE, 2, 40));
        itemsMap.put(id, new Item(id++, ItemType.BEER, 5, 7));
        itemsMap.put(id, new Item(id++, ItemType.BEER, 10, 7));
        itemsMap.put(id, new Item(id++, ItemType.BASKETBALL, 0, 50));
        itemsMap.put(id, new Item(id++, ItemType.LAPTOP, 365, 500));
        itemsMap.put(id, new Item(id, ItemType.BANANA, 3, 2));
    }

    @Override
    public void clearItems() {
        itemsMap.clear();
    }

    @Override
    public List<Item> getItems() {
        return new ArrayList<>(itemsMap.values());
    }

    @Override
    public Item getItem(long id) {
        Item item = itemsMap.get(id);
        if (item == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "item id: " + id + "not found");
        }

        return item;
    }

    @Override
    public Item addItem(Item item) {
        itemsMap.put(item.getId(), item);
        return item;
    }

    @Override
    public void dailyUpdateItems() {
        itemsMap.values().forEach(itemUpdaterService::update);
    }
}
