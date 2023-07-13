package devandroid.diogoferreira.aplicativomediaescolar.model;

public class Aluno {
    private String nome;
    private int matematica;
    private int portugues;
    private int geografia;
    private int historia;
    private int fisica;

    public Aluno() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMatematica() {
        return matematica;
    }

    public void setMatematica(int matematica) {
        this.matematica = matematica;
    }

    public int getPortugues() {
        return portugues;
    }

    public void setPortugues(int portugues) {
        this.portugues = portugues;
    }

    public int getGeografia() {
        return geografia;
    }

    public void setGeografia(int geografia) {
        this.geografia = geografia;
    }

    public int getHistoria() {
        return historia;
    }

    public void setHistoria(int historia) {
        this.historia = historia;
    }

    public int getFisica() {
        return fisica;
    }

    public void setFisica(int fisica) {
        this.fisica = fisica;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "nome='" + nome + '\'' +
                ", matematica=" + matematica +
                ", portugues=" + portugues +
                ", geografia=" + geografia +
                ", historia=" + historia +
                ", fisica=" + fisica +
                '}';
    }
}
