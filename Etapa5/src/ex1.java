public class ex1 {
	
	// Declaração da Classe Aluno
	public static class Aluno {
	    String nome; 	//Atributos da classe Aluno
	    String ra;
	    double[] notas;
	    boolean ead; // True se for EAD, False se for presencial
	    double frequencia; // Percentual de presença, de 0 a 100

	    // Construtor para as disciplinas presenciais
	    public Aluno(String nome, String ra, double[] notas, double frequencia) {
	        this.nome = nome; // Inicializa o Nome do Aluno
	        this.ra = ra; // Inicializa o RA do Aluno
	        this.notas = notas; // Inicializa as Notas do Aluno
	        this.ead = false; // Define que o aluno não é EAD
	        this.frequencia = frequencia; // Inicializa a Freqeência do Aluno
	    }

	    // Construtor para as disciplinas EAD
	    public Aluno(String nome, String ra, double[] notas) {
	        this.nome = nome; // Inicializa o Nome do Aluno
	        this.ra = ra; // Inicializa o RA do Aluno
	        this.notas = notas; // Inicializa as Notas do Aluno
	        this.ead = true; // Define que o aluno é EAD
	        this.frequencia = 100; // Como não conta, a frequência ficará sempre 100%
	    }
	    
	    // Método para calcular Nota Final
	    public double CalculoNota() {
	        
	        int n = notas.length; // Váriavel que armazenará as Notas
	        double mediaFinal = 0.0; // Variável que armazenará a Nota Final
	       int denominador = 1 + 2 + 4; // Cálculo do Denominador da Média Ponderada
	        
	        if (n == 1) {
	        	mediaFinal = notas[0]; // Se for apenas 1 nota, não será aceita
	        } else if (n == 2) {
	        	mediaFinal = (notas[0] + notas[1]) / 2; // Se forem 2 notas, será feita a Média Aritmética
	        } else if (n == 3) {
	        	mediaFinal = (notas[0] + 2 * notas[1] + 4 * notas[2]) / denominador; // Se forem 3 notas, será feita a Média Ponderada
	        } else if (n == 4) {
	            mediaFinal = (notas[0] * 0.15) + (notas[1] * 0.30) + (notas[2] * 0.10) + (notas[3] * 0.45);   // Se forem 4 notas, será feita a equação MF = (ac1 * 0,15) + (ac2 * 0,30) + (ag * 0,10) + (af * 0,45)

	        }

	        return mediaFinal;
	    }
	    
	    // Método para verificar se o Aluno foi aprovado pela Nota e Frquência
	    public String aprovacao() {
	        double mediaFinal = CalculoNota();
	        
	        // Se a disciplina for EAD, será avaliada apenas a nota para aprovação
	        if (ead) {
	            return mediaFinal >= 5 ? "Aprovado" : "Reprovado";
	        } 
	        
	        // Se a disciplina for presencial, será avaliada a nota e a frequência para aprovação
	        else {
	            return (mediaFinal >= 5 && frequencia >= 75) ? "Aprovado" : "Reprovado";
	        }
	    }

	    // Método para puxar as informações do aluno
	    public void InformacoesAluno() {
	        double mediaFinal = CalculoNota();
	        
	        System.out.println("\nNome: " + nome); // Exibe o Nome
	        System.out.println("RA: " + ra); // Exibe o RA
	        System.out.println("Nota Final: " + mediaFinal); // Exibe a Média Final
	        System.out.println("Situação: " + aprovacao()); // Exibe a Aprovação
	        
	    }

	    public static void main(String[] args) {
	        
	    	// Parâmetros do Aluno Presencial
	    	double[] notasPresencial = {6.0, 7.5, 8.0, 5.5}; // Sequência das Notas do Aluno Presencial
	        Aluno alunopresenc = new Aluno("João da Silva", "123456", notasPresencial, 80); // Inserção dos dados do Aluno Presencial
	        
	        // Parâmetros do Aluno EAD
	        double[] notasEAD = {9.0, 8.5, 7.0}; // Sequência das Notas do Aluno EAD
	        Aluno alunoead = new Aluno("Maria Oliveira", "654321", notasEAD); // Inserção dos dados do Aluno EAD
	        
	    	System.out.println("Aluno Presencial"); // Título para separar os Alunos
	        alunopresenc.InformacoesAluno();
	        
	        System.out.println("\nAluno EAD"); // Título para separar os Alunos
	        alunoead.InformacoesAluno();
	    }
	}
}