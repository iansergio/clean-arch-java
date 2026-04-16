package domain;

public class Frete {
    private Double peso;
    private Double distancia;
    private String tipoCliente;

    public Frete() {
    }

    public Frete(Double peso, Double distancia, String tipoCliente) {
        if (peso == null || peso <= 0) {
            throw new IllegalArgumentException("Peso não pode ser null ou menor/igual a 0");
        }

        if (distancia == null || distancia <= 0) {
            throw new IllegalArgumentException("Distância não pode ser null ou menor/igual a 0");
        }

        if (tipoCliente == null || tipoCliente.isEmpty()) {
            throw new IllegalArgumentException("Tipo do cliente não pode ser null ou vazio");
        }

        if (!tipoCliente.equalsIgnoreCase("NORMAL") && !tipoCliente.equalsIgnoreCase("VIP")) {
            throw new IllegalArgumentException("Tipo do cliente inválido. Tente 'NORMAL' ou 'VIP'");
        }

        this.peso = peso;
        this.distancia = distancia;
        this.tipoCliente = tipoCliente;
    }

    private Double calcularDesconto(Double valorTotal) {
        if ("VIP".equalsIgnoreCase(tipoCliente)) {
            return valorTotal * 0.8;
        }
        return valorTotal;
    }

    private Double calcularFreteMinimo(Double valorTotal) {
        if (valorTotal < 15.0) {
            return 15.0;
        }
        return valorTotal;
    }

    public Double calcularValorTotal() {
        Double valorBase = 10.0;
        Double valorPeso = (peso <= 1) ? 5.0 : (peso <= 5) ? 10.0 : 20.0;
        Double valorDistancia = distancia * 0.5;

        Double valorTotal = valorBase + valorPeso + valorDistancia;
        Double valorTotalFInal = calcularFreteMinimo(calcularDesconto(valorTotal));

        return Math.round(valorTotalFInal * 100.0) / 100.0;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getDistancia() {
        return distancia;
    }

    public void setDistancia(Double distancia) {
        this.distancia = distancia;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }
}