package com.cyberark.items.services;

import com.cyberark.items.entities.Item;
import com.cyberark.items.factories.RuleFactory;
import com.cyberark.items.interfaces.ItemRulesRepository;
import com.cyberark.items.interfaces.Rule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ItemUpdaterService {
    private final RuleFactory ruleFactory;
    private final ItemRulesRepository itemRulesRepository;

    public ItemUpdaterService(RuleFactory ruleFactory, ItemRulesRepository itemRulesRepository) {
        this.ruleFactory = ruleFactory;
        this.itemRulesRepository = itemRulesRepository;
    }

    public void update(Item item) {
        Rule rule = ruleFactory.getRule(itemRulesRepository.getRuleType(item.getType()));
        rule.update(item);
    }
}
