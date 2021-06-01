package com.fiap.globalsolution.domain.enums;

public enum Preco {
    BAIXO("Preço em conta"),
    MEDIO("Preço medio"),
    ALTO("Preço alto");

    private String text;

    Preco(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
