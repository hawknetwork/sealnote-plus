package org.hawknetwork.sealnoteplus.data;

import android.database.Cursor;
import android.widget.ListAdapter;

public interface NoteListAdapter extends ListAdapter {
    public Cursor   getCursor();
    public void     clearCursor();
    public void     changeCursor(Cursor cursor);
    public void     setFolder(Note.Folder folder, int tagid);
    public void     startActionMode();
}
