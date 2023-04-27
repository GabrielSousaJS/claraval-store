package com.gabrielsantos.backend.services;

import com.gabrielsantos.backend.dto.PaymentDTO;
import com.gabrielsantos.backend.entities.Payment;
import com.gabrielsantos.backend.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository repository;

    public PaymentDTO savePayment(PaymentDTO dto) {
        Payment entity = new Payment();
        copyDtoToEntity(entity, dto);
        entity = repository.save(entity);
        return new PaymentDTO(entity);
    }

    private void copyDtoToEntity(Payment entity, PaymentDTO dto) {
        entity.setMoment(dto.getMoment());
        entity.setPaymentMethod(dto.getPaymentMethod());
    }

}
