package com.example.janesoo.reankour.adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.janesoo.reankour.DetatilActivity;
import com.example.janesoo.reankour.R;
import com.example.janesoo.reankour.fragment.FragmentTutor;
import com.example.janesoo.reankour.model.User;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

/**
 * Created by JaneSoo on 17-Jun-17.
 */

public class TutorAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<User> listofTutor;
    private int layout;
    StorageReference storageReference;

    public TutorAdapter(Context context, int layout, ArrayList<User> listofTutor){
        this.context = context;
        this.layout=layout;
        this.listofTutor =listofTutor;
    }

    @Override
    public int getCount() {
        return listofTutor.size();
    }

    @Override
    public Object getItem(int position) {
        return listofTutor.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final LayoutInflater inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        final View view = inflater.inflate(R.layout.tutors_item_layout,null);

        final ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
        TextView tutorName = (TextView) view.findViewById(R.id.tutorName);
        TextView tutorSkill = (TextView) view.findViewById(R.id.tutorSkill);
        TextView tutorExperience = (TextView) view.findViewById(R.id.tutorExperience);
        TextView tutorLocation = (TextView) view.findViewById(R.id.tutorLocation);
        Button btnCall = (Button) view.findViewById(R.id.btnCall);
        Button btnDetail = (Button) view.findViewById(R.id.btndetail);

        User model = listofTutor.get(position);

            storageReference = FirebaseStorage.getInstance().getReference().child("Profile").child(model.getEmail());
            storageReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                @Override
                public void onSuccess(Uri uri) {
                    Glide.with(context).load(uri).into(imageView);
                }
            });

            tutorName.setText(model.getFullname());
            tutorSkill.setText(model.getSkill());
            tutorExperience.setText(model.getExperience());
            tutorLocation.setText(model.getAddress());


        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.dialog_layout);


                final EditText name = (EditText) dialog.findViewById(R.id.name);
                final EditText email = (EditText) dialog.findViewById(R.id.email);
                final EditText phone = (EditText) dialog.findViewById(R.id.phone);
                Button submit = (Button) dialog.findViewById(R.id.btnSubmit);
                Button dialogButton = (Button) dialog.findViewById(R.id.btnCancel);


                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference().child("Subscription");

                        boolean test = true;
                        if(name.getText().toString().equals("")){
                            name.setError("Required");
                            test = false;
                        }
                        if(email.getText().toString().equals("")){
                            email.setError("Required");
                            test = false;
                        }
                        if(phone.getText().toString().equals("")){
                            phone.setError("Required");
                            test = false;
                        }
                        if(test==true){
                            DatabaseReference databaseReference = mDatabase.child(listofTutor.get(position).getPhone()).child(phone.getText().toString());
                            databaseReference.child("email").setValue(email.getText().toString());
                            databaseReference.child("name").setValue(name.getText().toString());
                            Toast.makeText(dialog.getContext(),"Thanks, You will be contacted later!", Toast.LENGTH_LONG).show();
                            dialog.dismiss();
                        }


                    }
                });


                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });

        btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,DetatilActivity.class);
                intent.putExtra("Tutor",listofTutor.get(position));
                context.startActivity(intent);
            }
        });

        return view;
    }


}
