package com.cyberark.items.factories;

import com.cyberark.items.entities.ItemRuleType;
import com.cyberark.items.interfaces.Rule;
import com.cyberark.items.rules.BaseRule;
import com.cyberark.items.rules.LosesConstantValueWithAgeRule;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class RuleFactory {
    private final Map<ItemRuleType, Rule> ruleMapping = new HashMap<>();

    public RuleFactory(List<BaseRule> ruleList) {
        ruleList.forEach(rule -> ruleMapping.put(rule.getRuleType(), rule));
    }

    public Rule getRule(ItemRuleType ruleType){
        return ruleMapping.getOrDefault(ruleType, new LosesConstantValueWithAgeRule());
    }
}
