package com.testco.validation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Cannot buy more than 5 Quantity of paracetamol products
 */
public class BulkBuyLimitCategoryValidator implements Validator{
    Map<String, Integer> categoryLimitation;
    public BulkBuyLimitCategoryValidator(){
        //can make this configurable based on argument.right now hardcoded.
        categoryLimitation = new HashMap<>();
        categoryLimitation.put("paracetamol", 5);
    }
    @Override
    public List<ValidationResponse> validate(List<Item> items) {
        List<ValidationResponse> responses = new ArrayList<>();
        Map<String, Integer> categoryCounts = new HashMap<>();
        for(Item item: items){
                categoryCounts.put(item.getCategory(),
                        categoryCounts.getOrDefault(item.getCategory(), 0)+item.getQuantity());
        }
        for(Item item: items){
            ValidationResponse response = new ValidationResponse();
            if(categoryLimitation.containsKey(item.getCategory()) &&
                    categoryCounts.get(item.getCategory()) > categoryLimitation.get(item.getCategory())
        ){
                response.success = false;
                response.message = "Validation failed because of limit breach on "+item.getCategory();
            } else{
                response.success = false;
                response.message = "";
            }
            responses.add(response);
        }
        return responses;
    }
}
