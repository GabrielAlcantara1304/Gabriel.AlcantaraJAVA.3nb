package br.com.fecaf.model;

import java.util.Scanner;

public class Triangulo {

    public double base, lado2, lado3, area, perimetro, altura;

    Scanner scanner = new Scanner(System.in);

    public boolean cadastrarTriangulo() {
        System.out.println("/************************/");
        System.out.println("/*   Cadastro Triângulo */");
        System.out.println("/************************/");
        System.out.print("/* Informe o Base:     */");
        base = scanner.nextDouble();
        System.out.print("/* Informe o lado 2:     */");
        lado2 = scanner.nextDouble();
        System.out.print("/* Informe o lado 3:   */");
        lado3 = scanner.nextDouble();
        System.out.print("Informe a Altura: ");
        altura = scanner.nextDouble();
        System.out.println("/* Triângulo Cadastrado com Sucesso !");
        System.out.println("/***********************************/");

        return true;
    }

    public void calcularArea () {
        System.out.println("/*********************************/");
        System.out.println("/*        Calculando Area        */");
        System.out.println("/*********************************/");

        area = (base * altura) / 2 ;
        System.out.println("A área é: " + area);
        System.out.println("/*********************************/");
    }

    public void calcularPerimetro () {
        System.out.println("/*********************************/");
        System.out.println("/*      Calculando Perimetro     */");
        System.out.println("/*********************************/");

        perimetro = base + lado2 + lado3;
        System.out.println("O perimetro é: " + perimetro);
        System.out.println("/*********************************/");
    }

    // Isosceles / Escaleno / Equilatero
    public void definirTipo () {
        System.out.println("/*********************************/");
        System.out.println("/*        Definindo Tipo         */");
        System.out.println("/*********************************/");

        if (base == lado2 && base == lado3) {

            System.out.println("Este Triângulo é Equilátero ...");

        } else if (base != lado2 && base != lado3 && lado2 != lado3) {

            System.out.println("Este Triângulo é Escaleno ...");

        } else {
            System.out.println("Este Triângulo é Isosceles ...");
        }
        System.out.println("/***************************************/");

    }

    //Vou criar um metodo para que ele identifique se o triangulo e retangulo
    public boolean identificarTRetangulo(){
        System.out.println("/*********************************/");
        System.out.println("/*        Identificando..         */");
        System.out.println("/*********************************/");


        double[] lados = {base, lado2, lado3};
        java.util.Arrays.sort(lados);

        //calcular pitágoras
        boolean eRetangulo = Math.abs(Math.pow(lados[0], 2) + Math.pow(lados[1], 2) - Math.pow(lados[2], 2)) < 1e-9;

        //se for possivel realizar o calculo de pitagoras significa que é triângulo retângulo
        if (eRetangulo == true) {
            System.out.println("É triângulo retângulo.");
        } else {
            System.out.println("Não é triângulo retângulo.");
        }
        return eRetangulo;

    }


    //função que verifica se o triangulo segue a proporcao 345
    public void verificarProporcao345() {
        System.out.println("/***************************************/");
        System.out.println("/*        Verificando se é 3:4:5       */");
        System.out.println("/***************************************/");

        //caso os lados estiverem de acordo com as condicoes entao o triangulo vai passar
        // da primeira parte para definir se é 345
        if (eDivisivel(base) && eDivisivel(lado2) && eDivisivel(lado3)) {

        // Verifica se o triângulo segue a proporção característica dos triângulos 345
        // Realiza uma subtração para comparar os lados e verificar se a proporção é válida
        if ((lado3 - base == base - lado2) || (lado2 - base == base - lado3)) {
            // Se o triângulo atender às condições definidas acima, 
            // ele será considerado um triângulo 345
                System.out.println("O triângulo é 3:4:5");
            } else {
                System.out.println("O triângulo não é 3:4:5");
            }
        } else {
            System.out.println("O triângulo não é 3:4:5");
        }
    }

// Esta função realiza um cálculo que é utilizado como critério de condição
// para verificar se o triângulo é um triângulo 345
    private boolean eDivisivel(double num) {
        return num % 3 == 0 || num % 4 == 0 || num % 5 == 0;

    }
}
