package com.testco.validation;

import java.util.List;

public interface Validator {
    public List<ValidationResponse> validate(List<Item> items);
}
