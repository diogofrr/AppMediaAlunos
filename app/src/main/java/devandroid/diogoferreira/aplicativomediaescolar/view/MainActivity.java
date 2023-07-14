package devandroid.diogoferreira.aplicativomediaescolar.view;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import devandroid.diogoferreira.aplicativomediaescolar.R;
import devandroid.diogoferreira.aplicativomediaescolar.controller.AlunoController;
import devandroid.diogoferreira.aplicativomediaescolar.controller.DisciplinaController;
import devandroid.diogoferreira.aplicativomediaescolar.model.Aluno;

public class MainActivity extends AppCompatActivity {
    Aluno aluno;
    AlunoController alunoController;
    DisciplinaController disciplinaController;

    EditText nomeInput;

    EditText primeiroBimestre;
    EditText segundoBimestre;
    EditText terceiroBimestre;
    EditText quartoBimestre;

    Spinner spinner;

    Button calcularMedia;
    Button limparDados;
    Button salvarDados;

    TextView matematicaStatus;
    TextView matematicaResultado;

    TextView portuguesStatus;
    TextView portuguesResultado;

    TextView geografiaStatus;
    TextView geografiaResultado;

    TextView historiaStatus;
    TextView historiaResultado;

    TextView fisicaStatus;
    TextView fisicaResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alunoController = new AlunoController(this);

        nomeInput = findViewById(R.id.nomeInput);

        primeiroBimestre = findViewById(R.id.primeiroBimestre);
        segundoBimestre = findViewById(R.id.segundoBimestre);
        terceiroBimestre = findViewById(R.id.terceiroBimestre);
        quartoBimestre = findViewById(R.id.quartoBimestre);

        spinner = findViewById(R.id.spinner);

        calcularMedia = findViewById(R.id.calcularMedia);
        limparDados = findViewById(R.id.limparDados);
        salvarDados = findViewById(R.id.salvarDados);

        matematicaStatus = findViewById(R.id.matematicaStatus);
        matematicaResultado = findViewById(R.id.matematicaResultado);

        portuguesStatus = findViewById(R.id.portuguesStatus);
        portuguesResultado = findViewById(R.id.portuguesResultado);

        geografiaStatus = findViewById(R.id.geografiaStatus);
        geografiaResultado = findViewById(R.id.geografiaResultado);

        historiaStatus = findViewById(R.id.historiaStatus);
        historiaResultado = findViewById(R.id.historiaResultado);

        fisicaStatus = findViewById(R.id.fisicaStatus);
        fisicaResultado = findViewById(R.id.fisicaResultado);

        disciplinaController = new DisciplinaController(this, spinner);

        calcularMedia.setOnClickListener(view -> {
            try {
                String nome = nomeInput.getText().toString();

                String status;

                double primeiro = Double.parseDouble(primeiroBimestre.getText().toString());
                double segundo = Double.parseDouble(segundoBimestre.getText().toString());
                double terceiro = Double.parseDouble(terceiroBimestre.getText().toString());
                double quarto = Double.parseDouble(quartoBimestre.getText().toString());

                String disciplinaSelecionada = spinner.getSelectedItem().toString();

                double media = (primeiro + segundo + terceiro + quarto)/4;

                if (media >= 60) {
                    status = "Aprovado";
                } else {
                    status = "Reprovado";
                }

                aluno.setNome(nome);

                aluno.setDisciplina(disciplinaSelecionada);

                aluno.setNota1(primeiro);
                aluno.setNota2(segundo);
                aluno.setNota3(terceiro);
                aluno.setNota4(quarto);

                aluno.setMedia(media);

                aluno.setStatus(status);

                atualizarResultado(aluno);
                exibirMensagemCalculoRealizado();
            } catch (NumberFormatException error) {
                Toast.makeText(this, "Preencha valores válidos nos campos.", Toast.LENGTH_SHORT).show();
            }
        });

        limparDados.setOnClickListener(view -> limparCampos());

        salvarDados.setOnClickListener(view -> {
            if (aluno.getStatus().equals("")) {
                alunoController.adicionarAluno(aluno);
            } else {
                Toast.makeText(this, "Nenhum cálculo foi realizado", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @SuppressLint("SetTextI18n")
    private void atualizarResultado(Aluno aluno) {
        TextView statusTextView = null;
        TextView resultadoTextView = null;

        switch (aluno.getDisciplina()) {
            case "Matemática":
                statusTextView = matematicaStatus;
                resultadoTextView = matematicaResultado;
                break;
            case "Português":
                statusTextView = portuguesStatus;
                resultadoTextView = portuguesResultado;
                break;
            case "Geografia":
                statusTextView = geografiaStatus;
                resultadoTextView = geografiaResultado;
                break;
            case "História":
                statusTextView = historiaStatus;
                resultadoTextView = historiaResultado;
                break;
            case "Física":
                statusTextView = fisicaStatus;
                resultadoTextView = fisicaResultado;
                break;
        }

        if (statusTextView != null && resultadoTextView != null) {
            statusTextView.setText(aluno.getStatus());
            resultadoTextView.setText(Double.toString(aluno.getMedia()));
        }
    }

    private void limparCampos() {
        matematicaStatus.setText("-------");
        matematicaResultado.setText("-");

        portuguesResultado.setText("-");
        portuguesStatus.setText("-------");

        historiaResultado.setText("-");
        historiaStatus.setText("-------");

        geografiaResultado.setText("-");
        geografiaStatus.setText("-------");

        fisicaResultado.setText("-");
        fisicaStatus.setText("-------");

        nomeInput.setText("");
        primeiroBimestre.setText("");
        segundoBimestre.setText("");
        terceiroBimestre.setText("");
        quartoBimestre.setText("");
    }

    private void exibirMensagemCalculoRealizado() {
        Toast.makeText(this, "Cálculo realizado com sucesso!", Toast.LENGTH_SHORT).show();
    }
}