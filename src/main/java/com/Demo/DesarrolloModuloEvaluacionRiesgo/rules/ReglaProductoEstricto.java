package com.Demo.DesarrolloModuloEvaluacionRiesgo.rules;

import com.Demo.DesarrolloModuloEvaluacionRiesgo.dto.Respuesta;
import com.Demo.DesarrolloModuloEvaluacionRiesgo.dto.ResultadoRegla;
import com.Demo.DesarrolloModuloEvaluacionRiesgo.model.ProductoFinanciero;
import com.Demo.DesarrolloModuloEvaluacionRiesgo.provider.DatosContablesProvider;
import com.Demo.DesarrolloModuloEvaluacionRiesgo.provider.HistorialPagosProvider;
import com.Demo.DesarrolloModuloEvaluacionRiesgo.provider.VerificacionLegalProvider;

public class ReglaProductoEstricto implements ReglaEvaluacion {

    @Override
    public ResultadoRegla evaluar(Respuesta request,
                                  DatosContablesProvider contables,
                                  HistorialPagosProvider pagos,
                                  VerificacionLegalProvider legal) {
        boolean esArrendamiento = request.getProductoFinanciero() == ProductoFinanciero.ARRENDAMIENTO_FINANCIERO;
        return new ResultadoRegla(
            "Producto Estricto",
            !esArrendamiento,
            esArrendamiento ? "ALTO" : "NINGUNO"
        );
    }


}
