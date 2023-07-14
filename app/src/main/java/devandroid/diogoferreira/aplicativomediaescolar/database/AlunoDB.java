package devandroid.diogoferreira.aplicativomediaescolar.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AlunoDB extends SQLiteOpenHelper {
    protected static final int DATABASE_VERSION = 1;
    protected static final String DATABASE_NAME = "media_escolar.db";
    protected static final String TABLE_NAME = "alunos";

    protected static final String COLUMN_ID = "id";
    protected static final String COLUMN_NOME = "nome";
    protected static final String COLUMN_NOTA1 = "nota1";
    protected static final String COLUMN_NOTA2 = "nota2";
    protected static final String COLUMN_NOTA3 = "nota3";
    protected static final String COLUMN_NOTA4 = "nota4";
    protected static final String COLUMN_MEDIA = "media";
    protected static final String COLUMN_DISCIPLINA = "disciplina";
    protected static final String COLUMN_STATUS = "status";

    protected SQLiteDatabase db;

    public AlunoDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = "CREATE TABLE " + TABLE_NAME + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NOME + " TEXT, " +
                COLUMN_DISCIPLINA + " TEXT, " +
                COLUMN_NOTA1 + " INTEGER, " +
                COLUMN_NOTA2 + " INTEGER, " +
                COLUMN_NOTA3 + " INTEGER, " +
                COLUMN_NOTA4 + " INTEGER, " +
                COLUMN_MEDIA + " INTEGER, " +
                COLUMN_STATUS + " TEXT)";

        db.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void salvarObjeto(String tabela, ContentValues dados) {
        db.insert(tabela, null, dados);
    }

}
