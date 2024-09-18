package test.common;

import cn.hutool.json.JSONUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class GenerateQuotas {

    public static void main(String[] args) throws IOException {

        List<String> quotas = getQuotasByEtlName("dws.dws_sku_aftersales_daily");

        // String[] dims = {"", "big_area_id", "manage_warehouse_id"};
       // String[] dims = {"", "big_area_id", "city_id", "manage_warehouse_id"};
         String[] dims = {""};

        List<JsonRootBean> result = new ArrayList<>();
        List<JsonRootBean> rateResult = new ArrayList<>();
        List<Attribute> attributes = new ArrayList<>();
        List<Metric> metrics = new ArrayList<>();
        for (String string : quotas) {

            List<JsonRootBean> temp = new ArrayList<>();

            JsonRootBean bean1 = JsonRootBean.builder().metricCode("$quota").metricName("$quotaName").comment("$quotaName").metricType("2").metricChildType("201").metricFormula("").templateCode("").templateType("").build();

            JsonRootBean bean2 = JsonRootBean.builder().metricCode("$quota_drate").metricName("$quotaName日环比").comment("$quotaName日环比").metricType("3").metricChildType("302").metricFormula("").templateCode("drate").templateType("1").build();

            JsonRootBean bean3 = JsonRootBean.builder().metricCode("$quota_wcomp").metricName("$quotaName周同比").comment("$quotaName周同比").metricType("3").metricChildType("302").metricFormula("").templateCode("wcomp").templateType("1").build();

            JsonRootBean bean4 = JsonRootBean.builder().metricCode("$quota_wac").metricName("$quotaName周累计").comment("$quotaName周累计").metricType("2").metricChildType("202").metricFormula("").templateCode("wac").templateType("1").build();

            JsonRootBean bean5 = JsonRootBean.builder().metricCode("$quota_wac_wrate").metricName("$quotaName周累计环比").comment("$quotaName周累计环比").metricType("3").metricChildType("302").metricFormula("").templateCode("wrate").templateType("1").build();

            JsonRootBean bean6 = JsonRootBean.builder().metricCode("$quota_mac").metricName("$quotaName月累计").comment("$quotaName月累计").metricType("2").metricChildType("203").metricFormula("").templateCode("mac").templateType("1").build();

            JsonRootBean bean7 = JsonRootBean.builder().metricCode("$quota_mac_mrate").metricName("$quotaName月累计环比").comment("$quotaName月累计环比").metricType("3").metricChildType("302").metricFormula("").templateCode("mrate").templateType("1").build();

            temp.add(bean1);
            temp.add(bean2);
            temp.add(bean3);
            temp.add(bean4);
            temp.add(bean5);
            temp.add(bean6);
            temp.add(bean7);


            String[] split = string.split(" ");
            for (JsonRootBean jsonRootBean : temp) {
                jsonRootBean.setMetricCode(jsonRootBean.getMetricCode().replace("$quota", split[0]));
                jsonRootBean.setMetricName(jsonRootBean.getMetricName().replace("$quotaName", split[1]));
                jsonRootBean.setComment(jsonRootBean.getComment().replace("$quotaName", split[1]));
            }
            result.addAll(temp);


            // 处理率值指标
            List<JsonRootBean> rateBeansTemplate = getRateBeansTemplate();
            for (JsonRootBean jsonRootBean : rateBeansTemplate) {
                jsonRootBean.setMetricCode(jsonRootBean.getMetricCode().replace("$quota", split[0]));
                jsonRootBean.setMetricName(jsonRootBean.getMetricName().replace("$quotaName", split[1]));
                jsonRootBean.setComment(jsonRootBean.getComment().replace("$quotaName", split[1]));
                jsonRootBean.setMetricFormula(jsonRootBean.getMetricFormula().replace("$quota", split[0]));
            }
            rateResult.addAll(rateBeansTemplate);


            // attribute
            attributes.add(Attribute.builder().attributeCode(split[0]).attributeName(split[1]).fieldType(1).attributeType(2).build());


            // metric
            List<Metric> metricsTmp = new ArrayList<>();
            Metric metric1 = Metric.builder().metricCode(split[0]).computeFormula("{\"field\":\"" + split[0] + "\",\"aggregate\":\"sum\"}").rollUpDim("").build();
            Metric metric2 = Metric.builder().metricCode(split[0] + "_wac").computeFormula("{\"field\": \"" + split[0] + "\",\"aggregate\": \"sum\",\"dateInfo\":{\"dateType\":\"week\",\"firstDayOfWeek\":5,\"offsetStart\":0,\"offsetEnd\":0}}").rollUpDim("").build();
            Metric metric3 = Metric.builder().metricCode(split[0] + "_mac").computeFormula("{\"field\": \"" + split[0] + "\",\"aggregate\": \"sum\",\"dateInfo\":{\"dateType\":\"month\",\"offsetStart\":0,\"offsetEnd\":0}}").rollUpDim("").build();

            metricsTmp.add(metric1);
            metricsTmp.add(metric2);
            metricsTmp.add(metric3);

            metrics.addAll(metricsTmp);

        }

        System.out.println("指标率值:");
        System.out.println(JSONUtil.toJsonStr(rateResult));
        System.out.println("新增指标:");
        System.out.println(JSONUtil.toJsonStr(result));
        System.out.println("新增表字段:");
        System.out.println(JSONUtil.toJsonStr(attributes));
        for (String dim : dims) {
            for (int i = 0; i < metrics.size(); i++) {
                metrics.get(i).setRollUpDim(dim);
            }
            System.out.println("metrics字段,维度" + dim + ":");
            System.out.println(JSONUtil.toJsonStr(metrics));
        }

    }


    public static List<JsonRootBean> getRateBeansTemplate() throws IOException {
        String json = "[\n" +
                "    {\n" +
                "        \"metricCode\": \"$quota_rate\",\n" +
                "        \"metricName\": \"$quotaName(费率)\",\n" +
                "        \"comment\": \"$quotaName(费率)\",\n" +
                "        \"metricType\": \"3\",\n" +
                "        \"metricChildType\": \"301\",\n" +
                "        \"metricFormula\": \"{\\\"metric\\\":\\\"$quota\\\"}/{\\\"metric\\\":\\\"retail_sale_total\\\"}\",\n" +
                "        \"templateCode\": \"\",\n" +
                "        \"templateType\": \"\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"metricCode\": \"$quota_rate_drate\",\n" +
                "        \"metricName\": \"$quotaName(费率)日环比\",\n" +
                "        \"comment\": \"$quotaName(费率)日环比\",\n" +
                "        \"metricType\": \"3\",\n" +
                "        \"metricChildType\": \"302\",\n" +
                "        \"metricFormula\": \"\",\n" +
                "        \"templateCode\": \"drate\",\n" +
                "        \"templateType\": \"2\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"metricCode\": \"$quota_rate_wcomp\",\n" +
                "        \"metricName\": \"$quotaName(费率)周同比\",\n" +
                "        \"comment\": \"$quotaName(费率)周同比\",\n" +
                "        \"metricType\": \"3\",\n" +
                "        \"metricChildType\": \"302\",\n" +
                "        \"metricFormula\": \"\",\n" +
                "        \"templateCode\": \"wcomp\",\n" +
                "        \"templateType\": \"2\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"metricCode\": \"$quota_rate_wac\",\n" +
                "        \"metricName\": \"$quotaName(费率)周累计\",\n" +
                "        \"comment\": \"$quotaName(费率)周累计\",\n" +
                "        \"metricType\": \"3\",\n" +
                "        \"metricChildType\": \"301\",\n" +
                "        \"metricFormula\": \"{\\\"metric\\\":\\\"$quota_wac\\\"}/{\\\"metric\\\":\\\"retail_sale_total_wac\\\"}\",\n" +
                "        \"templateCode\": \"wac\",\n" +
                "        \"templateType\": \"\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"metricCode\": \"$quota_rate_wac_wrate\",\n" +
                "        \"metricName\": \"$quotaName(费率)周累计环比\",\n" +
                "        \"comment\": \"$quotaName(费率)周累计环比\",\n" +
                "        \"metricType\": \"3\",\n" +
                "        \"metricChildType\": \"302\",\n" +
                "        \"metricFormula\": \"\",\n" +
                "        \"templateCode\": \"wrate\",\n" +
                "        \"templateType\": \"2\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"metricCode\": \"$quota_rate_mac\",\n" +
                "        \"metricName\": \"$quotaName(费率)月累计\",\n" +
                "        \"comment\": \"$quotaName(费率)月累计\",\n" +
                "        \"metricType\": \"3\",\n" +
                "        \"metricChildType\": \"301\",\n" +
                "        \"metricFormula\": \"{\\\"metric\\\":\\\"$quota_mac\\\"}/{\\\"metric\\\":\\\"retail_sale_total_mac\\\"}\",\n" +
                "        \"templateCode\": \"mac\",\n" +
                "        \"templateType\": \"\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"metricCode\": \"$quota_rate_mac_mrate\",\n" +
                "        \"metricName\": \"$quotaName(费率)月累计环比\",\n" +
                "        \"comment\": \"$quotaName(费率)月累计环比\",\n" +
                "        \"metricType\": \"3\",\n" +
                "        \"metricChildType\": \"302\",\n" +
                "        \"metricFormula\": \"\",\n" +
                "        \"templateCode\": \"mrate\",\n" +
                "        \"templateType\": \"2\"\n" +
                "    }\n" +
                "]";

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, new TypeReference<List<JsonRootBean>>() {});
    }


    public static String readFile(String fileName) {
        StringBuilder content = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return content.toString();
    }

    public static Map<String, List<String>> parseTextToMap(String text) {
        Map<String, List<String>> map = new HashMap<>();
        String[] lines = text.split("\n");
        String currentKey = null;

        for (String line : lines) {
            if (!line.startsWith("    ")) { // Line is a key
                currentKey = line.trim();
                map.put(currentKey, new ArrayList<>());
            } else if (currentKey != null) { // Line is a value
                map.get(currentKey).add(line.trim());
            }
        }

        return map;
    }

    public static List<String> getQuotasByEtlName(String name) {
        String fileName = "D:\\Program\\IdeaProjects\\java_demo\\src\\main\\resources\\text.txt";
        String text = readFile(fileName);
        if (text != null) {
            Map<String, List<String>> resultMap = parseTextToMap(text);
            return resultMap.get(name);
        } else {
            return new ArrayList<>();
        }
    }
}
