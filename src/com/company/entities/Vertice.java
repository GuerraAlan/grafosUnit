package com.company.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//bola
public class Vertice {
    private int id;
    private List<Aresta> arestas;
    private boolean visitado;

    public Vertice(int id){
        this.id = id;
        this.arestas = new ArrayList<>();
        this.visitado = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void addAresta(Aresta aresta){
        this.arestas.add(aresta);
    }

    public List<Aresta> getArestas(){
        return this.arestas;
    }

    public boolean hasCleanAresta(){
        return arestas.parallelStream().filter(a -> !a.getVisitada()).count() > 0;
    }

    public Aresta getCleanAresta(){
        List<Aresta> temp = arestas.parallelStream().filter(a -> !a.getVisitada()).limit(1).collect(Collectors.toList());
        if (temp.isEmpty()){
            return null;
        } else {
            return temp.get(1);
        }
    }
}
