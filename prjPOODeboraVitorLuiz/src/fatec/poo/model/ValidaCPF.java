package fatec.poo.model;

public class ValidaCPF {

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
