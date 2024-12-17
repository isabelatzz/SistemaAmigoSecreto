package sistema.amigo.Isabela;

import java.util.ArrayList;
import java.util.List;

public class SistemaAmigo {
    private List<Mensagem> mensagens;
    private List<Amigo> amigos;

    public SistemaAmigo() {
        this.mensagens = new ArrayList<>();
        this.amigos = new ArrayList<>();
    }

    public void cadastraAmigo(String nome, String email) {
        Amigo novoAmigo = new Amigo(nome, email);
        amigos.add(novoAmigo);
    }

    public Amigo pesquisaAmigo(String email) {
        for (Amigo amigo : amigos) {
            if (amigo.getEmail().equalsIgnoreCase(email)) {
                return amigo;
            }
        }
        return null;
    }

    public void enviarMensagemParaTodos(String texto, String emailRemetente, boolean anonima) {
        Amigo remetente = pesquisaAmigo(emailRemetente);
        if (remetente == null) {
            System.out.println("Remetente não encontrado no sistema!");
            return;
        }
        MensagemParaTodos mensagem = new MensagemParaTodos(texto, emailRemetente, anonima);
        mensagens.add(mensagem);
    }

    public void enviarMensagemParaAlguem(String texto, String emailRemetente, String emailDestinatario, boolean anonima) {
        Amigo remetente = pesquisaAmigo(emailRemetente);
        if (remetente == null) {
            System.out.println("Remetente não encontrado no sistema!");
            return;
        }

        MensagemParaAlguem mensagensAlguem = new MensagemParaAlguem(emailRemetente, emailDestinatario, anonima);
        mensagens.add(mensagensAlguem);
    }

    public List<Mensagem> pesquisaMensagemAnonima() {
        List<Mensagem> mensagensAnonimas = new ArrayList<>();

        for (Mensagem mensagem : mensagens) {
            if (mensagem.ehAnonima()) {
                mensagensAnonimas.add(mensagem);
            }
        }
        return mensagensAnonimas;
    }

    public List<Mensagem> pesquisaTodasAsMensagens() {
        return mensagens;
    }


    public void configuraAmigoSecretoDe(String email, String emailAmigoSorteado) throws AmigoInexistenteException {
        Amigo amigo = pesquisaAmigo(email);
         if (amigo == null){
             throw new AmigoInexistenteException("Amigo com o email " + email + "não encontrado.");
         }

         Amigo amigoSorteado = pesquisaAmigo(emailAmigoSorteado);

         if (amigoSorteado == null) {
             throw new AmigoInexistenteException("Amigo sorteado com o email " + emailAmigoSorteado + "não encontrado.");
         }

         amigo.setEmailAmigoSorteado(emailAmigoSorteado);
         System.out.println("Amigo secreto de: " + amigo.getNome() + " é " + amigoSorteado.getNome());
    }

    public String pesquisaAmigoSecretoDe(String email) throws AmigoInexistenteException, AmigoNaoSorteadoException {
        Amigo amigo = pesquisaAmigo(email);

        if (amigo == null) {
            throw new AmigoInexistenteException("Amigo com e-mail " + email + " não encontrado.");
        }

        String amigoSecretoEmail = amigo.getEmailAmigoSorteado();

        if (amigoSecretoEmail == null) {
            throw new AmigoNaoSorteadoException("Amigo secreto não foi sorteado para " + amigo.getNome() + ".");
        }
        return amigoSecretoEmail;
    }

    public List <Amigo> getAmigos() {
        return amigos;
    }

}

