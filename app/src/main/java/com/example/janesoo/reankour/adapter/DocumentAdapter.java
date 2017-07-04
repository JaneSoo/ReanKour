package com.example.janesoo.reankour.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.janesoo.reankour.DetailDocumentActivity;
import com.example.janesoo.reankour.R;
import com.example.janesoo.reankour.model.Document;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Sor Phorn on 6/19/2017.
 */

public class DocumentAdapter extends BaseAdapter {
    private ArrayList<Document> arrayList;
    private int layout;
    private Context context;

    public DocumentAdapter(ArrayList<Document> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public String toString() {
        return "DocumentAdapter{" +
                "arrayList=" + arrayList +
                ", layout=" + layout +
                ", context=" + context +
                '}';
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View myView =inflater.inflate(R.layout.content_list_document,null);

        ImageView imageViewDocument=(ImageView)myView.findViewById(R.id.news_img);
        imageViewDocument.setImageResource(arrayList.get(position).getDoc_img());

        TextView textViewTitle=(TextView)myView.findViewById(R.id.news_title);
        textViewTitle.setText(arrayList.get(position).getDoc_title());

        TextView textViewContent=(TextView)myView.findViewById(R.id.document);
        textViewContent.setText(arrayList.get(position).getDoc_content());

        TextView textViewDate= (TextView) myView.findViewById(R.id.news_date);
        textViewDate.setText(arrayList.get(position).getDate());

       /* Button buttonReadMore=(Button)myView.findViewById(R.id.btn_readMore);
*/
       /* buttonReadMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,DetailDocumentActivity.class);
                intent.putExtra("Content",arrayList.get(position));
                context.startActivity(intent);
            }
        });*/



        return myView;
    }
}
