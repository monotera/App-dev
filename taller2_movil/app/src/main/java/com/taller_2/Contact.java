package com.taller_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Contact extends AppCompatActivity {
    public static final int CONTACTS_PERM_ID = 5;
    String permContacts = Manifest.permission.READ_CONTACTS;

    String[] mProjection;
    Cursor mCursor;
    ContactListAdapter mContactsAdapter;
    ListView mContactListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        mContactListView = findViewById((R.id.contactList));
        mProjection = new String[]{
                ContactsContract.Profile._ID,
                ContactsContract.Profile.DISPLAY_NAME_PRIMARY,

        };
        mContactsAdapter = new ContactListAdapter(this,null,0);
        mContactListView.setAdapter(mContactsAdapter);
        requestPermission(this, permContacts, "Contacts are requiered to display list", CONTACTS_PERM_ID);
        initView();


    }
    private void initView() {
        if(ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_CONTACTS)
                == PackageManager.PERMISSION_GRANTED){
            mCursor = getContentResolver().query(
                    ContactsContract.Contacts.CONTENT_URI,
                    mProjection,
                    null,
                    null,
                    null);
            mContactsAdapter.changeCursor(mCursor);
        }
    }
    private void requestPermission(Activity context, String permission, String justification, int id) {
        if (ContextCompat.checkSelfPermission(context, permission)
                != PackageManager.PERMISSION_GRANTED) {
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(context,
                    Manifest.permission.READ_CONTACTS)) {
                Toast.makeText(context, justification, Toast.LENGTH_SHORT).show();
            }
            // request the permission.
            ActivityCompat.requestPermissions(context, new String[]{permission}, id);
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == CONTACTS_PERM_ID){
            initView();
        }
    }
}