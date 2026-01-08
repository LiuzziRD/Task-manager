package Model;

public class Tarefa {

    private Integer id;
    private String titulo;
    private StatusTarefa status;

    public Tarefa(){
    }

    public Tarefa(Integer id, String titulo, StatusTarefa status) {
        this.id = id;
        this.titulo = titulo;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public StatusTarefa getStatus() {
        return status;
    }

    public void setStatus(StatusTarefa status) {
        this.status = status;
    }

    @Override
    public String toString() {
         return "[" + id + "] "
                + titulo
                + " - "
                + status;
    }


}
