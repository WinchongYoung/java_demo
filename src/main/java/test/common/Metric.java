/**
  * Copyright 2024 bejson.com 
  */
package test.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Metric {

    private String metricCode;
    private String computeFormula;
    private String rollUpDim;
    public void setMetricCode(String metricCode) {
         this.metricCode = metricCode;
     }
     public String getMetricCode() {
         return metricCode;
     }

    public void setComputeFormula(String computeFormula) {
         this.computeFormula = computeFormula;
     }
     public String getComputeFormula() {
         return computeFormula;
     }

    public void setRollUpDim(String rollUpDim) {
         this.rollUpDim = rollUpDim;
     }
     public String getRollUpDim() {
         return rollUpDim;
     }

}