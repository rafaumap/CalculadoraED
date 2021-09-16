
package controller;



public class CalcController {

	public CalcController() {
		
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