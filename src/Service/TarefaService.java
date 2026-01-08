package Service;

import Model.StatusTarefa;
import Model.Tarefa;

import java.util.ArrayList;
import java.util.List;

public class TarefaService {

    private List<Tarefa> tarefas = new ArrayList<>();
    private int proximoId = 1;

    // Cadastrar tarefa
    public void cadastrarTarefa(int id, String titulo) {
        Tarefa tarefa = new Tarefa(
                proximoId,
                titulo,
                StatusTarefa.PENDENTE
        );
        tarefas.add(tarefa);
        proximoId++;
    }

    // Listar tarefas
    public void listarTarefas() {
        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa cadastrada.");
            return;
        }

        for (Tarefa tarefa : tarefas) {
            System.out.println(tarefa);
        }
    }

    // Buscar tarefa por ID
    public Tarefa buscarTarefaPorId(int id) {
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getId() == id) {
                return tarefa;
            }
        }
        return null;
    }

    // Concluir tarefa
    public void concluirTarefa(int id) {
        Tarefa tarefa = buscarTarefaPorId(id);

        if (tarefa == null) {
            System.out.println("Tarefa não encontrada.");
            return;
        }

        tarefa.setStatus(StatusTarefa.CONCLUIDA);
        System.out.println("Tarefa '" + tarefa.getTitulo() + "' concluída.");
    }

    // Remover tarefa
    public void removerTarefa(int id) {
        Tarefa tarefa = buscarTarefaPorId(id);

        if (tarefa == null) {
            System.out.println("Tarefa não encontrada.");
            return;
        }

        tarefas.remove(tarefa);
        System.out.println("Tarefa '" + tarefa.getTitulo() + "' removida.");
    }

    //Tarefas concluidas
    public void listarTarefasConcluidas() {
        boolean encontrou = false;

        for (Tarefa tarefa : tarefas) {
            if (tarefa.getStatus() == StatusTarefa.CONCLUIDA) {
                System.out.println(tarefa);
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhuma tarefa concluída até o momento.");
        }
    }
}