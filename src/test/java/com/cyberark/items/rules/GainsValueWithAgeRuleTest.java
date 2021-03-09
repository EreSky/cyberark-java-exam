package com.cyberark.items.rules;

import com.cyberark.items.entities.Item;
import com.cyberark.items.entities.ItemType;
import com.cyberark.items.interfaces.Rule;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GainsValueWithAgeRuleTest {
    private final Rule rule = new GainsValueWithAgeRule();

    @Test
    public void whenItemUpdatedRuleChangePriceOnlyByOne() {
        Item item = new Item(1, ItemType.BANANA, 12, 19);
        Item result = rule.update(item);
        assertEquals(20, result.getPrice());
        assertEquals(12, result.getDaysToExpire());
    }
}
