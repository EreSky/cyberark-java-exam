package com.cyberark.items.rules;

import com.cyberark.items.entities.Item;
import com.cyberark.items.entities.ItemRuleType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Slf4j
@Component
public class LosesConstantPercentWithAgeRule extends BaseRule {
    @Override
    protected Item updateItem(Item item, int factor) {
        int daysToExpire = item.getDaysToExpire();
        item.setDaysToExpire(--daysToExpire);
        int price = item.getPrice();

        for (int i = 0; i < factor; i++) {
            if (price >= 20) {
                subtractPercentage(item, price);
            }
        }

        return item;
    }

    @Override
    public ItemRuleType getRuleType() {
        return ItemRuleType.LOSES_CONSTANT_PERCENT_WITH_AGE;
    }

    private void subtractPercentage(Item item, int price) {
        price = new BigDecimal(price * 0.95)
                .setScale(0, RoundingMode.HALF_UP)
                .intValue();
        item.setPrice(price);
    }
}
