package com.cyberark.items.rules;

import com.cyberark.items.entities.Item;
import com.cyberark.items.entities.ItemRuleType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class LosesConstantValueWithAgeRule extends BaseRule{
    @Override
    protected Item updateItem(Item item, int factor) {
        int price = item.getPrice();
        int daysToExpire = item.getDaysToExpire();
        item.setPrice(price - (factor));
        item.setDaysToExpire(--daysToExpire);

        return item;
    }

    @Override
    public ItemRuleType getRuleType() {
        return ItemRuleType.LOSES_CONSTANT_VALUE_WITH_AGE;
    }
}
