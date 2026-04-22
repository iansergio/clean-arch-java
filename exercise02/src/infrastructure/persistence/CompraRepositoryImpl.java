package exercise02.src.infrastructure.persistence;

import exercise02.src.domain.CompraRepository;

public class CompraRepositoryImpl implements CompraRepository{
    
    @Override
    public Double getDescontoVip() {
        return 0.90;
    }

    @Override
    public Double getDescontoAdicional() {
        return 0.95;
    }

    @Override
    public Double getValorMinimo() {
        return 10.0;
    }
}
