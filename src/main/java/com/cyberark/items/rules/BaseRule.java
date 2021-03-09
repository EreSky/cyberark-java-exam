package com.cyberark.items.rules;

import com.cyberark.items.entities.Item;
import com.cyberark.items.entities.ItemRuleType;
import com.cyberark.items.interfaces.Rule;
import org.springframework.stereotype.Component;

@Component
public abstract class BaseRule implements Rule {

    @Override
    public Item update(Item item) {
        int factor = item.getDaysToExpire() <= 0 ? 2 : 1;

        Item result = updateItem(item, factor);
        if (result.getPrice() < 0) {
            result.setPrice(0);
        }
        if (result.getPrice() > 1000) {
            result.setPrice(1000);
        }

        return result;
    }

    protected abstract Item updateItem(Item item, int factor);

    public abstract ItemRuleType getRuleType();
}
