package com.nfscauxiliary.models.enums;

public enum InvoiceStatus {
    AUTORIZADA(1),
    CANCELADA(2),
    EM_PROCESSO(3),
    REJEITADA(4),
    INUTILIZADA(5),
    DENEGADA(6),
    PENDENTE(7);
    
    private final int code;
    
    InvoiceStatus(int code) {
        this.code = code;
    }
}
