package com.Demo.DesarrolloModuloEvaluacionRiesgo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Demo.DesarrolloModuloEvaluacionRiesgo.dto.Respuesta;
import com.Demo.DesarrolloModuloEvaluacionRiesgo.dto.Resultado;
import com.Demo.DesarrolloModuloEvaluacionRiesgo.service.OrdenarRiskEngine;

@RestController
@RequestMapping("/api/riesgo")
public class RiesgodeEvaluacion {
    
    private final OrdenarRiskEngine riesgoEngine;
    public RiesgodeEvaluacion(OrdenarRiskEngine riesgoEngine){

        this.riesgoEngine = riesgoEngine;
    }

    @PostMapping
    public ResponseEntity<Resultado> evaluar(@RequestBody Respuesta respuesta){
        Resultado resultado = riesgoEngine.evaluar(respuesta);
        return ResponseEntity.ok(resultado);

    }
}
