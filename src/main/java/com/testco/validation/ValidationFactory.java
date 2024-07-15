package com.testco.validation;

import java.util.List;

public class ValidationFactory {
    static List<Validator> validators;
    public ValidationFactory(){
        validators.add(new BulkBuyLimitCategoryValidator());
        validators.add(new BulkBuyLimitValidator());
    }
    public static List<Validator> getValidators(){
        return validators;
    }
}
