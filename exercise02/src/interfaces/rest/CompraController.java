package exercise02.src.interfaces.rest;

import java.util.HashMap;
import java.util.Map;

import exercise02.src.application.CalcularTotalUseCase;

public class CompraController {
    private CalcularTotalUseCase calcularTotalUseCase;

    public CompraController(CalcularTotalUseCase calcularTotalUseCase) {
        this.calcularTotalUseCase = calcularTotalUseCase;
    }

    public Map<String, Object> calcularTotal(Map<String, Object> request) {
        try {
            Double valor = (Double) request.get("valor");
            String tipoCliente = (String) request.get("tipo_cliente");

            Double total = calcularTotalUseCase.executar(valor, tipoCliente);
        
            Map<String, Object> response = new HashMap<>();
            response.put("valor_original", valor);
            response.put("tipo_cliente", tipoCliente);
            response.put("valor_final", Math.round(total * 100.0) / 100.0);
            response.put("status_code", 200);
            
            return response;
        } catch (Exception e) {
            Map<String, Object> erro = new HashMap<>();
            erro.put("erro", e.getMessage());
            erro.put("status_code", 500);
            return erro;
        }        
    }
}
