package com.Demo.DesarrolloModuloEvaluacionRiesgo.provider.impl;

import org.springframework.stereotype.Component;

import com.Demo.DesarrolloModuloEvaluacionRiesgo.provider.HistorialPagosProvider;

@Component
public class MockHistorialPagos implements HistorialPagosProvider  {

    @Override
    public boolean tieneDeudaVencidaMayor90Dias(String empresaId) {
        return false;

    }

    @Override
    public boolean tieneExcelenteHistorial(String empresaId) {
       return true;

    }

   
    }

     
    


