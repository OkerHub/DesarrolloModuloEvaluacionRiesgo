package com.Demo.DesarrolloModuloEvaluacionRiesgo.rules;

import com.Demo.DesarrolloModuloEvaluacionRiesgo.dto.Respuesta;
import com.Demo.DesarrolloModuloEvaluacionRiesgo.dto.ResultadoRegla;
import com.Demo.DesarrolloModuloEvaluacionRiesgo.provider.DatosContablesProvider;
import com.Demo.DesarrolloModuloEvaluacionRiesgo.provider.HistorialPagosProvider;
import com.Demo.DesarrolloModuloEvaluacionRiesgo.provider.VerificacionLegalProvider;

public interface ReglaEvaluacion {

    ResultadoRegla evaluar(Respuesta respuesta, DatosContablesProvider contables,
    HistorialPagosProvider pagos, VerificacionLegalProvider legal);

}
