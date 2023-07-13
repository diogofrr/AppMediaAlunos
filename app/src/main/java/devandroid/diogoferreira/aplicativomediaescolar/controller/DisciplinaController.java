package devandroid.diogoferreira.aplicativomediaescolar.controller;
import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class DisciplinaController {
    private Context context;
    private Spinner spinner;

    public DisciplinaController(Context context, Spinner spinner) {
        this.context = context;
        this.spinner = spinner;
        setupSpinner();
    }

    private void setupSpinner() {
        List<String> disciplinas = new ArrayList<>();
        disciplinas.add("Matemática");
        disciplinas.add("Português");
        disciplinas.add("Geografia");
        disciplinas.add("História");
        disciplinas.add("Física");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, disciplinas);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }
}
