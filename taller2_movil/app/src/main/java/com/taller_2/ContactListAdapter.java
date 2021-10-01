package com.taller_2;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ContactListAdapter extends CursorAdapter {
    private final static int CONTACT_ID_INDEX = 0;
    private final static int CONTACT_NAME_INDEX = 1;
    public ContactListAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.contact_item,viewGroup,false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        int idCont = cursor.getInt(CONTACT_ID_INDEX);
        String nameCont = cursor.getString(CONTACT_NAME_INDEX);


        TextView idContactText = (TextView) view.findViewById(R.id.idContact);
        TextView nameContactText = view.findViewById(R.id.nameContact);
        ImageView im = view.findViewById(R.id.iconContact);
        idContactText.setText(String.valueOf(idCont));
        nameContactText.setText(nameCont);


    }
}
