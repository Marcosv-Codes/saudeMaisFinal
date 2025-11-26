package com.projetoPablo;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Paciente p1 = new Paciente("Xivu", "00000000000", "00/00/0000", "saude+@gmail.com", "saude+123", Prioridade.VERDE, "20:34");

        System.out.println(p1.toString());
        p1.login("saude+@gmail.com", "saude+123");

        UPA upa1 = new UPA("Campo da Liga", "Rua do Prado");
        Medico medico = new Medico("Tereza", "00000000000", "00/00/0000", "12345", "12345", upa1, Prioridade.VERDE);
        medico.autenticar("12345");
        medico.atenderPaciente(p1);





    }
}