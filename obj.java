import java.util.Arrays;
import java.util.Scanner;

public class obj {

    Scanner scanner = new Scanner(System.in);

    public String nome;
    public Float ra;
    public String curso;
    public String periodo;
    public Double nota1 = 0.0;
    public Double nota2 = 0.0;
    public Double nota3 = 0.0;
    public Double recuperacao = 0.0;

    public void cadastrarAluno(String nome, Number ra, String curso, String periodo){
        this.nome = nome;
        this.ra = ra.floatValue();
        this.curso = curso;
        this.periodo = periodo;
    }

    public void cadastrarNotas(Double nota1, Double nota2, Double nota3, Double recuperacao){
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
        this.recuperacao = recuperacao;
    }

    // public void calcularMedia(){
    //     Number media = (this.nota1 + this.nota2 + this.nota3) / 3;
    //     System.out.println("A media do aluno é: " + media);
    // }


    public boolean verificarNotas(){
        if (this.nota1 < 0 || this.nota2 < 0 || this.nota3 < 0 || this.recuperacao < 0 || this.nota1 > 10 || this.nota2 > 10 || this.nota3 > 10 || this.recuperacao > 10){
            System.out.println("Notas inválidas");
            System.out.println("Insira as notas novamente");
            return true;
        }
        return false;
    }

    private Double media;

    public void calcularMedia(){
        Double[] notas = {this.nota1, this.nota2, this.nota3};
        Double somarNotas = Arrays.stream(notas).reduce(0.0, (acc, curr) -> acc + curr);
        this.media = somarNotas / 3;
    }

    public void verificarRecuperacao(){
        calcularMedia();

        if (this.media >= 6) {
            this.recuperacao = 0.0;
            System.out.println("Aluno aprovado com média: " + this.media);
        } else {
            System.out.println("O aluno precisa fazer a recuperação.");
            System.out.println("Digite a nota da recuperação: ");
            this.recuperacao = scanner.nextDouble();

            // Encontra a menor das três notas
            Double menorNota = Math.min(nota1, Math.min(nota2, nota3));

            // Atualiza a média, substituindo a menor nota pela nota de recuperação
            this.media = ((this.nota1 + this.nota2 + this.nota3 - menorNota) + this.recuperacao) / 3;

            System.out.println("Nova média após recuperação: " + this.media);
        }
    }

    public Double getMedia() {
        return this.media;
    }

    public void verificarNota2(){
        while (this.recuperacao < 0 || this.recuperacao > 10){
            System.out.println("Nota inválida");
            System.out.println("Insira a nota novamente");
            this.recuperacao = scanner.nextDouble();

            Double menorNota = Math.min(nota1, Math.min(nota2, nota3));

            this.media = ((this.nota1 + this.nota2 + this.nota3 - menorNota) + this.recuperacao) / 3;

            System.out.println("Nova média após recuperação: " + this.media);
        }
    };

    public void mensagemFinal(){
        System.out.println("A média do aluno é: " + this.media);
        System.out.println("As notas do aluno são: " + this.nota1 + ", " + this.nota2 + ", " + this.nota3);
        System.out.println("A nota da recuperacao do aluno é: " + this.recuperacao);
        if (this.media >= 6){
            System.out.println("O aluno está aprovado");
        }
        else{
            System.out.println("O aluno está reprovado");
        }
    }
    
    public static void main(String[] args) {
        // System.out.println("Hello World");
    }

}