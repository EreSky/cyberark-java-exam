package com.cyberark.items.rules;

import com.cyberark.items.entities.Item;
import com.cyberark.items.entities.ItemRuleType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class FixedValueRule extends BaseRule{
    @Override
    protected Item updateItem(Item item, int factor) {
        return item;
    }

    @Override
    public ItemRuleType getRuleType() {
        return ItemRuleType.FIXED_VALUE;
    }
}
