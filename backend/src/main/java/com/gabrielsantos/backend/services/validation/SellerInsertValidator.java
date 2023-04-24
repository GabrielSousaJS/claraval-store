package com.gabrielsantos.backend.services.validation;

import com.gabrielsantos.backend.dto.SellerInsertDTO;
import com.gabrielsantos.backend.entities.User;
import com.gabrielsantos.backend.repositories.UserRepository;
import com.gabrielsantos.backend.resources.exceptions.FieldMessage;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class SellerInsertValidator implements ConstraintValidator<SellerInsertValid, SellerInsertDTO> {

    @Autowired
    private UserRepository repository;

    @Override
    public void initialize(SellerInsertValid constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(SellerInsertDTO dto, ConstraintValidatorContext context) {

        List<FieldMessage> list = new ArrayList<>();

        User entity = repository.findByEmail(dto.getEmail());

        if (entity != null) {
            list.add(new FieldMessage("email", "This email is already registered."));
        }

        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldError())
                    .addConstraintViolation();
        }

        return list.isEmpty();
    }
}