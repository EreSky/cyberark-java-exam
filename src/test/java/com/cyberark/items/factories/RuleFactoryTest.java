package com.cyberark.items.factories;

import com.cyberark.items.entities.ItemRuleType;
import com.cyberark.items.interfaces.Rule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class RuleFactoryTest {

    @Autowired
    private RuleFactory ruleFactory;

    @Test
    public void allRulesExist() {
        Stream.of(ItemRuleType.values()).forEach(itemRuleType -> {
            Rule rule = ruleFactory.getRule(itemRuleType);
            assertNotNull(rule);
        });
    }
}
