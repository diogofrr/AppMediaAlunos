package devandroid.diogoferreira.aplicativomediaescolar.controller;

import android.content.ContentValues;

import devandroid.diogoferreira.aplicativomediaescolar.database.AlunoDB;
import devandroid.diogoferreira.aplicativomediaescolar.model.Aluno;
import devandroid.diogoferreira.aplicativomediaescolar.view.MainActivity;

public class AlunoController extends AlunoDB {
    public AlunoController(MainActivity mainActivity) {
        super(mainActivity);
    }

    public void adicionarAluno(Aluno aluno) {

        ContentValues dados = new ContentValues();

        dados.put(COLUMN_NOME, aluno.getNome());
        dados.put(COLUMN_NOTA1, aluno.getNota1());
        dados.put(COLUMN_NOTA2, aluno.getNota2());
        dados.put(COLUMN_NOTA3, aluno.getNota3());
        dados.put(COLUMN_NOTA4, aluno.getNota4());
        dados.put(COLUMN_DISCIPLINA, aluno.getDisciplina());
        dados.put(COLUMN_MEDIA, aluno.getMedia());
        dados.put(COLUMN_STATUS, aluno.getStatus());

        salvarObjeto(TABLE_NAME, dados);
    }
}

