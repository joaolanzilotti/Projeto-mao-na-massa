package com.prefeitura.controller;

import com.prefeitura.model.Funcionario;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Controller {

    public void PessoaController() {
        
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");

        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal(2009.44), "Operador"));
        funcionarios.add(new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal(2284.38), "Operador"));
        funcionarios.add(new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal(9836.14), "Coordenador"));
        funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal(19119.88), "Diretor"));
        funcionarios.add(new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal(2234.68), "Recepcionista"));
        funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal(1582.72), "Operador"));
        funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal(4071.84), "Contador"));
        funcionarios.add(new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal(3017.45), "Gerente"));
        funcionarios.add(new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal(1606.85), "Eletricista"));
        funcionarios.add(new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal(2799.99), "Gerente"));

        funcionarios.removeIf(funcionario -> funcionario.getNome().equals("João"));

        System.out.println("Lista de Funcionários:");
        funcionarios.forEach(System.out::println);

        funcionarios.forEach(funcionario -> {
            BigDecimal novoSalario = funcionario.getSalario().multiply(new BigDecimal("1.10"));
            funcionario.setSalario(novoSalario);
        });

        Map<String, List<Funcionario>> funcionariosPorFuncao = funcionarios.stream().collect(Collectors.groupingBy(Funcionario::getFuncao));

        System.out.println("\nFuncionários Agrupados por função:");
        funcionariosPorFuncao.forEach((funcao, lista) -> {
            System.out.println("Função: " + funcao);
            lista.forEach(System.out::println);
            System.out.println();
        });
        
         System.out.println("Funcionários que fazem aniversário em outubro (mês 10) e dezembro (mês 12):");
        DateTimeFormatter mesFormatter = DateTimeFormatter.ofPattern("MM");
        funcionarios.stream()
                .filter(funcionario -> {
                    String mesNascimento = funcionario.getDataNascimento().format(mesFormatter);
                    return mesNascimento.equals("10") || mesNascimento.equals("12");
                })
                .forEach(System.out::println);
        
         Funcionario funcionarioMaisVelho = funcionarios.stream()
                .min(Comparator.comparing(Funcionario::getDataNascimento))
                .orElse(null);
         
         if (funcionarioMaisVelho != null) {
            LocalDate dataAtual = LocalDate.now();
            int idade = dataAtual.getYear() - funcionarioMaisVelho.getDataNascimento().getYear();
            System.out.println("\nFuncionário mais velho:");
            System.out.println("Nome: " + funcionarioMaisVelho.getNome() + ", Idade: " + idade + " anos");
        }
         
        funcionarios.sort(Comparator.comparing(Funcionario::getNome));
        
        System.out.println("\nLista de funcionários em ordem alfabética:");
        funcionarios.forEach(System.out::println);
        
          BigDecimal totalSalarios = funcionarios.stream()
                .map(Funcionario::getSalario)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("\nTotal dos salários dos funcionários: R$ " + decimalFormat.format(totalSalarios));
        
         BigDecimal salarioMinimo = new BigDecimal("1212.00");
        System.out.println("\nSalários em múltiplos do salário mínimo:");
        funcionarios.forEach(funcionario -> {
            BigDecimal multiploSalarioMinimo = funcionario.getSalario().divide(salarioMinimo, 2, BigDecimal.ROUND_DOWN);
            System.out.println(funcionario.getNome() + ": " + multiploSalarioMinimo + " salários mínimos");
        });

    }

}
