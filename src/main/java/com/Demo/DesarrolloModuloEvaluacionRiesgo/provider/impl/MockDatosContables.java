package com.Demo.DesarrolloModuloEvaluacionRiesgo.provider.impl;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.Demo.DesarrolloModuloEvaluacionRiesgo.provider.DatosContablesProvider;

@Component
public class MockDatosContables implements DatosContablesProvider {

      @Override
    public BigDecimal obtenerVentasPromedio(String empresaId) {
        return new BigDecimal("50000");
    }

    @Override
    public BigDecimal obtenerPasivos(String empresaId) {
        return new BigDecimal("20000");
    }

    @Override
    public BigDecimal obtenerActivos(String empresaId) {
        return new BigDecimal("100000");
    }

    @Override
    public LocalDate obtenerFechaConstitucion(String empresaId) {
        return LocalDate.now().minusMonths(24);
    }

    
}
