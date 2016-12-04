package fatec.poo.model;

public class ValidaCPF {

    private String CPF;

    public ValidaCPF(String CPF) {
        this.CPF = CPF;
    }

    public boolean verficaDigitos() {

        return calculaDigitoVerificador(1) == CPF.charAt(CPF.length() - 1) && calculaDigitoVerificador(2) == CPF.charAt(CPF.length() - 2);
    }
    
    public boolean valida() {

        return !isPadrao() && verficaDigitos(); 
    }

    public char calculaDigitoVerificador(int digitoVerificador) {
        int num, len , digitoInt , peso , soma = 0;
        char digitoChar;

        if(digitoVerificador == 1) {
            len = 9;
            peso = 10;
        }
        else {
            len = 10;
            peso = 11;
        }

        for(int i = 0 ; i < len ; i++) {
            num = (int)(CPF.charAt(i) - 48);

            soma += num * peso;
            peso -= 1;
        }

        digitoInt = 11 - (soma % 11);

        if ((digitoInt == 10) || (digitoInt == 11)) {

            digitoChar = '0';
        }
        else {

            digitoChar = (char)(digitoInt + 48);
        }

        return digitoChar;
    }

    public boolean isPadrao() {
        if (CPF.equals("11111111111")
            || CPF.equals("22222222222")
            || CPF.equals("33333333333")
            || CPF.equals("44444444444")
            || CPF.equals("55555555555")
            || CPF.equals("66666666666")
            || CPF.equals("77777777777")
            || CPF.equals("88888888888")
            || CPF.equals("99999999999")) {

                return true;
        }

      return false;
    }
	public static boolean isCPF(String CPF) {

	    char dig10, dig11;
	    int sm, i, r, num, peso;


	// Calculo do 1o. Digito Verificador
	      sm = 0;
	      peso = 10;
	      for (i=0; i<9; i++) {
	        num = (int)(CPF.charAt(i) - 48);
	        sm = sm + (num * peso);
	        peso = peso - 1;
	      }

	      r = 11 - (sm % 11);
	      if ((r == 10) || (r == 11))
	         dig10 = '0';
	      else
	    	  dig10 = (char)(r + 48);

	// Calculo do 2o. Digito Verificador
	      sm = 0;
	      peso = 11;
	      for(i=0; i<10; i++) {
	        num = (int)(CPF.charAt(i) - 48);
	        sm = sm + (num * peso);
	        peso = peso - 1;
	      }

	      r = 11 - (sm % 11);
	      if ((r == 10) || (r == 11))
	         dig11 = '0';
	      else dig11 = (char)(r + 48);

	// Verifica se os digitos calculados conferem com os digitos informados.
	      if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
	         return(true);
	      else
	    	  return(false);

	  }

}
