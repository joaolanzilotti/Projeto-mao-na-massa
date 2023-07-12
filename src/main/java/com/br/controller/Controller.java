package com.br.controller;

import com.br.model.Funcionario;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Controller {
    
     DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
    List<Funcionario> listaFuncionarios = new ArrayList<>();

    public void inserirFuncionarios() {
        //Adiciona na lista os funcionarios
        listaFuncionarios.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal(2009.44), "Operador"));
        listaFuncionarios.add(new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal(2284.38), "Operador"));
        listaFuncionarios.add(new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal(9836.14), "Coordenador"));
        listaFuncionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal(19119.88), "Diretor"));
        listaFuncionarios.add(new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal(2234.68), "Recepcionista"));
        listaFuncionarios.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal(1582.72), "Operador"));
        listaFuncionarios.add(new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal(4071.84), "Contador"));
        listaFuncionarios.add(new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal(3017.45), "Gerente"));
        listaFuncionarios.add(new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal(1606.85), "Eletricista"));
        listaFuncionarios.add(new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal(2799.99), "Gerente"));
    }
    
    public void removerFuncionarioJoao(){
        //Remove o funcionario Joao
         listaFuncionarios.removeIf(funcionario -> funcionario.getNome().equals("João"));
    }
    
    public void printaFuncionarios(){
        //Printa a lista de funcionario
        System.out.println("Lista de Funcionários:");
        listaFuncionarios.forEach(System.out::println);
    }
    
    public void aumentaSalarioFuncionarios(){
        //Aumenta o salario dos funcionarios em 10%
         listaFuncionarios.forEach(funcionario -> {
            BigDecimal novoSalario = funcionario.getSalario().multiply(new BigDecimal("1.10"));
            funcionario.setSalario(novoSalario);
        });
    }
    
    public void agrupaFuncionarioFuncao(){
        //Printa os funcionarios agrupados por funcao
        Map<String, List<Funcionario>> funcionariosPorFuncao = listaFuncionarios.stream().collect(Collectors.groupingBy(Funcionario::getFuncao));

        System.out.println("\nFuncionários Agrupados por função:");
        funcionariosPorFuncao.forEach((funcao, lista) -> {
            System.out.println("Função: " + funcao);
            lista.forEach(System.out::println);
            System.out.println();
        });
    }
    
    public void printaFuncionarioMes(){
        //Printa o Funcionario que faz aniversario no mes 10 e 12
    System.out.println("Funcionários que fazem aniversário em outubro (mês 10) e dezembro (mês 12):");
        DateTimeFormatter mesFormatter = DateTimeFormatter.ofPattern("MM");
        listaFuncionarios.stream()
                .filter(funcionario -> {
                    String mesNascimento = funcionario.getDataNascimento().format(mesFormatter);
                    return mesNascimento.equals("10") || mesNascimento.equals("12");
                })
                .forEach(System.out::println);
    }
    
    public void printaFuncionarioMaisVelho(){
        //Printa o Funcionario Mais Velho
        Funcionario funcionarioMaisVelho = listaFuncionarios.stream()
                .min(Comparator.comparing(Funcionario::getDataNascimento))
                .orElse(null);

        if (funcionarioMaisVelho != null) {
            LocalDate dataAtual = LocalDate.now();
            int idade = dataAtual.getYear() - funcionarioMaisVelho.getDataNascimento().getYear();
            System.out.println("\nFuncionário mais velho:");
            System.out.println("Nome: " + funcionarioMaisVelho.getNome() + ", Idade: " + idade + " anos");
        }
    }
    
    public void ordenaListaOrdemAlfabetica(){
        //Ordena a lista por ordem alfabética
        listaFuncionarios.sort(Comparator.comparing(Funcionario::getNome));

        //Printa a lista ordenada
        System.out.println("\nLista de funcionários em ordem alfabética:");
        listaFuncionarios.forEach(System.out::println);
    }
    
    public void totalSalarioFuncionarios(){
         //Calcula o total de salarios do funcionarios
          BigDecimal totalSalarios = listaFuncionarios.stream()
                .map(Funcionario::getSalario)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("\nTotal dos salários dos funcionários: R$ " + decimalFormat.format(totalSalarios));
    }
    
    public void quantidadeSalarioMinimoPorFuncionario(){
         //Printa quantos salarios minimos ganha cada funcionario
        BigDecimal salarioMinimo = new BigDecimal("1212.00");
        System.out.println("\nSalários em múltiplos do salário mínimo:");
        listaFuncionarios.forEach(funcionario -> {
            BigDecimal multiploSalarioMinimo = funcionario.getSalario().divide(salarioMinimo, 2, BigDecimal.ROUND_DOWN);
            System.out.println(funcionario.getNome() + ": " + multiploSalarioMinimo + " salários mínimos");
        });
    }

    public void PessoaController() {

        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");

        //Inserir os Funcionarios na Lista
        //List<Funcionario> funcionarios = new ArrayList<>();
        listaFuncionarios.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal(2009.44), "Operador"));
        listaFuncionarios.add(new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal(2284.38), "Operador"));
        listaFuncionarios.add(new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal(9836.14), "Coordenador"));
        listaFuncionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal(19119.88), "Diretor"));
        listaFuncionarios.add(new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal(2234.68), "Recepcionista"));
        listaFuncionarios.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal(1582.72), "Operador"));
        listaFuncionarios.add(new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal(4071.84), "Contador"));
        listaFuncionarios.add(new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal(3017.45), "Gerente"));
        listaFuncionarios.add(new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal(1606.85), "Eletricista"));
        listaFuncionarios.add(new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal(2799.99), "Gerente"));

        //Remove o Funcionario João
        listaFuncionarios.removeIf(funcionario -> funcionario.getNome().equals("João"));

        //Printa todos os Funcionarios
        System.out.println("Lista de Funcionários:");
        listaFuncionarios.forEach(System.out::println);

        //Aumenta o Salário dos Funcionarios em 10%
        listaFuncionarios.forEach(funcionario -> {
            BigDecimal novoSalario = funcionario.getSalario().multiply(new BigDecimal("1.10"));
            funcionario.setSalario(novoSalario);
        });

        //Agrupa os funcionarios por funcao utilizando Stream
        Map<String, List<Funcionario>> funcionariosPorFuncao = listaFuncionarios.stream().collect(Collectors.groupingBy(Funcionario::getFuncao));

        System.out.println("\nFuncionários Agrupados por função:");
        funcionariosPorFuncao.forEach((funcao, lista) -> {
            System.out.println("Função: " + funcao);
            lista.forEach(System.out::println);
            System.out.println();
        });

        //Printa os funcionarios que fazem aniversário no mes 10 e 12
        System.out.println("Funcionários que fazem aniversário em outubro (mês 10) e dezembro (mês 12):");
        DateTimeFormatter mesFormatter = DateTimeFormatter.ofPattern("MM");
        listaFuncionarios.stream()
                .filter(funcionario -> {
                    String mesNascimento = funcionario.getDataNascimento().format(mesFormatter);
                    return mesNascimento.equals("10") || mesNascimento.equals("12");
                })
                .forEach(System.out::println);

        //Busca o Funcionario mais Velho
        Funcionario funcionarioMaisVelho = listaFuncionarios.stream()
                .min(Comparator.comparing(Funcionario::getDataNascimento))
                .orElse(null);

        if (funcionarioMaisVelho != null) {
            LocalDate dataAtual = LocalDate.now();
            int idade = dataAtual.getYear() - funcionarioMaisVelho.getDataNascimento().getYear();
            System.out.println("\nFuncionário mais velho:");
            System.out.println("Nome: " + funcionarioMaisVelho.getNome() + ", Idade: " + idade + " anos");
        }

        //Ordena a lista por ordem alfabética
        listaFuncionarios.sort(Comparator.comparing(Funcionario::getNome));

        //Printa a lista ordenada
        System.out.println("\nLista de funcionários em ordem alfabética:");
        listaFuncionarios.forEach(System.out::println);

        //Calcula o total ds salarios do funcionarios
        BigDecimal totalSalarios = listaFuncionarios.stream()
                .map(Funcionario::getSalario)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("\nTotal dos salários dos funcionários: R$ " + decimalFormat.format(totalSalarios));

        //Printa quantos salarios minimos ganha cada funcionario
        BigDecimal salarioMinimo = new BigDecimal("1212.00");
        System.out.println("\nSalários em múltiplos do salário mínimo:");
        listaFuncionarios.forEach(funcionario -> {
            BigDecimal multiploSalarioMinimo = funcionario.getSalario().divide(salarioMinimo, 2, BigDecimal.ROUND_DOWN);
            System.out.println(funcionario.getNome() + ": " + multiploSalarioMinimo + " salários mínimos");
        });

    }

}
