package exercise02.src.application;

import exercise02.src.domain.Compra;
import exercise02.src.domain.CompraRepository;

public class CalcularTotalUseCase {
    private CompraRepository repository;
    
    public CalcularTotalUseCase(CompraRepository repository) {
        this.repository = repository;
    }

    public Double executar(Double valor, String tipoCliente) {
        Compra compra = new Compra(valor, tipoCliente);

        Double descontoVip = repository.getDescontoVip();
        Double descontoAdicional = repository.getDescontoAdicional();
        Double valorMinimo = repository.getValorMinimo();

        return compra.calcularDesconto(descontoVip, descontoAdicional, valorMinimo);
    }
}
