public class ProgramaDeTv {
    private long id;
    private String nome;
    private TipoPrograma tipo;
    private DiaSemana dia;
    private Canal canal;

    ProgramaDeTv(String nome, TipoPrograma tipo, DiaSemana dia, Canal canal){
        id = System.currentTimeMillis();
        this.nome = nome;
        this.tipo = tipo;
        this.dia = dia;
        this.canal = canal;
    }
    public String toString(){
        return "Programa: " + nome + " Dia Semana: " + dia + "Canal:" + canal;
    }
    public boolean equals(ProgramaDeTv programa){
        return id == programa.id;
    }

    public TipoPrograma getTipo() {
        return tipo;
    }

    public DiaSemana getDias() {
        return dia;
    }

    public long getId() {
        return id;
    }

    public Canal getCanal() {
        return canal;
    }

    public String getNome() {
        return nome;
    }
}
