
package com.br.model;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class Funcionario extends Pessoa{
    
    private BigDecimal salario;
    private String funcao;
    
    public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
        super(nome, dataNascimento);
        this.salario = salario;
        this.funcao = funcao;
    }
    
    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        String salarioFormatado = "R$ " + decimalFormat.format(salario);
        return super.toString() + ", Salário: " + salarioFormatado + ", Função: " + funcao;
    }

    
}
