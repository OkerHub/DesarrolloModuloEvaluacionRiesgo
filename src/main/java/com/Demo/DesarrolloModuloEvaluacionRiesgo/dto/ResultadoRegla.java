package com.Demo.DesarrolloModuloEvaluacionRiesgo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultadoRegla {

    private String nombreRegla;
    private boolean cumple;
    private String impacto;

}
