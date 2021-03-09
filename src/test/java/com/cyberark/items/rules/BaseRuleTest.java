package com.cyberark.items.rules;

import com.cyberark.items.entities.Item;
import com.cyberark.items.entities.ItemType;
import com.cyberark.items.interfaces.Rule;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaseRuleTest {
    private Rule rule;

    @Test
    public void whenPriceUnderZeroExpectNonNegative() {
        Item item = new Item(1, ItemType.BANANA, 12, 0);
        rule = new LosesConstantPercentWithAgeRule();
        Item result = rule.update(item);
        assertEquals(0, result.getPrice());

        rule = new LosesConstantValueWithAgeRule();
        result = rule.update(item);
        assertEquals(0, result.getPrice());
    }

    @Test
    public void whenAboveThousandStaysThousand() {
        Item item = new Item(1, ItemType.BANANA, 12, 1000);
        rule = new GainsValueWithAgeRule();
        Item result = rule.update(item);
        assertEquals(1000, result.getPrice());
    }
}
