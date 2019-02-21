package com.company;

import com.company.controller.VerticeController;
import com.company.entities.Aresta;
import com.company.entities.Vertice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Vertice v1, v2, v3, v4;
        v1 = new Vertice(1);
        v2 = new Vertice(2);
        v3 = new Vertice(3);
        v4 = new Vertice(4);

        new Aresta(v1, v2);
        new Aresta(v2, v3);
        new Aresta(v1, v3);
        new Aresta(v3, v4);

        //Obter o id dos adjacentes, para o v1 os adjacentes devem ser 2 e 3, para v3 adiciona-se o v4
        List<Vertice> adjacentes = VerticeController.getAdjacentes(v1, false);
        adjacentes.forEach(adj -> System.out.println(adj.getId()));


        Vertice[] tmp = {v1, v2, v3, v4};
        List<Vertice> lista = Arrays.asList(tmp);

        //verificando se é regular
        System.out.println(VerticeController.isRegular(lista));

        //verificando se é conexo
        System.out.println(VerticeController.isConexo(lista));

        //verificando se é completo
        System.out.println(VerticeController.isCompleto(lista));

        //criando uma sublista com v1 v2 e v3 para verificar se nesse cenario ele é completo
        List<Vertice> lista2 = new ArrayList<>();
        lista2.addAll(lista.subList(0, 3));
        System.out.println(VerticeController.isCompleto(lista2));
    }
}
