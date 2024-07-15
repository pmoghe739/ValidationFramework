package com.testco.validation;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BulkBuyLimitValidatorTest {


    //TODO : make code more reusable.
    @Test
    public void testValidateBulkBuyLimitSuccess(){
        List<Item> items = new ArrayList<>();
        Item item1 = new Item("p1","paracetamol",1);
        Item item2 = new Item("p2","fridge",5);
        BulkBuyLimitValidator bulkBuyLimitValidator = new BulkBuyLimitValidator();
        items.add(item1);
        items.add(item2);
        for(ValidationResponse response :bulkBuyLimitValidator.validate(items) ){
            Assert.assertTrue(response.success);
        }
    }

    @Test
    public void testValidateBulkBuyLimitFail(){
        List<Item> items = new ArrayList<>();
        Item item1 = new Item("p1","paracetamol",1);
        Item item2 = new Item("p2","fridge",5);
        Item item3 = new Item("p3","magnet",15);
        Set<String> failureIds = new HashSet<>();
        failureIds.add("p3");
        BulkBuyLimitValidator bulkBuyLimitValidator = new BulkBuyLimitValidator();
        items.add(item1);
        items.add(item2);
        items.add(item3);
//        Assert.assertFalse(bulkBuyLimitValidator.validate(items).success);
        for(ValidationResponse response :bulkBuyLimitValidator.validate(items) ){
            if(failureIds.contains(response.productId)){
                Assert.assertFalse(response.success);
            } else {
                Assert.assertTrue(response.success);
            }
        }
    }
}
