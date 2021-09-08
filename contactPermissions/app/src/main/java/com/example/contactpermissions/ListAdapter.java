package com.example.contactpermissions;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class ListAdapter extends CursorAdapter {
    private final static int CONTACT_ID_INDEX = 0;
    private final static int CONTACT_NAME_INDEX = 1;
    private final static int CONTACT_STARRED = 2;

    public ListAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from
                (context).inflate(R.layout.list_item, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        int idCont = cursor.getInt(CONTACT_ID_INDEX);
        String nameCont = cursor.getString(CONTACT_NAME_INDEX);
        boolean starred = (cursor.getInt(CONTACT_STARRED) == 1);

        TextView idContactText = (TextView) view.findViewById(R.id.idContact);
        TextView nameContactText = view.findViewById(R.id.nameContact);
        CheckBox starredCheckbox = view.findViewById(R.id.checkBoxStarred);

        idContactText.setText(String.valueOf(idCont));
        nameContactText.setText(nameCont);
        starredCheckbox.setChecked(starred);
    }
}
