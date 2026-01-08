package Application;

import Service.TarefaService;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        TarefaService service = new TarefaService();

        int opcao;

        do {
            System.out.println("\n=== CONTROLE DE TAREFAS ===");
            System.out.println("1 - Cadastrar tarefa");
            System.out.println("2 - Listar tarefas");
            System.out.println("3 - Concluir tarefa");
            System.out.println("4 - Remover tarefa");
            System.out.println("5 - Ver tarefas concluídas");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = sc.nextInt();
            sc.nextLine();

            try {
                switch (opcao) {

                    case 1:
                        System.out.println("\n--- CADASTRAR TAREFA ---");

                        System.out.print("ID da tarefa: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Título da tarefa: ");
                        String titulo = sc.nextLine();

                        service.cadastrarTarefa(id, titulo);
                        break;

                    case 2:
                        System.out.println("\n--- LISTA DE TAREFAS ---");
                        service.listarTarefas();
                        break;

                    case 3:
                        System.out.println("\n--- CONCLUIR TAREFA ---");
                        System.out.print("ID da tarefa para concluir: ");
                        int idConcluir = sc.nextInt();

                        service.concluirTarefa(idConcluir);
                        break;

                    case 4:
                        System.out.print("ID da tarefa para remover: ");
                        int idRemover = sc.nextInt();

                        service.removerTarefa(idRemover);
                        break;

                    case 5:
                        System.out.println("\n--- TAREFAS CONCLUÍDAS ---");
                        service.listarTarefasConcluidas();
                        System.out.println();
                        break;

                    case 0:
                        System.out.println("Programa encerrado.");
                        break;

                    default:
                        System.out.println("Opção inválida.");
                }

            } catch (RuntimeException e) {
                System.out.println("Erro: " + e.getMessage());
            }

        } while (opcao != 0);

        sc.close();
    }
}
