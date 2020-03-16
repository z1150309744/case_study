package Rule;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 逆水
 * @Descripttion:
 * @Date: 2019年10月20日12时59分
 */
public class GlobalRule {

    public static Map<String, Rule> globalRuleMap;

    static {
        globalRuleMap = new HashMap<>();
    }

}
