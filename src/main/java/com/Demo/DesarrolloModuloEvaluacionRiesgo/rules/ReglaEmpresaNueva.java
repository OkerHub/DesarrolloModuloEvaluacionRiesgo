package com.Demo.DesarrolloModuloEvaluacionRiesgo.rules;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import com.Demo.DesarrolloModuloEvaluacionRiesgo.dto.Respuesta;
import com.Demo.DesarrolloModuloEvaluacionRiesgo.dto.ResultadoRegla;
import com.Demo.DesarrolloModuloEvaluacionRiesgo.provider.DatosContablesProvider;
import com.Demo.DesarrolloModuloEvaluacionRiesgo.provider.HistorialPagosProvider;
import com.Demo.DesarrolloModuloEvaluacionRiesgo.provider.VerificacionLegalProvider;

public class ReglaEmpresaNueva implements ReglaEvaluacion{

    @Override
    public ResultadoRegla evaluar(Respuesta request, DatosContablesProvider contables,
                                  HistorialPagosProvider pagos, VerificacionLegalProvider legal) {
        LocalDate fechaConstitucion = contables.obtenerFechaConstitucion(request.getEmpresaId());
        long meses = ChronoUnit.MONTHS.between(fechaConstitucion, request.getFechasolicitud());
        boolean esNueva = meses < 18;
        return new ResultadoRegla("Empresa Nueva", true, esNueva ? "MEDIO" : "NINGUNO");
    
    }

}



