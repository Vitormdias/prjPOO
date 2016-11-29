package fatec.poo.model;

public class ValidaCPF {

    private String CPF;

    public ValidaCPF(String CPF) {
        this.CPF = CPF;
    }

    public boolean valida() {

        if(!isPadrao() && verificaDigitos()) {

            return true;
        }

        return false;
    }

    public boolean verficaDigitos() {

        if(calculaDigitoVerificador(1) == CPF.charAt(CPF.length() - 1) && calculaDigitoVerificador(2) == CPF.charAt(CPF.length() - 2)) {

            return true;
        }

        return false;
    }

    public char calculaDigitoVerificador(int digitoVerificador) {
        int len , digitoInt , peso , soma = 0;
        char digitoChar;

        if(digitoVerificador == 1) {
            len = 9;
            peso = 10;
        }
        else {
            len = 10;
            peso = 11;
        }

        for(i = 0 ; i < len ; i++) {
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

}
