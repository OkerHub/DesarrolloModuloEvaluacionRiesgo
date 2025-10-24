package com.Demo.DesarrolloModuloEvaluacionRiesgo.provider.impl;

import org.springframework.stereotype.Component;

import com.Demo.DesarrolloModuloEvaluacionRiesgo.provider.VerificacionLegalProvider;

@Component
public class MockVerificacionLegal implements VerificacionLegalProvider {

    @Override
    public boolean tieneJuicioMercantilActivo(String empresaId) {
        return false;

    }

}
