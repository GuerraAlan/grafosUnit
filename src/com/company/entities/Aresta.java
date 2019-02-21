package com.company.entities;

import java.util.NoSuchElementException;

//linha
public class Aresta {
    private Vertice v1, v2;
    private int peso;
    private int direcao;
    private boolean visitada;

    public Aresta(Vertice v1, Vertice v2) {
        this.v1 = v1;
        this.v2 = v2;
        v1.addAresta(this);
        v2.addAresta(this);
        this.visitada = false;
    }

    public Aresta(Vertice v1, Vertice v2, int peso) {
        this(v1, v2);
        this.peso = peso;
    }

    public Aresta(Vertice v1, Vertice v2, int peso, int direcao) {
        this(v1, v2, peso);
        this.direcao = direcao;
    }

    public Vertice[] getVertices() {
        Vertice[] vs = {v2, v1};
        return vs;
    }

    public Vertice getOtherVertice(Vertice base){
        if (base.getId() == v1.getId()){
            return v2;
        }
        if (base.getId() == v2.getId()){
            return v1;
        }
        throw new NoSuchElementException("Vertice "+ base.getId() + " não encontrado na aresta");
    }

    public int getPeso() {
        return this.peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getDirecao() {
        return this.direcao;
    }

    public void setDirecao(int direcao) {
        this.direcao = direcao;
    }

    public boolean getVisitada(){
        return this.visitada;
    }

    public void setVisitada(boolean visitada){
        this.visitada = visitada;
    }

    public String getIdAresta(){
        return new StringBuilder().append('v').append(v1.getId()).append('v').append(v2.getId()).toString();
    }
}
