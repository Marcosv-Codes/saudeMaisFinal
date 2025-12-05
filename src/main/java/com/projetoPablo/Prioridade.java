package com.projetoPablo;

public enum Prioridade {
    VERDE(3),
    AMARELA(2),
    VERMELHA(1);

    private int nivel;

    Prioridade(int nivel) {
        this.nivel = nivel;
    }

    public int getNivel() {
        return nivel;
    }
}