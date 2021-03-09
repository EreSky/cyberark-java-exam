package com.cyberark.items.controllers;

import com.cyberark.items.entities.Item;
import com.cyberark.items.entities.ItemRuleType;
import com.cyberark.items.entities.ItemType;
import com.cyberark.items.interfaces.ItemRulesRepository;
import com.cyberark.items.interfaces.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("items")
@RestController
public class ItemController {
    private final ItemService itemService;
    private final ItemRulesRepository itemRulesRepository;

    public ItemController(ItemService itemService, ItemRulesRepository itemRulesRepository) {
        this.itemService = itemService;
        this.itemRulesRepository = itemRulesRepository;
    }

    @GetMapping()
    public ResponseEntity<List<Item>> findAllItems() {
        return ResponseEntity.ok(itemService.getItems());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Item> getItem(@PathVariable(name = "id") Long itemId) {
        return ResponseEntity.ok(itemService.getItem(itemId));
    }

    @PostMapping()
    @ResponseBody
    public ResponseEntity<Item> createItem(@RequestBody Item item) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(itemService.addItem(item));
    }

    @PutMapping(path = "/dailyUpdate")
    @ResponseBody
    public ResponseEntity<Void> dailyUpdate() {
        itemService.dailyUpdateItems();
        return ResponseEntity.ok().build();
    }

    @PutMapping(path = "/rules")
    @ResponseBody
    public ResponseEntity<Void> setItemRule(@RequestParam ItemType itemType, @RequestParam ItemRuleType itemRuleType) {
        itemRulesRepository.addItemRule(itemType, itemRuleType);
        return ResponseEntity.ok().build();
    }
}
