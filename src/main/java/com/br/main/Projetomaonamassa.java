package com.br.main;

import com.br.controller.Controller;

public class Projetomaonamassa {

    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.inserirFuncionarios();
        controller.removerFuncionarioJoao();
        controller.printaFuncionarios();
        controller.aumentaSalarioFuncionarios();
        controller.agrupaFuncionarioFuncao();
        controller.printaFuncionarioMes();
        controller.printaFuncionarioMaisVelho();
        controller.ordenaListaOrdemAlfabetica();
        controller.totalSalarioFuncionarios();
        controller.quantidadeSalarioMinimoPorFuncionario();

    }
}
