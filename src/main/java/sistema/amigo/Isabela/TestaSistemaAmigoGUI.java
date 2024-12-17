package sistema.amigo.Isabela;

import java.util.Scanner;

public class TestaSistemaAmigoGUI {
    public static void main(String[] args) {
        SistemaAmigo sistemaAmigo = new SistemaAmigo();

        Scanner sc = new Scanner(System.in);

        try{
            System.out.println("Digite a quantidade total de amigos na brincadeira: ");
            int totalAmigos = Integer.parseInt(sc.nextLine());

            for (int i = 1; i <= totalAmigos; i++){
                System.out.println("Amigo " + i + ":");
                System.out.println("Nome: ");
                String nome = sc.nextLine();
                System.out.println("Email: ");
                String email = sc.nextLine();

                sistemaAmigo.cadastraAmigo(nome, email);
                System.out.println("Amigo cadastrado com sucesso!");
            }

            System.out.println("Configuração do sorteio dos amigos secretos:");
            for (Amigo amigo : sistemaAmigo.getAmigos()){
                System.out.print("Digite o e-mail do amigo sorteado para " + amigo.getNome() + ": ");
                String emailAmigoSorteado = sc.nextLine();

                try {
                    sistemaAmigo.configuraAmigoSecretoDe(amigo.getEmail(), emailAmigoSorteado);
                    System.out.println("Amigo secreto configurado para " + amigo.getNome() + " com sucesso!\n");
                } catch (AmigoInexistenteException e) {
                    System.out.println("Erro: " + e.getMessage() + "\n");
                }
            }

            System.out.println("Envio de mensagem:");
            System.out.print("Digite o e-mail do remetente: ");
            String emailRemetente = sc.nextLine();
            System.out.print("Digite o texto da mensagem: ");
            String textoMensagem = sc.nextLine();
            System.out.print("A mensagem é anônima? (sim/nao): ");
            boolean anonima = sc.nextLine().equalsIgnoreCase("sim");

            sistemaAmigo.enviarMensagemParaTodos(textoMensagem, emailRemetente, anonima);
            System.out.println("Mensagem enviada com sucesso!");

        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Por favor, digite um número válido.");
        } finally {
            sc.close();
        }
    }
}








