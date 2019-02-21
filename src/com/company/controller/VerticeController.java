package com.company.controller;

import com.company.entities.Aresta;
import com.company.entities.Vertice;

import java.util.*;
import java.util.stream.Collectors;

public class VerticeController {
    private Vertice vertice;
    private boolean sujar;

    public VerticeController(Vertice vertice) {
        this.vertice = vertice;
        this.sujar = false;
    }

    public void sujar() {
        this.sujar = true;
    }

    public void naoSujar() {
        this.sujar = false;
    }

    public List<Vertice> getAdjacentes() {
        return getAdjacentes(this.vertice, this.sujar);
    }


    public static List<Vertice> getAdjacentes(Vertice vertice, boolean sujar) {
        List<Vertice> adjacentes = new ArrayList<>();
        List<Aresta> arestas = vertice.getArestas();
        if (sujar) arestas.removeIf(a -> a.getVisitada());

        arestas.forEach(a -> {
            adjacentes.add(a.getOtherVertice(vertice));
            if (sujar) a.setVisitada(true);
        });
        return adjacentes;
    }

    public static boolean isRegular(List<Vertice> vertices) {
        if (vertices.isEmpty()) {
            return true;
        }

        int tam = vertices.get(1).getArestas().size();
        if (vertices.parallelStream().filter(v -> v.getArestas().size() != tam).collect(Collectors.toList()).size() > 0) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean isCompleto(List<Vertice> vertices) {
        for (Vertice v: vertices) {
            if(getAdjacentes(v,false).size() != vertices.size() - 1 ){
                return false;
            }
        }
        return true;
    }

    public static boolean isConexo(List<Vertice> vertices) {

        //Criando lista nova para não alterar elementos da lista original
        vertices = new ArrayList<>(vertices);
        if (vertices.isEmpty()) {
            return true;
        }
        Vertice v = vertices.get(1);
        vertices.remove(v);


        LinkedList<Vertice> fila = new LinkedList<>();
        fila.addLast(v);

        fila.addAll(getAdjacentes(v, true));

        while (!fila.isEmpty()) {
            Vertice vert = fila.getLast();
            List<Vertice> adj = getAdjacentes(vert, true);
            if (adj.isEmpty()) {
                vertices.remove(fila.pop());
            } else {
                fila.addAll(adj);
            }
        }
        return vertices.isEmpty();
    }


}
