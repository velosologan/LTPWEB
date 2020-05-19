package br.upis.sistema.state;

//ConcreteState
public class Ano implements IAno {
	
	private short valor;
	
	public Ano() {
		this.valor = 1;
	}
	
	public Ano(int valor) {
		setValor(valor);
	}

	public short getValor() {
		return valor;
	}

	public void setValor(int valor) {
		if(valor >= 1 && valor <= 9999) {
			this.valor = (short)valor;
		}
	}
	
	public boolean ehBissexto() {
		return valor % 400 == 0 || (valor % 100 != 0 && valor % 4 == 0);
	}	
	
	@Override
	public void incrementa() {
		
		short valor = (short)(this.valor + 1);
		
		if(valor > 9999) {
		
			this.valor = 1;
		
		}else {
			
			this.valor = valor;
		}
	}

	@Override
	public String toString() {
		return Short.toString(valor);
	}
}
