package test.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.*;

public class Test18 {
    public static void main(String[] args) {
        String str = "{\"detailMapping\":{\"14\":{\"4\":{\"201\":\"channel_1\",\"202\":\"channel_2\",\"203\":\"channel_3\"}},\"17\":{\"4\":{\"21\":\"new_city\",\"22\":\"customer_exp\",\"23\":\"arpu_new\",\"24\":\"new_reborn\",\"25\":\"new_city_new\",\"26\":\"food_city\",\"27\":\"pilot\",\"28\":\"suzhou\",\"29\":\"wuxi\",\"30\":\"expand\",\"31\":\"base\",\"101\":\"m_bussiness\"},\"116\":{\"1\":\"main_city_driver_1\",\"2\":\"new_salary\",\"3\":\"kepler\",\"4\":\"main_city_salesman_4\",\"6\":\"arpu_core\",\"7\":\"arpu_alive\",\"8\":\"level_a\",\"9\":\"level_b\",\"10\":\"level_c\",\"11\":\"manager_sale\",\"12\":\"kepler_level_1\",\"13\":\"kepler_level_2\"}},\"25\":{\"4\":{\"21\":\"new_city\",\"22\":\"customer_exp\",\"23\":\"arpu_new\",\"24\":\"new_reborn\",\"25\":\"new_city_new\",\"26\":\"food_city\",\"27\":\"pilot\",\"28\":\"suzhou\",\"29\":\"wuxi\",\"30\":\"expand\",\"31\":\"base\",\"101\":\"m_business\"},\"116\":{\"1\":\"new_city_driver_1\",\"2\":\"new_salary\",\"3\":\"kepler\",\"4\":\"main_city_salesman_4\",\"6\":\"arpu_core\",\"7\":\"arpu_alive\",\"8\":\"level_a\",\"9\":\"level_b\",\"10\":\"level_c\",\"11\":\"manager_sale\",\"12\":\"kepler_level_1\",\"13\":\"kepler_level_2\"}}}}";
        JSONObject jsonObject = JSON.parseObject(str);
        String detailMapping = jsonObject.getJSONObject("detailMapping").getJSONObject(17 + "").getJSONObject(4 + "").getObject(31 + "", String.class);
        // .getJSONObject(17 + "").getJSONObject(4 + "").getJSONObject(31 + "");
        Map<String, Object> stringObjectMap = parseJSON2Map(str);
        System.out.println(stringObjectMap);
    }

    public static Map<String, Object> parseJSON2Map(String jsonStr) {
        Map<String, Object> map = new HashMap<>();
        JSONObject json = JSONObject.parseObject(jsonStr);
        for (Object k : json.keySet()) {
            Object v = json.get(k);
            if (v instanceof JSONArray) {
                List<Map<String, Object>> list = new ArrayList<>();
                Iterator it = ((JSONArray) v).iterator();
                while (it.hasNext()) {
                    Object json2 = it.next();
                    list.add(parseJSON2Map(json2.toString()));
                }
                map.put(k.toString(), list);
            } else {
                map.put(k.toString(), v);
            }
        }
        return map;
    }
}
