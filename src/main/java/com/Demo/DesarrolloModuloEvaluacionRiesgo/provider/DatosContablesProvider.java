package com.Demo.DesarrolloModuloEvaluacionRiesgo.provider;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface DatosContablesProvider {
    
    BigDecimal obtenerVentasPromedio(String empresaId);
    BigDecimal obtenerPasivos(String empresaId);
    BigDecimal obtenerActivos(String empresaId);
    LocalDate  obtenerFechaConstitucion(String empresaId);

}
