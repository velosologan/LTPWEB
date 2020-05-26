package br.upis.sistema.state;

//Context
public class Data {
	
	private IDia dia;
	private IMes mes;
	private IAno ano;
	
	public Data(int dia, int mes, int ano) {
		this.ano = new Ano(ano);
		this.mes = new Mes(mes, this.ano);
		this.dia = new Dia(dia, this.mes, this.ano);
	}
	
	public void incrementaDia() {
		dia.incrementa();		
	}
	
	@Override
	public String toString() {
		//System.out.println(String.format ("%04d", ano) + "-" + String.format ("%02d", mes) + "-" + String.format ("%02d", dia));
		return ano + "-" + mes + "-" + dia;
	}	
}
