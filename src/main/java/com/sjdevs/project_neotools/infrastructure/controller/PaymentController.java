package com.sjdevs.project_neotools.infrastructure.controller;

import com.sjdevs.project_neotools.application.service.PaymentService;
import com.sjdevs.project_neotools.application.dto.PaymentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/pagos")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping
    public ResponseEntity<List<PaymentDTO>> getAllPayments() {
        return ResponseEntity.ok(paymentService.getAllPayments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentDTO> getPaymentById(@PathVariable Long id) {
        return ResponseEntity.ok(paymentService.getPaymentById(id));
    }

    @PostMapping
    public ResponseEntity<PaymentDTO> createPayment(@RequestBody PaymentDTO paymentDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(paymentService.saveOrUpdatePayment(paymentDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PaymentDTO> updatePayment(@PathVariable Long id, @RequestBody PaymentDTO paymentDTO) {
        paymentDTO.setId(id);
        return ResponseEntity.ok(paymentService.saveOrUpdatePayment(paymentDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePayment(@PathVariable Long id) {
        paymentService.deletePayment(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/reserva/{reservaId}")
    public ResponseEntity<List<PaymentDTO>> getPaymentsByReserva(@PathVariable Long reservaId) {
        return ResponseEntity.ok(paymentService.getPaymentsByReserva(reservaId));
    }

    @GetMapping("/estado/{estadoId}")
    public ResponseEntity<List<PaymentDTO>> getPaymentsByEstado(@PathVariable Long estadoId) {
        return ResponseEntity.ok(paymentService.getPaymentsByEstado(estadoId));
    }
}
