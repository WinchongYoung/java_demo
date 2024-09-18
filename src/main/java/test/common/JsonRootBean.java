/**
  * Copyright 2024 bejson.com 
  */
package test.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Auto-generated: 2024-07-05 16:49:34
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JsonRootBean {

    private String metricCode;
    private String metricName;
    private String comment;
    private String metricType;
    private String metricChildType;
    private String metricFormula;
    private String templateCode;
    private String templateType;
    public void setMetricCode(String metricCode) {
         this.metricCode = metricCode;
     }
     public String getMetricCode() {
         return metricCode;
     }

    public void setMetricName(String metricName) {
         this.metricName = metricName;
     }
     public String getMetricName() {
         return metricName;
     }

    public void setComment(String comment) {
         this.comment = comment;
     }
     public String getComment() {
         return comment;
     }

    public void setMetricType(String metricType) {
         this.metricType = metricType;
     }
     public String getMetricType() {
         return metricType;
     }

    public void setMetricChildType(String metricChildType) {
         this.metricChildType = metricChildType;
     }
     public String getMetricChildType() {
         return metricChildType;
     }

    public void setMetricFormula(String metricFormula) {
         this.metricFormula = metricFormula;
     }
     public String getMetricFormula() {
         return metricFormula;
     }

    public void setTemplateCode(String templateCode) {
         this.templateCode = templateCode;
     }
     public String getTemplateCode() {
         return templateCode;
     }

    public void setTemplateType(String templateType) {
         this.templateType = templateType;
     }
     public String getTemplateType() {
         return templateType;
     }

}