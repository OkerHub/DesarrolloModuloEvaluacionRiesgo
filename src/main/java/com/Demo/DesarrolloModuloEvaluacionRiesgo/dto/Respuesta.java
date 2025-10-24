package com.Demo.DesarrolloModuloEvaluacionRiesgo.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.Demo.DesarrolloModuloEvaluacionRiesgo.model.ProductoFinanciero;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class Respuesta {

    private String empresaId;
    private BigDecimal montoSolicitado;
    private ProductoFinanciero productoFinanciero;
    private LocalDate fechasolicitud;

}
