package com.cyberark.items.rules;

import com.cyberark.items.entities.Item;
import com.cyberark.items.entities.ItemType;
import com.cyberark.items.interfaces.Rule;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FixedValueRuleTest {
    private final Rule rule = new FixedValueRule();

    @Test
    public void whenItemUpdatedRuleDoesntChangeItem() {
        Item item = new Item(1, ItemType.BANANA, 12, 19);
        Item result = rule.update(item);
        assertEquals(19, result.getPrice());
        assertEquals(12, result.getDaysToExpire());
    }
}
