package com.Demo.DesarrolloModuloEvaluacionRiesgo.rules;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.Demo.DesarrolloModuloEvaluacionRiesgo.dto.Respuesta;
import com.Demo.DesarrolloModuloEvaluacionRiesgo.dto.ResultadoRegla;
import com.Demo.DesarrolloModuloEvaluacionRiesgo.provider.DatosContablesProvider;
import com.Demo.DesarrolloModuloEvaluacionRiesgo.provider.HistorialPagosProvider;
import com.Demo.DesarrolloModuloEvaluacionRiesgo.provider.VerificacionLegalProvider;

@Component
public class ReglaMontoVsVentas implements ReglaEvaluacion {

    @Override
    public ResultadoRegla evaluar(Respuesta request, DatosContablesProvider contables,
                                  HistorialPagosProvider pagos, VerificacionLegalProvider legal) {
        BigDecimal ventas = contables.obtenerVentasPromedio(request.getEmpresaId());
        boolean excede = request.getMontoSolicitado().compareTo(ventas.multiply(BigDecimal.valueOf(8))) > 0;
        return new ResultadoRegla("Alta Solicitud vs Ventas", !excede, excede ? "ALTO" : "NINGUNO");

        }

        
}
