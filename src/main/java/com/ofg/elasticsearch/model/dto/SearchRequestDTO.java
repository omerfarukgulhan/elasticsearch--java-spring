package com.ofg.elasticsearch.model.dto;

import java.util.List;

public class SearchRequestDTO {
    private List<String> fieldName;
    private List<String> searchValue;

    public SearchRequestDTO(List<String> fieldName, List<String> searchValue) {
        this.fieldName = fieldName;
        this.searchValue = searchValue;
    }

    public SearchRequestDTO() {
    }

    public List<String> getFieldName() {
        return fieldName;
    }

    public void setFieldName(List<String> fieldName) {
        this.fieldName = fieldName;
    }

    public List<String> getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(List<String> searchValue) {
        this.searchValue = searchValue;
    }
}