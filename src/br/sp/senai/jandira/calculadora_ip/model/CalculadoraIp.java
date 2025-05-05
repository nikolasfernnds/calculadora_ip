package br.sp.senai.jandira.calculadora_ip.model;

public class CalculadoraIp {

	private int primeiroOcteto;
	private int segundoOcteto;
	private int terceiroOcteto;
	private int quartoOcteto;
	private int cidr;
	
	public void setOctetos(int primeiroOcteto, int segundoOcteto, int terceiroOcteto, int quartoOcteto) {
		this.primeiroOcteto = primeiroOcteto;
		this.segundoOcteto  = segundoOcteto;
		this.terceiroOcteto = terceiroOcteto;
		this.quartoOcteto   = quartoOcteto;	
	}
	
	public void setCidr(int cidr) {
		this.cidr = cidr;
	}
	
	public String getIp() {
		return primeiroOcteto + "." + segundoOcteto + "." + terceiroOcteto + "." + quartoOcteto;
	}
	
	public String getClasseIp() {
		if (primeiroOcteto >= 0 && primeiroOcteto <= 127) {
			return "CLASSE A";
		} else if (primeiroOcteto >= 128 && primeiroOcteto <= 191) {
			return "CLASSE B";
		} else if (primeiroOcteto >= 192 && primeiroOcteto <= 223) {
			return "CLASSE C";
		} else {
			return "Valor inserido maior que 223!";
		}
	}
	
    public static String getMascaraDecimal(String classe) {
        switch (classe) {
            case "CLASSE A": return "255.0.0.0";
            case "CLASSE B": return "255.255.0.0";
            case "CLASSE C": return "255.255.255.0";
            default: return "Fora do intervalo!";
        }
    }

    public static String getMascaraBinaria(String classe) {
        switch (classe) {
            case "CLASSE A": return "11111111.00000000.00000000.00000000";
            case "CLASSE B": return "11111111.11111111.00000000.00000000";
            case "CLASSE C": return "11111111.11111111.11111111.00000000";
            default: return "Fora do intervalo!";
        }
    }
    public int getNumeroIpsDisponiveis() {
    	if (cidr >= 32) {
    	    return 1;
    	} else {
    	    return (int) Math.pow(2, 32 - cidr);
    	}	
    }

}
