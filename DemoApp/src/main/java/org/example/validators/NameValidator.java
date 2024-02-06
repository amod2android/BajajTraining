package org.example.validators;

public class NameValidator implements TextValidator{

    @Override
    public boolean validate(String name) {
        return !name.isEmpty();
    }
}
