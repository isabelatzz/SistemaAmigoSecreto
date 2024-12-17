package sistema.amigo.Isabela;

public class MensagemParaAlguem extends Mensagem {
    private String emailDestinatario;

    public MensagemParaAlguem (String emailRemetente, String emailDestinatario, boolean anonima){
        super(emailRemetente, emailDestinatario, anonima);
    }

    public String getEmailDestinatario(){
        return emailDestinatario;
    }

    public void setEmailDestinatario(String emailDestinatario){
        this.emailDestinatario = emailDestinatario;
    }

    public String getTextoCompletoExibir() {
        if (ehAnonima()) {
            return "Mensagem anônima: " + getTexto();
        } else {
            return "Mensagem para: " + getEmailDestinatario() + "." + "Texto: " + getTexto();
        }
    }
}
