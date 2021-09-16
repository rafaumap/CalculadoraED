package view;

import javax.swing.JOptionPane;

import controller.CalcController;
package controller;

import 

public class CalcController {

	public CalcController() {
		// TODO Auto-generated constructor stub
	}

	public void insereValor(Pilha pilha, int valor) {
		pilha.push(valor);	
	}
	
	public int rpn(Pilha pilha, int op) throws Exception {
		int valor1, valor2, resultado = 0;
		
		if (pilha.isEmpty() || pilha.size() < 2) {
			throw new Exception("Pilha com valores insuficientes");
		}
		
		valor1 = pilha.pop();
		valor2 = pilha.pop();
		
		switch (op) {
			case 0:
				resultado = valor1 + valor2;
				break;
			case 1:
				resultado = valor1 * valor2;
				break;
			case 2:
				resultado = valor1 - valor2;
				break;
			case 3:
				resultado = valor1 / valor2;
				break;
		}
		
		
		return resultado;
	}
}
public class Principal {

	public static void main(String[] args) {
		Pilha pilha = new Pilha();
		CalcController controller = new CalcController();

		int opcao = 0;
		int resultado = 0;

		String[] actionButtons = { "Adicionar número", "Executar operação", "Cancelar" };
		String[] opButtons = { "+", "*", "-", "/", "Cancelar" };

		do {
			opcao = JOptionPane.showOptionDialog(null, "Qual será a ação?", "Confirmation",
					JOptionPane.INFORMATION_MESSAGE, 0, null, actionButtons, actionButtons[0]);

			if (opcao == 0) {
				int valor = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira um valor"));
				controller.insereValor(pilha, valor);
			}

		} while (opcao != 1 && opcao != 2);

		if (opcao == 1) {
			 do {
				int op = JOptionPane.showOptionDialog(null, "Qual será a operação? \n " + resultado, "Confirmation",
						JOptionPane.INFORMATION_MESSAGE, 0, null, opButtons, opButtons[2]);
				
				if (op == 4) {
					break;
				}
				
				try {
					resultado = controller.rpn(pilha, op);
					controller.insereValor(pilha, resultado);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, resultado);
					e.printStackTrace();
					break;
				}

			} while (!pilha.isEmpty());
			 
			 
		}

	}

}