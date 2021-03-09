package com.cyberark.items.repositories;

import com.cyberark.items.entities.ItemRuleType;
import com.cyberark.items.entities.ItemType;
import com.cyberark.items.interfaces.ItemRulesRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class InMemoryItemRulesRepository implements ItemRulesRepository {
    private Map<ItemType, ItemRuleType> itemRules;

    public InMemoryItemRulesRepository() {
        itemRules = new HashMap<>();
    }

    @Override
    public void addItemRule(ItemType itemType, ItemRuleType itemRuleType) {
        itemRules.put(itemType, itemRuleType);
    }

    @Override
    public ItemRuleType getRuleType(ItemType itemType) {
        return itemRules.getOrDefault(itemType, ItemRuleType.LOSES_CONSTANT_VALUE_WITH_AGE);
    }

//    @Override
//    public Map<ItemType, ItemRuleType> getItemRules() {
//        return ItemRules;
//    }
}
