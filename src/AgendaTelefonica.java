import java.util.Map;
import java.util.HashMap;

public class AgendaTelefonica {
    private Map<String, Contato> agenda;

    public AgendaTelefonica() {
        agenda = new HashMap<>();
    }

    public void adicionarContato(String nome, String numero) {
        if (nome == null || nome.isEmpty() || numero == null || numero.isEmpty()) {
            throw new IllegalArgumentException("Nome ou número inválido.");
        }

        Contato novoContato = new Contato(nome, numero);
        agenda.put(nome, novoContato);
    }

    public Contato buscarContato(String nome) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome inválido para busca.");
        }

        return agenda.get(nome);
    }

    public void apagarContato(String nome) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome inválido para exclusão.");
        }

        if (agenda.containsKey(nome)) {
            agenda.remove(nome);
            System.out.println("Contato removido com sucesso.");
        } else {
            System.out.println("Contato não encontrado.");
        }
    }

    public void listarContatos() {
        if (agenda.isEmpty()) {
            System.out.println("Agenda vazia.");
        } else {
            for (Contato contato : agenda.values()) {
                System.out.println(contato);
            }
        }
    }
}