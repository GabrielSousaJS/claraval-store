package com.gabrielsantos.backend.services.validation;

import com.gabrielsantos.backend.dto.UserInsertDTO;
import com.gabrielsantos.backend.entities.User;
import com.gabrielsantos.backend.repositories.UserRepository;
import com.gabrielsantos.backend.controllers.exceptions.FieldMessage;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class UserInsertValidator implements ConstraintValidator<UserInsertValid, UserInsertDTO> {

    @Autowired
    private UserRepository repository;

    @Override
    public void initialize(UserInsertValid annotation) {
    }

    @Override
    public boolean isValid(UserInsertDTO dto, ConstraintValidatorContext context) {

        List<FieldMessage> list = new ArrayList<>();

        User entity = repository.findByEmail(dto.getEmail());

        if (entity != null) {
            list.add(new FieldMessage("email", "Este email já está registrado"));
        }

        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldError())
                    .addConstraintViolation();
        }

        return list.isEmpty();
    }
}
