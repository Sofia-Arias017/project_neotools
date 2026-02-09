package com.sjdevs.project_neotools.application.service;

import com.sjdevs.project_neotools.application.mapper.InvoiceMapper;
import com.sjdevs.project_neotools.application.dto.InvoiceDTO;
import com.sjdevs.project_neotools.domain.model.Invoice;
import com.sjdevs.project_neotools.infrastructure.persistence.repository.JpaInvoiceRepository;
import com.sjdevs.project_neotools.domain.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InvoiceService {

    @Autowired
    private JpaInvoiceRepository invoiceRepository;

    public List<InvoiceDTO> getAllInvoices() {
        return invoiceRepository.findAll().stream()
                .map(InvoiceMapper::toDomain)
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public InvoiceDTO getInvoiceById(Long id) {
        return invoiceRepository.findById(id)
                .map(InvoiceMapper::toDomain)
                .map(this::toDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Invoice not found with id: " + id));
    }

    public InvoiceDTO saveOrUpdateInvoice(InvoiceDTO invoiceDTO) {
        Invoice invoice = fromDTO(invoiceDTO);
        return toDTO(InvoiceMapper.toDomain(invoiceRepository.save(InvoiceMapper.toEntity(invoice))));
    }

    public void deleteInvoice(Long id) {
        invoiceRepository.deleteById(id);
    }

    private InvoiceDTO toDTO(Invoice invoice) {
        if (invoice == null) return null;
        InvoiceDTO dto = new InvoiceDTO();
        dto.setId(invoice.getId());
        dto.setNumeroFactura(invoice.getNumeroFactura());
        dto.setFechaEmision(invoice.getFechaEmision());
        dto.setTotal(invoice.getTotal());
        dto.setPagoId(invoice.getPagoId());
        return dto;
    }

    private Invoice fromDTO(InvoiceDTO dto) {
        if (dto == null) return null;
        return new Invoice(dto.getId(), dto.getNumeroFactura(), dto.getFechaEmision(), 
                dto.getTotal(), dto.getPagoId());
    }
}
