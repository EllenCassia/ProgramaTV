import java.util.Scanner;

public class ProgramaCadastro {
    public static void main(String[] args){
        Scanner leitor = new Scanner(System.in);
        Persistencia salvar = new Persistencia();
        boolean resultado = false;
        boolean acabou = false;
        CentralDeInformacoes cadastrar = salvar.recuperarCentral("arquivo.xml");

        while (!acabou) {
            System.out.println("1 - novo programa\n2 - Listar todos os programas cadastrados\n3 - Listar todos os programas de um mesmo tipo\n4 - Novo canal\n5 - Listar todos os canais\n6 - Gerar relação dos programas de um mesmo canal\n7 - enviar programação de hoje\nS - sair");
            String op = leitor.nextLine();

            switch (op) {
                case "1":
                    System.out.println("Informe programa: ");
                    String n = leitor.nextLine();
                    System.out.println("Informe um tipo de programa: ");
                    TipoPrograma tipoPrograma = TipoPrograma.valueOf(leitor.nextLine());
                    System.out.println("Informe o dia: ");
                    DiaSemana dia = DiaSemana.valueOf(leitor.nextLine());
                    System.out.println("Informe canal transmitido: ");
                    String canal = leitor.nextLine();
                    Canal retonarCanal = cadastrar.recuperarCanal(canal);
                    // criar uma classe que era receber este enum

                    ProgramaDeTv programa = new ProgramaDeTv(n, tipoPrograma, dia , retonarCanal);

                    if(retonarCanal != null){
                        resultado = cadastrar.adicionar(programa);
                        //salvando este novo objeto da classeCID no arquivo com este nome
                        salvar.salvarCentral(cadastrar, "arquivo.xml");
                    }else
                        System.out.println("Canal não cadastrado");


                    if (!resultado)
                        System.out.println("Cadastro não efetuado");
                    else
                        System.out.println("Cadastro efetuado");
                    break;
                case "2":
                    System.out.println(cadastrar.getTodosProgramas());
                    break;
                case "3":
                    System.out.println("Informe um tipo");
                    TipoPrograma tipo = TipoPrograma.valueOf(leitor.nextLine());
                    cadastrar.recuperarProgramaPorTipo(tipo);
                    break;
                case "4":
                    System.out.println("Nome do canal: ");
                    String nome = leitor.nextLine();
                    System.out.println("Tipo de canal: ");
                    String tip = leitor.nextLine();

                    Canal emissora = new Canal(nome,tip);
                    boolean resposta = cadastrar.adicionarCanal(emissora);

                    if (resposta)
                        System.out.println("Canal cadastrado");
                    else
                        System.out.println("Canal não cadastrado");
                    break;
                case "5":
                    System.out.println(cadastrar.getCanais());
                    break;
                case "6":
                    System.out.println("Digite um canal: ");
                    String c = leitor.nextLine();

    			    for(Canal x: cadastrar.getCanais()) {
    					if(x.getNome().equals(c)){
    						GeradorRelatorio.obterProgramacaoDeUmCanal(x);
                            System.out.println("PDF GERADO");
                            break;
    					}else
                            System.out.println("canal não encontrado!!");
    				}
                    break;
                case "7":
                    Mesageiro.enviarProgramacaoDeHoje("ellencassiamatos@gmail.com");
                case "S":
                    acabou = true;
                    break;
            }
        }

    }
}
