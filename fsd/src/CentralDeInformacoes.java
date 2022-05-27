import java.util.ArrayList;

public class CentralDeInformacoes {
    private final ArrayList<ProgramaDeTv> todosProgramas;
    private final ArrayList<Canal> canais;

    CentralDeInformacoes(){
        todosProgramas =  new ArrayList<>();
        canais = new ArrayList<>();
    }
    public boolean adicionar(ProgramaDeTv programa){

        boolean programaRepetido = false;

        for (ProgramaDeTv todosPrograma : todosProgramas) {
            if (todosPrograma.equals(programa)) {
                programaRepetido = true;
                break;
            }
        }
        if(programaRepetido)
            return false;
        else{
            todosProgramas.add(programa);
            return true;
        }
    }
    public ProgramaDeTv recuperarProgramaTvId(long id){
        for (ProgramaDeTv todosPrograma : todosProgramas) {
            if (todosPrograma.getId() == id)
                return todosPrograma;
        }
        return null;
    }
    public void recuperarProgramaPorTipo(TipoPrograma tipo) {
        for (ProgramaDeTv todosPrograma : todosProgramas) {
            if (todosPrograma.getTipo().equals(tipo))
                System.out.println(todosPrograma);
        }
    }

    public boolean adicionarCanal(Canal c){
        boolean programaRepetido = false;

        for (Canal emissora : canais) {
            if (emissora.equals(c)) {
                programaRepetido = true;
                break;
            }
        }
        if(programaRepetido)
            return false;
        else{
            canais.add(c);
            return true;
        }
    }
    public Canal recuperarCanal(String nome){
        Canal c = new Canal(nome,null);

        for(Canal emissora: canais){
            if(emissora.equals(c))
                return emissora;
        }
        return null;
    }
    public ArrayList<ProgramaDeTv> getTodosProgramas() {
        return todosProgramas;
    }

    public ArrayList<Canal> getCanais() {
        return canais;
    }
}
