package com.cyberark.items.rules;

import com.cyberark.items.entities.Item;
import com.cyberark.items.entities.ItemRuleType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class GainsValueWithAgeRule extends BaseRule{
    @Override
    protected Item updateItem(Item item, int factor) {
        int price = item.getPrice();
        item.setPrice(++price);

        return item;
    }

    @Override
    public ItemRuleType getRuleType() {
        return ItemRuleType.GAINS_VALUE_WITH_AGE;
    }
}
