package com.Demo.DesarrolloModuloEvaluacionRiesgo.rules;

import org.springframework.stereotype.Component;

import com.Demo.DesarrolloModuloEvaluacionRiesgo.dto.Respuesta;
import com.Demo.DesarrolloModuloEvaluacionRiesgo.dto.ResultadoRegla;
import com.Demo.DesarrolloModuloEvaluacionRiesgo.provider.DatosContablesProvider;
import com.Demo.DesarrolloModuloEvaluacionRiesgo.provider.HistorialPagosProvider;
import com.Demo.DesarrolloModuloEvaluacionRiesgo.provider.VerificacionLegalProvider;

@Component
public class ReglaHistorialExcelente implements ReglaEvaluacion {

     @Override
    public ResultadoRegla evaluar(Respuesta request, DatosContablesProvider contables,
                                  HistorialPagosProvider pagos, VerificacionLegalProvider legal) {

      boolean excelente = pagos.tieneExcelenteHistorial(request.getEmpresaId());
        return new ResultadoRegla("Historial Excelente", excelente, excelente ? "BAJO" : "NINGUNO");
    }
}
