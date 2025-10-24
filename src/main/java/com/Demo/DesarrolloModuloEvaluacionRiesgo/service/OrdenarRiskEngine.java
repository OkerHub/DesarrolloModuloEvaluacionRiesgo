package com.Demo.DesarrolloModuloEvaluacionRiesgo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.Demo.DesarrolloModuloEvaluacionRiesgo.dto.Respuesta;
import com.Demo.DesarrolloModuloEvaluacionRiesgo.dto.Resultado;
import com.Demo.DesarrolloModuloEvaluacionRiesgo.dto.ResultadoRegla;
import com.Demo.DesarrolloModuloEvaluacionRiesgo.model.RiskLevel;
import com.Demo.DesarrolloModuloEvaluacionRiesgo.provider.DatosContablesProvider;
import com.Demo.DesarrolloModuloEvaluacionRiesgo.provider.HistorialPagosProvider;
import com.Demo.DesarrolloModuloEvaluacionRiesgo.provider.VerificacionLegalProvider;
import com.Demo.DesarrolloModuloEvaluacionRiesgo.rules.ReglaEvaluacion;

@Service
public class OrdenarRiskEngine {

    private final List<ReglaEvaluacion> reglas;
    private final DatosContablesProvider contables;
    private final HistorialPagosProvider pagos;
    private final VerificacionLegalProvider legal;

    public OrdenarRiskEngine(List<ReglaEvaluacion> reglas, DatosContablesProvider contables,
                            HistorialPagosProvider pagos, VerificacionLegalProvider legal){
                            
        this.reglas = reglas;
        this.contables = contables;
        this.pagos = pagos;
        this.legal = legal; 

    }

    public Resultado evaluar(Respuesta respuesta){
        List<ResultadoRegla> resultados = new ArrayList<>();
        RiskLevel nivel =RiskLevel.BAJO;

        for(ReglaEvaluacion regla : reglas){
            ResultadoRegla resultado = regla.evaluar(respuesta, contables, pagos, legal);
            resultados.add(resultado);

            switch (resultado.getImpacto()){
                case "RECHAZADO": return new Resultado(RiskLevel.RECHAZADO, resultados, "Deuda Activa");
                case "ALTO": nivel =RiskLevel.ALTO; break;
                case "MEDIO": if(nivel == RiskLevel.BAJO) nivel = RiskLevel.MEDIO; break;
                case "BAJO": if(nivel == RiskLevel.ALTO) nivel = RiskLevel.MEDIO;
                        else if(nivel == RiskLevel.MEDIO) nivel = RiskLevel.BAJO; break;
            }

        }

        return new Resultado(nivel, resultados, "Evaluacion Compuesta");
    }

}
