package br.com.suplementscommerce.repository.entities.enums;

public enum StatusPedido {

    AGUARDANDO_PAGAMENTO(1),

    PAGO(2),
    ENVIADO(3),
    EM_TRÂNSITO(4),
    CANCELADO(5);
    private int codigo;

    private StatusPedido(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo(){
        return codigo;
    }

    public static StatusPedido valueOf(int codigo){
        for (StatusPedido value : StatusPedido.values()){
            if(value.getCodigo() == codigo){
                return value;
            }
        }
        throw new IllegalArgumentException("Código do Status de Pedido Inválido");
    }
}
