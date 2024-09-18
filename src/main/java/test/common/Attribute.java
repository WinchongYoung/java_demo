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
public class Attribute {

    private String attributeCode;
    private String attributeName;
    private int fieldType;
    private int attributeType;

    public void setAttributeCode(String attributeCode) {
        this.attributeCode = attributeCode;
    }

    public String getAttributeCode() {
        return attributeCode;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setFieldType(int fieldType) {
        this.fieldType = fieldType;
    }

    public int getFieldType() {
        return fieldType;
    }

    public void setAttributeType(int attributeType) {
        this.attributeType = attributeType;
    }

    public int getAttributeType() {
        return attributeType;
    }

}