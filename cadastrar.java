import java.util.Scanner;

public class cadastrar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        obj aluno1 = new obj();
        aluno1.cadastrarAluno("João", 123456, "Sistemas de Informação", "Noturno");
        aluno1.cadastrarNotas(7.5, 8.0, 9.0, 0.0);
        aluno1.verificarRecuperacao();

        // System.out.println("Nome: " + aluno1.nome);
        // System.out.println("RA: " + aluno1.ra);
        // System.out.println("Curso: " + aluno1.curso);
        // System.out.println("Período: " + aluno1.periodo);
        // System.out.println("Nota 1: " + aluno1.nota1);
        // System.out.println("Nota 2: " + aluno1.nota2);
        // System.out.println("Nota 3: " + aluno1.nota3);
        // System.out.println("Faltas: " + aluno1.faltasAluno);
        // System.out.println("Recuperação: " + aluno1.recuperacao);



        obj aluno2 = new obj();
        System.out.println("Digite o nome do aluno: ");
        aluno2.nome = scanner.nextLine();
        System.out.println("Digite o RA do aluno: ");
        aluno2.ra = scanner.nextFloat();
        scanner.nextLine();
        System.out.println("Digite o curso do aluno: ");
        aluno2.curso = scanner.nextLine();
        System.out.println("Digite o período do aluno: ");
        aluno2.periodo = scanner.nextLine();
        System.out.println("Digite a primeira nota do aluno: ");
        aluno2.nota1 = scanner.nextDouble();
        System.out.println("Digite a segunda nota do aluno: ");
        aluno2.nota2 = scanner.nextDouble();
        System.out.println("Digite a terceira nota do aluno: ");
        aluno2.nota3 = scanner.nextDouble();
        aluno2.verificarNotas();

        while (aluno2.verificarNotas() == true){
            System.out.println("Notas inválidas");
            System.out.println("Insira as notas novamente");
            aluno2.nota1 = scanner.nextDouble();
            aluno2.nota2 = scanner.nextDouble();
            aluno2.nota3 = scanner.nextDouble();
        }

        aluno2.verificarRecuperacao();
        aluno2.verificarNota2();

        // System.out.println("Nome: " + aluno2.nome);
        // System.out.println("RA: " + aluno2.ra);
        // System.out.println("Curso: " + aluno2.curso);
        // System.out.println("Período: " + aluno2.periodo);
        aluno2.mensagemFinal();
    

        scanner.close();
    }
}