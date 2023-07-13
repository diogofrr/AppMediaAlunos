package devandroid.diogoferreira.aplicativomediaescolar.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AlunoDB extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "aluno.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_ALUNO = "aluno";
    private static final String ID = "id";
    private static final String NOME = "nome";
    private static final String MEDIA_MATEMATICA = "MEDIA_MATEMATICA";
    private static final String MEDIA_PORTUGUES = "MEDIA_PORTUGUES";
    private static final String MEDIA_FISICA = "MEDIA_FISICA";
    private static final String MEDIA_GEOGRAFIA = "MEDIA_GEOGRAFIA";
    private static final String MEDIA_HISTORIA = "MEDIA_HISTORIA";

    public AlunoDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = "CREATE TABLE " + TABLE_ALUNO + " (" +
                ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                NOME + " TEXT, " +
                MEDIA_MATEMATICA + " INTEGER, " +
                MEDIA_PORTUGUES + " INTEGER, " +
                MEDIA_FISICA + " INTEGER, " +
                MEDIA_GEOGRAFIA + " INTEGER, " +
                MEDIA_HISTORIA + " INTEGER" +
                ")";
        db.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String dropTableQuery = "DROP TABLE IF EXISTS " + TABLE_ALUNO;
        db.execSQL(dropTableQuery);
        onCreate(db);
    }

    public void salvarAluno(String nome, double[] medias) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NOME, nome);
        values.put(COLUMN_MEDIA_1, medias[0]);
        values.put(COLUMN_MEDIA_2, medias[1]);
        values.put(COLUMN_MEDIA_3, medias[2]);
        values.put(COLUMN_MEDIA_4, medias[3]);
        values.put(COLUMN_MEDIA_5, medias[4]);
        db.insert(TABLE_ALUNO, null, values);
        db.close();
    }

    public Cursor obterAlunos() {
        SQLiteDatabase db = getReadableDatabase();
        String[] columns = {
                COLUMN_ID,
                COLUMN_NOME,
                COLUMN_MEDIA_1,
                COLUMN_MEDIA_2,
                COLUMN_MEDIA_3,
                COLUMN_MEDIA_4,
                COLUMN_MEDIA_5
        };
        return db.query(TABLE_ALUNO, columns, null, null, null, null, null);
    }
}
