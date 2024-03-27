import java.util.Scanner;

public class MenuAgenda {
    private AgendaTelefonica agenda;
    private Scanner scanner;

    public MenuAgenda() {
        agenda = new AgendaTelefonica();
        scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        int opcao = 0;

        do {
            try {
                System.out.println("\n### Agenda Telefônica ###");
                System.out.println("1. Adicionar Contato");
                System.out.println("2. Buscar Contato");
                System.out.println("3. Apagar Contato");
                System.out.println("4. Listar Contatos");
                System.out.println("5. Sair");
                System.out.print("Escolha uma opção: ");
                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        System.out.print("Digite o nome do contato: ");
                        String nome = scanner.nextLine();
                        System.out.print("Digite o número do contato: ");
                        String numero = scanner.nextLine();
                        agenda.adicionarContato(nome, numero);
                        System.out.println("Contato adicionado com sucesso!");
                        break;
                    case 2:
                        System.out.print("Digite o nome do contato a ser buscado: ");
                        String nomeBusca = scanner.nextLine();
                        Contato contatoBuscado = agenda.buscarContato(nomeBusca);
                        if (contatoBuscado != null) {
                            System.out.println("Contato encontrado: " + contatoBuscado);
                        } else {
                            System.out.println("Contato não encontrado.");
                        }
                        break;
                    case 3:
                        System.out.print("Digite o nome do contato a ser apagado: ");
                        String nomeApagar = scanner.nextLine();
                        agenda.apagarContato(nomeApagar);
                        break;
                    case 4:
                        System.out.println("Listando todos os contatos:");
                        agenda.listarContatos();
                        break;
                    case 5:
                        System.out.println("Encerrando a agenda.");
                        break;
                    default:
                        throw new IllegalArgumentException("Opção inválida. Por favor, escolha uma opção entre 1 e 5.");

                }
            } catch (IllegalArgumentException e) {
                System.out.println("Ocorreu um erro! " + e.getMessage());

            }
        } while (opcao != 5);

        scanner.close();
    }
}
