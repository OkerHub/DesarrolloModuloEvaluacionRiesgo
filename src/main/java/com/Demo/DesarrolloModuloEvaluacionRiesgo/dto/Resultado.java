package com.Demo.DesarrolloModuloEvaluacionRiesgo.dto;

import java.util.List;

import com.Demo.DesarrolloModuloEvaluacionRiesgo.model.RiskLevel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Resultado {

    private RiskLevel nivelRiesgo;
    private List<ResultadoRegla> reglasEvauladas;
    private String motivoFinal;

}
