package br.upis.sistema.state;

//ConcreteState
public class Mes implements IMes{

	private byte valor;
	private IAno ano;
	
	public Mes() {
		setValor(1);
	}
	
	public Mes(int valor, IAno ano) {
		this.ano = ano;
		setValor(valor);
	}

	public short getValor() {
		return valor;
	}

	public void setValor(int valor) {
		if(valor >= 1 && valor <= 12) {
			this.valor = (byte)valor;
		}
	}
	
	public int getUltimoDia(IAno ano) {
		int ultimos[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		if(valor == 2 && ano.ehBissexto()) {
			return 29;
		}
		
		return ultimos[valor];
	}
	
	
	@Override
	public void incrementa() {
		
		byte valor = (byte)(this.valor + 1);

		if (valor > 12) {
		
			ano.incrementa();
			setValor(1);
		
		}else {
			
			this.valor = valor;
		}
		
	}

	@Override
	public String toString() {
		return Byte.toString(valor);
	}
}
