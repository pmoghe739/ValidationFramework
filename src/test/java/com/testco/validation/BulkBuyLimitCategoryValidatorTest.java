package com.testco.validation;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

//todo: make code reusable .
public class BulkBuyLimitCategoryValidatorTest {
    @Test
    public void testValidateBulkBuyCategorySuccess(){
        List<Item> items = new ArrayList<>();
        Item item1 = new Item("p1", "paracetamol",5);
        Item item2 = new Item("p2", "magnet", 6);
        items.add(item1);
        items.add(item2);
        BulkBuyLimitCategoryValidator bulkBuyLimitCategoryValidator = new BulkBuyLimitCategoryValidator();
//        Assert.assertTrue(bulkBuyLimitCategoryValidator.validate((items)).success);
    }
    @Test
    public void testValidateBulkBuyCategoryFail(){
        List<Item> items = new ArrayList<>();
        Item item1 = new Item("p1", "paracetamol",5);
        Item item2 = new Item("p2", "magnet", 6);
        Item item3 = new Item("p3", "paracetamol", 6);
        items.add(item1);
        items.add(item2);
        items.add(item3);
        BulkBuyLimitCategoryValidator bulkBuyLimitCategoryValidator = new BulkBuyLimitCategoryValidator();
//        Assert.assertFalse(bulkBuyLimitCategoryValidator.validate((items)).success);
    }
}
