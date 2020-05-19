package br.upis.sistema.state;

//ConcreteState
public class Dia implements IDia{

	private byte valor;
	
	private IMes mes;
	private IAno ano;
	
	private Dia() {
		this.valor = 1;
	}
	
	public Dia(IMes mes, IAno ano) {
		this(1, mes, ano);
	}
	
	public Dia(int valor, IMes mes, IAno ano){
		this();
		this.mes = mes;
		this.ano = ano;
		setValor(valor);
	}

	public short getValor() {
		return valor;
	}

	public void setValor(int valor) {
		
		byte ultimoDiaMes = (byte) mes.getUltimoDia(ano);
		
		if(valor >= 1 && valor <= ultimoDiaMes ) {
			this.valor = (byte)valor;
		}
	}

	@Override
	public void incrementa() {
		
		byte ultimoDiaMes = (byte) mes.getUltimoDia(ano);
		
		byte valor = (byte)(this.valor + 1);
		
		if(valor > ultimoDiaMes) {
			
			mes.incrementa();
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
