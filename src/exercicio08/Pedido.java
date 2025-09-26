package exercicio08;

import java.math.BigDecimal;

public class Pedido {
    private String cepDestino;
    private BigDecimal valorPedido;
    private CalculadoraFrete calculadoraFrete;

    public Pedido(String cepDestino, BigDecimal valorPedido, CalculadoraFrete calculadoraFrete) {
        this.cepDestino = cepDestino;
        this.valorPedido = valorPedido;
        this.calculadoraFrete = calculadoraFrete;
    }

    public String getCepDestino() {
        return cepDestino;
    }

    public BigDecimal getValorPedido() {
        return valorPedido;
    }

    public void setCalculadoraFrete(CalculadoraFrete calculadoraFrete) {
        this.calculadoraFrete = calculadoraFrete;
    }

    public BigDecimal calcularFrete() throws CepInvalidoException {
        return calculadoraFrete.calcular(this);
    }
}
