package com.cyberark.items.factories;

import com.cyberark.items.entities.Item;
import com.cyberark.items.entities.ItemRuleType;
import com.cyberark.items.entities.ItemType;
import com.cyberark.items.interfaces.Rule;
import com.cyberark.items.rules.GainsValueWithAgeRule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RuleFactoryTest {

    @Autowired
    private RuleFactory ruleFactory;

    @Test
    public void whenAboveThousandStaysThousand() {
        Stream.of(ItemRuleType.values()).forEach(itemRuleType -> {
            Rule rule = ruleFactory.getRule(itemRuleType);
            assertNotNull(rule);
        });
    }
}
