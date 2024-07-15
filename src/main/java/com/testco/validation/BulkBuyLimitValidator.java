package com.testco.validation;

import java.util.ArrayList;
import java.util.List;

/*
Cannot buy more than 10 Quantity of any products
 */
public class BulkBuyLimitValidator implements Validator {

    private  static final int  MAX_QUANTITY = 10;
    @Override
    public List<ValidationResponse> validate(List<Item> items) {
       List <ValidationResponse> validationResponses =new ArrayList<>();
        for(Item item: items){
            if(item.getQuantity() > MAX_QUANTITY) {
                ValidationResponse validationResponse = new ValidationResponse();
                validationResponse.success = false;
                validationResponse.message = "Validation failed for category "+ item.getCategory() +
                        "and product "+ item.getProductId();
                validationResponse.productId = item.getProductId();
            } else{
                ValidationResponse validationResponse = new ValidationResponse();
                validationResponse.success = true;
                validationResponse.message = "Validation failed for category "+ item.getCategory() +
                        "and product "+ item.getProductId();
                validationResponse.productId = item.getProductId();
            }
        }
        return validationResponses;
    }
}
