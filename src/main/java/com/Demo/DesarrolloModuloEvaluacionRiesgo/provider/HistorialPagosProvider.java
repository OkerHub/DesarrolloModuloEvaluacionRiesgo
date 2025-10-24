package com.Demo.DesarrolloModuloEvaluacionRiesgo.provider;

public interface HistorialPagosProvider {

    boolean tieneDeudaVencidaMayor90Dias(String empresaId);
    boolean tieneExcelenteHistorial(String empresaId);
    

}
