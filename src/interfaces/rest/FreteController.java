package interfaces.rest;

import java.util.HashMap;
import java.util.Map;

import domain.Frete;

public class FreteController {

    private Frete frete = new Frete();

    public Map<String, Object> calcularFrete(Map<String, Object> request) {
        Double valorTotalFrete = frete.calcularValorTotal();

        try {
            Map<String, Object> response = new HashMap<>();
            response.put("peso", frete.getPeso());
            response.put("distancia", frete.getDistancia());
            response.put("tipo_cliente", frete.getTipoCliente());
            response.put("valor_frete", valorTotalFrete);
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
