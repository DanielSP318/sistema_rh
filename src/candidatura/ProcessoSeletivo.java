package candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
	public static void main(String[] args) {
		
		/* Teste dos método static que analisa os candidatos.
		 *analisarCandidato(1900.0);
		 *analisarCandidato(2200.0);
		 *analisarCandidato(2000.0);
		 *Segue abaixo o método static que seleciona os candidatos.
		 *selecaoCandidatos();
		 *Segue abaixo o método static que imprimi os candidatos selecionados pelo processo seletivo.
		 *imprimirSelecionados();
		*/
		
		String [] candidatos = {"Felipe", "Marcia", "Paulo", "Augusto", "Fabricio"};
		
		for(String candidato: candidatos) {
			entrandoEmContato(candidato);
		}
	}
	
	static void entrandoEmContato(String candidato) {
		int tentativasRealizadas = 1;
		boolean continuarTentando = true;
		boolean atendeu = false;
		do {
			// as variáveis precisam sofrer alteração, para que não aconteça um loop infinito.
			atendeu = atender();
			continuarTentando = !atendeu;
			if(continuarTentando) tentativasRealizadas++;
			else System.out.println("Contato realizado com sucesso.");
			
		} while (continuarTentando &&  tentativasRealizadas < 3);
		
		if(atendeu) System.out.println("Conseguimos contato com o(a) candidato(a): " + candidato +" com "+ tentativasRealizadas);
		else System.out.println("Não conseguimos contato com o(a) candidato(a) " + candidato + ", número de tentativas: " + tentativasRealizadas);
	}
	
	static boolean atender() {
		return new Random().nextInt(3) == 1;
	}
	
	static void imprimirSelecionados() {
		String [] candidatos = {"Felipe", "Marcia", "Paulo", "Augusto", "Fabricio"};
		System.out.println("Construindo e mostrando a lista dos candidatos selecionados, e mostrando seu indice do array.");
		for(int indice = 0; indice < candidatos.length; indice++) {
			System.out.println("O candidato(a) de nº " + (indice+1) + " é o(a): " + candidatos[indice]);
		}
		System.out.println("Forma abreviada usando o for each");
		
		for(String candidato: candidatos) {
			System.out.println("O candidato(a) selecionado(a) é: " + candidato);
		}
		
	}
	
	static void selecaoCandidatos() {
		// Array com a lista de nome dos candidatos.
		String [] candidatos = {"Felipe", "Marcia", "Paulo", "Augusto", "Fabricio", "Mirela", "Daniela", "Daniel"};
		
		int candidatosSelecionados = 0;
		int candidatoAtual = 0;
		double salarioBase = 2000.0;
		while(candidatosSelecionados < 5 && candidatoAtual < candidatos.length) {
			String candidato = candidatos[candidatoAtual];
			double salarioPretendido = valorPretendido();
		
			System.out.println("O candidato = " + candidato + " pretende ter essa salário = R$ " + salarioPretendido);
			 
			if (salarioBase >= salarioPretendido) {
				System.out.println("O candidato " + candidato + " foi selecionado para a vaga");
				candidatosSelecionados++;
			}
			candidatoAtual++;
		}
	}
	
	static double valorPretendido() {
		return ThreadLocalRandom.current().nextDouble(1800, 2200);
	}
	
	static void analisarCandidato(double salarioPretendido) {
			double salarioBase = 2000.0;
			if (salarioBase > salarioPretendido) {
				System.out.println("Ligue para o candidato");
			} else if (salarioBase == salarioPretendido) {
				System.out.println("Ligue para o candidato com uma contra proposta");
			} else {
				System.out.println("Aguardando o resultado dos demais candidatos");
			}
	}
}
