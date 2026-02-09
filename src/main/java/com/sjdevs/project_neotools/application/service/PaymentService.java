package com.sjdevs.project_neotools.application.service;

import com.sjdevs.project_neotools.application.mapper.PaymentMapper;
import com.sjdevs.project_neotools.application.dto.PaymentDTO;
import com.sjdevs.project_neotools.domain.model.Payment;
import com.sjdevs.project_neotools.infrastructure.persistence.repository.JpaPaymentRepository;
import com.sjdevs.project_neotools.domain.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentService {

    @Autowired
    private JpaPaymentRepository paymentRepository;

    public List<PaymentDTO> getAllPayments() {
        return paymentRepository.findAll().stream()
                .map(PaymentMapper::toDomain)
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public PaymentDTO getPaymentById(Long id) {
        return paymentRepository.findById(id)
                .map(PaymentMapper::toDomain)
                .map(this::toDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Payment not found with id: " + id));
    }

    public PaymentDTO saveOrUpdatePayment(PaymentDTO paymentDTO) {
        Payment payment = fromDTO(paymentDTO);
        return toDTO(PaymentMapper.toDomain(paymentRepository.save(PaymentMapper.toEntity(payment))));
    }

    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);
    }

    public List<PaymentDTO> getPaymentsByReserva(Long reservaId) {
        return paymentRepository.findByReservaId(reservaId).stream()
                .map(PaymentMapper::toDomain)
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public List<PaymentDTO> getPaymentsByEstado(Long estadoId) {
        return paymentRepository.findByEstadoPagoId(estadoId).stream()
                .map(PaymentMapper::toDomain)
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    private PaymentDTO toDTO(Payment payment) {
        if (payment == null) return null;
        PaymentDTO dto = new PaymentDTO();
        dto.setId(payment.getId());
        dto.setReservaId(payment.getReservaId());
        dto.setConcepto(payment.getConcepto());
        dto.setMonto(payment.getMonto());
        dto.setFechaPago(payment.getFechaPago());
        dto.setEstadoPagoId(payment.getEstadoPagoId());
        return dto;
    }

    private Payment fromDTO(PaymentDTO dto) {
        if (dto == null) return null;
        return new Payment(dto.getId(), dto.getReservaId(), dto.getConcepto(), dto.getMonto(), 
                dto.getFechaPago(), dto.getEstadoPagoId());
    }
}
