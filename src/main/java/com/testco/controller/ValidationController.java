package com.testco.controller;


import com.testco.validation.*;

import java.util.ArrayList;
import java.util.List;

public class ValidationController {


    public Response validateCartController(Request request){
        List<Item> items= request.getItems();
        List<Validator> validators = ValidationFactory.getValidators();
        Boolean isConditionsMet = true;
        List<ValidationResponse> validationResponses = new ArrayList<>();
        for(Validator validationClass: validators){
            validationResponses.addAll(validationClass.validate(items));
        }
        for(ValidationResponse resp : validationResponses){
            if(!resp.success){
                isConditionsMet = false;
            }
        }
        Response response = new Response();
        response.validationResponses = validationResponses;
        response.success = isConditionsMet;
        return response;
    }
}
