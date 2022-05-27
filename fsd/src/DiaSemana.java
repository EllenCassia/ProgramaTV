public enum DiaSemana {

   segunda(2),terca(3),quarta(4),quinta(5),sexta(6),sabado(7),domingo(1);

    private int valorDia;

    DiaSemana(int i) {
        valorDia += i;
    }

    public int getTempo() {
        return valorDia;
    }


}
