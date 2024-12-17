package sistema.amigo.Isabela;

public class MensagemParaTodos extends Mensagem{
    public MensagemParaTodos (String texto, String emailRemetente, boolean anonima){
        super (texto, emailRemetente, anonima);
    }

    public String getTextoCompletoExibir() {
        if (ehAnonima()) {
            return "Mensagem anônima: " + getTexto();
        } else {
            return "Mensagem para todos. Texto: " + getTexto();
        }
    }
}
