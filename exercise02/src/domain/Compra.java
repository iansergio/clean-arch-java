package exercise02.src.domain;

public class Compra {
    private Double valor;
    private String tipoCliente;

    public Compra() {
    }

    public Compra(Double valor, String tipoCliente) {
        if (valor == null || valor <= 0) {
            throw new IllegalArgumentException("Valor não pode ser nulo ou menor ou igual a 0");
        }

        if (tipoCliente == null || tipoCliente.isEmpty()) {
            throw new IllegalArgumentException("Tipo do cliente não pode ser null ou vazio");
        }

        if (!tipoCliente.equalsIgnoreCase("NORMAL") && !tipoCliente.equalsIgnoreCase("VIP")) {
            throw new IllegalArgumentException("Tipo do cliente inválido. Tente 'NORMAL' ou 'VIP'");
        }

        this.valor = valor;
        this.tipoCliente = tipoCliente;
    }

    public Double calcularDesconto(Double descontoVip, Double descontoAdicional, Double valorMinimo) {
        Double valorFinal = this.valor;

        if ("VIP".equals(tipoCliente)) {
            valorFinal *= (1 - descontoVip);
        }

        if (valorFinal > 100.0) {
            valorFinal *= (1 - descontoAdicional);
        }

        if (valorFinal < valorMinimo) {
            valorFinal = valorMinimo;
        }

        return valorFinal;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }
}
