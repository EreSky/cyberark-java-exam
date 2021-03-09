package com.cyberark.items.rules;

import com.cyberark.items.entities.Item;
import com.cyberark.items.entities.ItemType;
import com.cyberark.items.interfaces.Rule;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LosesConstantPercentWithAgeRuleTest {
    private final Rule rule = new LosesConstantPercentWithAgeRule();

    @Test
    public void whenPriceUnderTwentyExpectNotChanged() {
        Item item = new Item(1, ItemType.BANANA, 12, 19);
        Item result = rule.update(item);
        assertEquals(19, result.getPrice());
        assertEquals(11, result.getDaysToExpire());
    }

    @Test
    public void whenPriceIsTwentyExpectChanged() {
        Item item = new Item(1, ItemType.BANANA, 12, 20);
        Item result = rule.update(item);
        assertEquals(19, result.getPrice());
        assertEquals(11, result.getDaysToExpire());
    }

    @Test
    public void whenPriceAboveTwentyExpectChanged() {
        Item item = new Item(1, ItemType.BANANA, 12, 40);
        Item result = rule.update(item);
        assertEquals(38, result.getPrice());
        assertEquals(11, result.getDaysToExpire());
    }

    @Test
    public void whenPriceFractionUnderPointFiveExpectRoundDown() {
        Item item = new Item(1, ItemType.BANANA, 12, 35);
        Item result = rule.update(item);
        assertEquals(33, result.getPrice());
        assertEquals(11, result.getDaysToExpire());
    }

    @Test
    public void whenPriceFractionAbovePointFiveExpectRoundUp() {
        Item item = new Item(1, ItemType.BANANA, 12, 29);
        Item result = rule.update(item);
        assertEquals(28, result.getPrice());
        assertEquals(11, result.getDaysToExpire());
    }

    @Test
    public void whenPriceFractionIsPointFiveExpectRoundUp() {
        Item item = new Item(1, ItemType.BANANA, 12, 30);
        Item result = rule.update(item);
        assertEquals(29, result.getPrice());
        assertEquals(11, result.getDaysToExpire());
    }
}
