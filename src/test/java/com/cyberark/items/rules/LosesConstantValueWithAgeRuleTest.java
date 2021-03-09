package com.cyberark.items.rules;

import com.cyberark.items.entities.Item;
import com.cyberark.items.entities.ItemType;
import com.cyberark.items.interfaces.Rule;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LosesConstantValueWithAgeRuleTest {
    private final Rule rule = new LosesConstantValueWithAgeRule();

    @Test
    public void whenItemUpdatedRuleChangePriceAndDaysOnlyByOne() {
        Item item = new Item(1, ItemType.BANANA, 12, 19);
        Item result = rule.update(item);
        assertEquals(18, result.getPrice());
        assertEquals(11, result.getDaysToExpire());
    }

    @Test
    public void whenDaysZeroOrUnderUpdatePriceDouble() {
        Item item = new Item(1, ItemType.BANANA, 0, 19);
        Item result = rule.update(item);
        assertEquals(17, result.getPrice());
        assertEquals(-1, result.getDaysToExpire());
    }
}
