package com.twistedplane.sealnote.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.twistedplane.sealnote.SealnoteApplication;
import com.twistedplane.sealnote.utils.EasyDate;
import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {
    public static final String DBNAME = "sealnote.sqlite";
    public static final int VERSION = 1;

    // table and column names names
    public static final String TABLE_NAME = "notes";
    public static final String COL_ID = "_id";
    public static final String COL_POSITION = "position";
    public static final String COL_TITLE = "title";
    public static final String COL_NOTE = "content";
    public static final String COL_COLOR = "color";
    public static final String COL_CREATED = "created";
    public static final String COL_EDITED = "edited";

    public DatabaseHandler(Context context) {
        super(context, DBNAME, null, VERSION);
    }

    public static Note cursorToNote(Cursor cursor) {
        //FIXME
        Note note = new Note();
        try {
            note.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COL_ID))));
            note.setPosition(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COL_POSITION))));
            note.setTitle(cursor.getString(cursor.getColumnIndex(COL_TITLE)));
            note.setNote(cursor.getString(cursor.getColumnIndex(COL_NOTE)));
            note.setEditedDate(EasyDate.fromIsoString(cursor.getString(cursor.getColumnIndex(COL_EDITED))));
            note.setColor(cursor.getInt(cursor.getColumnIndex(COL_COLOR)));
        } catch (Exception e) {
            return null;
        }
        return note;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " ( " +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                COL_POSITION + " INTEGER, " +
                COL_TITLE + " TEXT, " +
                COL_NOTE + " TEXT, " +
                COL_COLOR + " INTEGER, " +
                COL_CREATED + " TEXT, " +
                COL_EDITED + " TEXT " + " ) ";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // do nothing for now
    }

    public void addNote(Note note) {
        SQLiteDatabase db = this.getWritableDatabase(SealnoteApplication.getPassword());
        ContentValues values = new ContentValues();
        EasyDate date = EasyDate.now();

        values.put(COL_POSITION, note.getPosition());
        values.put(COL_TITLE, note.getTitle());
        values.put(COL_NOTE, note.getNote());
        values.put(COL_COLOR, note.getColor());
        values.put(COL_CREATED, date.toString());
        values.put(COL_EDITED, date.toString());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public void updateNote(Note note) {
        SQLiteDatabase db = this.getWritableDatabase(SealnoteApplication.getPassword());
        ContentValues values = new ContentValues();

        values.put(COL_ID, note.getId());
        values.put(COL_POSITION, note.getPosition());
        values.put(COL_TITLE, note.getTitle());
        values.put(COL_NOTE, note.getNote());
        values.put(COL_COLOR, note.getColor());
        values.put(COL_EDITED, EasyDate.now().toString());
        db.update(TABLE_NAME, values, COL_ID + " = ?", new String[]{Integer.toString(note.getId())});
        db.close();
    }

    public Note getNote(int id) {
        SQLiteDatabase db = this.getReadableDatabase(SealnoteApplication.getPassword());
        Cursor cursor = db.query(TABLE_NAME, null, COL_ID + " = ?", new String[]{Integer.toString(id)},
                null, null, null, null);
        if (cursor.moveToFirst()) {
            return cursorToNote(cursor);
        }
        return null;
    }

    public void deleteNote(int id) {
        SQLiteDatabase db = this.getWritableDatabase(SealnoteApplication.getPassword());
        db.delete(TABLE_NAME, COL_ID + " = ?", new String[] {Integer.toString(id)});
        db.close();
    }

    public List<Note> getAllNotes() {
        List<Note> list = new ArrayList<Note>();
        SQLiteDatabase db = getReadableDatabase(SealnoteApplication.getPassword());
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        if (cursor.moveToFirst()) {
            do {
                list.add(cursorToNote(cursor));
            } while (cursor.moveToNext());
        }

        db.close();
        return list;
    }

    public Cursor getAllNotesCursor() {
        return getReadableDatabase(SealnoteApplication.getPassword()).rawQuery("SELECT * FROM " + TABLE_NAME, null);
    }

}