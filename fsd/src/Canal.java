public class Canal {
    private String nome;
    private String tipoCanal;

    Canal(String n, String t){
        nome = n;
        tipoCanal = t;
    }
    Canal(){}
    public String toString(){
        return nome;
    }
    public boolean equals(Canal canal){
        return nome.equals(canal.nome);
    }

    public String getNome() {
        return nome;
    }
}
