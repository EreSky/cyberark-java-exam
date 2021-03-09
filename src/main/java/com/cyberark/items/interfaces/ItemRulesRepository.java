package com.cyberark.items.interfaces;

import com.cyberark.items.entities.ItemRuleType;
import com.cyberark.items.entities.ItemType;

import java.util.Map;

public interface ItemRulesRepository {
    void addItemRule(ItemType itemType, ItemRuleType itemRuleType);
    ItemRuleType getRuleType(ItemType itemType);
//    Map<ItemType, ItemRuleType> getItemRules();
}
