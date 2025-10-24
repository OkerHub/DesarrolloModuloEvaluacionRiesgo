package com.Demo.DesarrolloModuloEvaluacionRiesgo.rules;

import com.Demo.DesarrolloModuloEvaluacionRiesgo.dto.Respuesta;
import com.Demo.DesarrolloModuloEvaluacionRiesgo.dto.ResultadoRegla;
import com.Demo.DesarrolloModuloEvaluacionRiesgo.provider.DatosContablesProvider;
import com.Demo.DesarrolloModuloEvaluacionRiesgo.provider.HistorialPagosProvider;
import com.Demo.DesarrolloModuloEvaluacionRiesgo.provider.VerificacionLegalProvider;

public class ReglaDeudaActiva implements ReglaEvaluacion{

     @Override
    public ResultadoRegla evaluar(Respuesta request,
                                  DatosContablesProvider contables,
                                  HistorialPagosProvider pagos,
                                  VerificacionLegalProvider legal) {
        boolean tieneDeudaVencida = pagos.tieneDeudaVencidaMayor90Dias(request.getEmpresaId());
        return new ResultadoRegla(
            "Deuda Activa",
            !tieneDeudaVencida,
            tieneDeudaVencida ? "RECHAZADO" : "NINGUNO"
        );
    }


}
