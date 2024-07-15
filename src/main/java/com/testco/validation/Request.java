package com.testco.validation;

import java.util.ArrayList;
import java.util.List;

public class Request {
    List<Item> items;
    public Request(List<Item> items){
        this.items = items;//initailise using request body by parsing JSON
    }

    public List<Item> getItems(){
        return this.items;
    }
}
