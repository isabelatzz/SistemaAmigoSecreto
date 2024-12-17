package sistema.amigo.Isabela;

import java.util.List;

public class TestaSistemaAmigo {
    public static void main(String[] args) {
        SistemaAmigo sitemaAmigo = new SistemaAmigo();

        sitemaAmigo.cadastraAmigo("José", "jose@gmail.com");
        sitemaAmigo.cadastraAmigo("Maria", "maria@gmail.com");


        try {
            sitemaAmigo.configuraAmigoSecretoDe("jose@gmail.com", "maria@gmail.com");
            sitemaAmigo.configuraAmigoSecretoDe("maria@gmail.com", "jose@gmail.com");
        } catch (AmigoInexistenteException e ) {
            System.out.println("Erro ao configurar amigo secreto de " + e.getMessage());
        }

        sitemaAmigo.enviarMensagemParaAlguem("Olá José, sou sua amiga secreta!", "maria@gmail.com", "jose@gmail.com", true);

        sitemaAmigo.enviarMensagemParaTodos("Oi pessoal!", "maria@gmail.com", true);

        List<Mensagem> mensagensAnonimas = sitemaAmigo.pesquisaMensagemAnonima();
        System.out.println("Mensagens anônimas");
        for (Mensagem mensagem : mensagensAnonimas) {
            System.out.println(mensagem.getTextoCompletoExibir());
        }

        try {
            String emailAmigoSecretodeJose = sitemaAmigo.pesquisaAmigoSecretoDe("jose@gmail.com");
            if (emailAmigoSecretodeJose.equals("maria@gmail.com")) {
                System.out.println("Ok. O amigo secreto de José é Maria.");
            } else {
                System.out.println("Erro. O amigo secreto de José não é Maria.");
            }
        } catch (AmigoInexistenteException | AmigoNaoSorteadoException e ){
            System.out.println("Erro ao configurar amigo secreto de " + e.getMessage());
        }
    }
}
