package devandroid.diogoferreira.aplicativomediaescolar.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import devandroid.diogoferreira.aplicativomediaescolar.R;
import devandroid.diogoferreira.aplicativomediaescolar.controller.DisciplinaController;
import devandroid.diogoferreira.aplicativomediaescolar.model.Aluno;

public class MainActivity extends AppCompatActivity {
    Aluno aluno = new Aluno();

    DisciplinaController disciplinaController;

    EditText nomeInput;

    EditText primeiroBimestre;
    EditText segundoBimestre;
    EditText terceiroBimestre;
    EditText quartoBimestre;

    Spinner spinner;

    Button calcularMedia;

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

        nomeInput = findViewById(R.id.nomeInput);

        primeiroBimestre = findViewById(R.id.primeiroBimestre);
        segundoBimestre = findViewById(R.id.segundoBimestre);
        terceiroBimestre = findViewById(R.id.terceiroBimestre);
        quartoBimestre = findViewById(R.id.quartoBimestre);

        spinner = findViewById(R.id.spinner);

        calcularMedia = findViewById(R.id.calcularMedia);

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

                aluno.setNome(nome);

                int primeiro = Integer.parseInt(primeiroBimestre.getText().toString());
                int segundo = Integer.parseInt(segundoBimestre.getText().toString());
                int terceiro = Integer.parseInt(terceiroBimestre.getText().toString());
                int quarto = Integer.parseInt(quartoBimestre.getText().toString());

                String disciplinaSelecionada = spinner.getSelectedItem().toString();

                int media = (int) (primeiro + segundo + terceiro + quarto);

                atualizarResultado(disciplinaSelecionada, media, aluno);
                exibirMensagemCalculoRealizado();
            } catch (NumberFormatException error) {
                Toast.makeText(this, "Preencha valores válidos nos campos.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void atualizarResultado(@NonNull String disciplina, int media, Aluno aluno) {
        TextView statusTextView = null;
        TextView resultadoTextView = null;

        switch (disciplina) {
            case "Matemática":
                statusTextView = matematicaStatus;
                resultadoTextView = matematicaResultado;
                aluno.setMatematica(media);
                break;
            case "Português":
                statusTextView = portuguesStatus;
                resultadoTextView = portuguesResultado;
                aluno.setPortugues(media);
                break;
            case "Geografia":
                statusTextView = geografiaStatus;
                resultadoTextView = geografiaResultado;
                aluno.setGeografia(media);
                break;
            case "História":
                statusTextView = historiaStatus;
                resultadoTextView = historiaResultado;
                aluno.setHistoria(media);
                break;
            case "Física":
                statusTextView = fisicaStatus;
                resultadoTextView = fisicaResultado;
                aluno.setFisica(media);
                break;
        }

        if (statusTextView != null && resultadoTextView != null) {
            String status;
            String mediaString = Integer.toString(media);

            if (media >= 60) {
                status = "Aprovado";
            } else {
                status = "Reprovado";
            }

            statusTextView.setText(status);
            resultadoTextView.setText(mediaString);
        }
    }

    private void exibirMensagemCalculoRealizado() {
        Toast.makeText(this, "Cálculo realizado com sucesso!", Toast.LENGTH_SHORT).show();
    }
}