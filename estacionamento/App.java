// @author Augusto Dantas - RGM: 30981573
// @author Gabriel Cardozo dos Santos - RGM: 30031249
// @author Gustavo Araújo da Costa Macena - RGM: 30981581
// @author Kauã Vinicius da Silva Cassemiro - RGM: 31675107
// @author Thiago Gomes Delirio - RGM: 31452663
// @author Vitoria Forlim Figueiredo - RGM: 31160204

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    static ArrayList<Carro> estacionamento = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int escolha = 0;
        do {
            System.out.println("\n\t\t\t--- Seja bem vindo ao nosso estacionamento! ---\n\n" +
                    "Escolha uma opção:\n\n"
                    + "1 - Cadastrar veículo\n"
                    + "2 - Remover veículo\n"
                    + "3 - Exibição de veículos estacionados\n"
                    + "4 - Registrar saída de veículos\n\n"

                    + "5 - Sair do Sistema\n");

            System.out.print("Digite a opção desejada: ");
            escolha = scanner.nextInt();
            switch (escolha) {
                case 1:
                    System.out.println("\nEscolha qual seu veiculo \n\n 1 - Carro \n 2 - Moto\n");
                    System.out.print("Digite o tipo do veiculo: ");
                    int EscolhaVeiculo = scanner.nextInt();
                    if(EscolhaVeiculo == 1) {
                        System.out.println("\n----- Cadastrar Carro ----- ");
                        System.out.println("Digite a placa do carro: ");
                        String placaCarro = scanner.next();
                        System.out.println("Digite a marca do carro: ");
                        String marcaCarro = scanner.next();
                        System.out.println("Digite o modelo do carro: ");
                        String modeloCarro = scanner.next();
                        System.out.println("Digite a cor do carro: ");
                        String corCarro = scanner.next();
                        System.out.println("Digite o ano do carro: ");
                        String anoCarro = scanner.next();
                        System.out.println("Digite a data e hora de entrada do carro (Exemplo: 16/07/2022-16:07): ");
                        String entradaCarro = scanner.next();
                        LocalDateTime entradaConvertidaCarro = converterDataHora(entradaCarro);
                        estacionarVeiculo(placaCarro, marcaCarro, modeloCarro, corCarro, anoCarro, entradaConvertidaCarro);
                    } else if (EscolhaVeiculo == 2 ) {
                        System.out.println("\n----- Cadastrar Moto ----- ");
                        System.out.println("Digite a placa da Moto: ");
                        String placaMoto = scanner.next();
                        System.out.println("Digite a marca da Moto: ");
                        String marcaMoto = scanner.next();
                        System.out.println("Digite o modelo da Moto: ");
                        String modeloMoto = scanner.next();
                        System.out.println("Digite a cor da Moto: ");
                        String corMoto = scanner.next();
                        System.out.println("Digite o ano da Moto: ");
                        String anoMoto = scanner.next();
                        System.out.println("Digite a data e hora de entrada da Moto (Exemplo: 16/07/2022-16:07): ");
                        String entradaMoto = scanner.next();
                        //convertendo string em localdatetime para calculo futuro
                        LocalDateTime entradaConvertidaMoto = converterDataHora(entradaMoto);
                        estacionarVeiculo(placaMoto, marcaMoto, modeloMoto, corMoto, anoMoto, entradaConvertidaMoto);
                    }          
                break;
                case 2:
                    System.out.println("\n\t\t\t----- Remover Veiculo ----- ");
                    System.out.println("\nDigite a placa do veiculo que deseja remover: ");
                    String placaRemover = scanner.next();
                    System.out.println(removerVeiculo(placaRemover));
                break;
                case 3:
                    System.out.println("\n\t\t\t----- Lista de Veiculos ----- ");
                    System.out.println("\nOs veículos que esão estacionados são: ");
                    System.out.println(veiculosEstacionados());
                break;
                case 4:
                    System.out.println("\n\t\t\t----- Saída de Veiculo ----- ");
                    System.out.println("\nDigite a placa do veiculo que deseja registrar a saída: ");
                    String placaSaida = scanner.next();
                    System.out.println(saidaDeVeiculo(placaSaida));
                break;
            }
        }while (escolha != 5);
    }
    //----------------------------método para realizar o registro do estacionamento----------------------------------
    //a cada carro cadastrado ele adiciona um novo objeto no array que foi criado na linha 9 e é chamado de estacionamento
    public static void estacionarVeiculo(String placaCarro, String marcaCarro, String modeloCarro,
                                         String corCarro, String anoCarro, LocalDateTime entradaCarro){
        //criando um novo carro
        Carro carro = new Carro(placaCarro, marcaCarro, modeloCarro, corCarro,anoCarro,entradaCarro);
        Moto moto = new Moto(placaCarro, marcaCarro, modeloCarro, corCarro, anoCarro, entradaCarro);
        //adicionando esse novo carro no array
        estacionamento.add(carro);
        System.out.println("\n\t\t\tVeiculo estacionado com sucesso!");
    }
    //-----------------------------------esse método vai listar todos os carros que estão estacionados------------------------------------------
        public static StringBuilder veiculosEstacionados() {
        StringBuilder retorno = new StringBuilder();
        //esse for ele percorre o array estacionamento da posição 0 até o último elemento de 1 em 1
        for(int i = 0; i<estacionamento.size(); i++){
            //a cada elemento encontrado ele constrói essa saída que nada mais é um texto formatado informando placa, modelo e cor
            retorno.append("=====================================================\n" + "Placa: ")
                    .append(estacionamento.get(i).getPlaca()).append("\n")
                    .append("Modelo: ").append(estacionamento.get(i).getModelo())
                    .append("\n").append("Cor: ").append(estacionamento.get(i).getCor()).append("\n")
                    .append("=====================================================\n");
        }
        return retorno;
    }
    //----------------------------------Criado apenas caso o cadastro seja realizado errado e seja necessario remover o veiculo para cadastrar novamente--------------------------------
    public static String removerVeiculo(String placa){
        //esse for ele percorre o array estacionamento da posição 0 até o último elemento de 1 em 1
        for(int i = 0; i<=estacionamento.size()+1; i++){
            //se a placa digitada for igual a alguma placa de algum carro estacionado
            if(placa.equals(estacionamento.get(i).getPlaca())){
                //ele remove o carro e exibe a mensagem
                estacionamento.remove(i);
                return "\nO Veiculo com a placa: "+ placa + " foi removido!";
            } else {
                //caso nao encontre a placa digitada
                return  "\nNenhum Veiculo com essa placa foi encontrado!";
            }
        }
        //caso o array ainda nao tenha recebido nenhum carro
        return "\nNão há nenhum Veiculo estacionado";
        
    }
    static String retorno;
    //--------------------------------método criado para registrar a saída de carros------------------------------------------------
    public static String saidaDeVeiculo(String placa) {
        //esse for ele percorre o array estacionamento da posição 0 até o último elemento de 1 em 1
        for(int i = 0; i <estacionamento.size(); i++) {
            //se a placa digitada for igual a alguma placa de algum carro estacionado
            if(placa.equals(estacionamento.get(i).getPlaca())) {
                //pega a data e hora que o carro deu entrada no estacionamento (isso é feito no momento do cadastro do carro)
                LocalDateTime entrada = estacionamento.get(i).getEntrada();
                //pega a data e hora atual do sistema (pois quando você sai de um estacionamento o atendente nao digita a hora de saída e sim a hora atual)
                LocalDateTime saida = LocalDateTime.now();
                //calcula a diferença entre a entrada e saída
                Duration duration = Duration.between(entrada, saida);
                //deixa essa diferença em horas
                long diferenca = Math.abs(duration.toHours());
                //aqui é o valor da primeira hora do estacionamento
                int valorEntrada = 10;
                //aqui é o valor das demais horas do estacionamento
                int valorHora = 2;
                //aqui ele remove o carro do array, pois se o carro deu saída, ele também tem que ser removido do estacionamento
                estacionamento.remove(i);
                //aqui exibe a mensagem
                return "\nO usuário ficou " + diferenca + " horas no estacionamento.\n" +
                        "\nTotal a pagar R$: " + ((diferenca *  valorHora) + valorEntrada) + ",00";
            } else {
                //caso nao encontre a placa digitada
                retorno = "Nenhum carro com essa placa foi encontrado!";
            }
        }
        //caso o array ainda nao tenha recebido nenhum carro
        retorno = "\nNão há nenhum carro estacionado";
        return retorno;
    }
    //esse método é apenas para converter a data e hora do cadastro para padrão brasileiro
    public static LocalDateTime converterDataHora(String dataHora){
        //esse é o padrão que desejamos
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy-HH:mm");
        //aqui ele pega a data e hora e converte para o padrao java para poder realizar os calculos anteriores
        return LocalDateTime.parse(dataHora, formatter);
    }
}
