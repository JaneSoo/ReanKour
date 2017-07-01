package com.example.janesoo.reankour;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;

import com.example.janesoo.reankour.adapter.DocumentAdapter;
import com.example.janesoo.reankour.model.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sor Phorn on 6/20/2017.
 */

public class DocumentActivity extends AppCompatActivity {
    ListView listView;
    private ArrayList<Document>arrayList = new ArrayList<>();
    Button buttonReadMore;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_document);

        arrayList.add(new Document(R.drawable.content1,"The way to find university","There are so many to choose the university in cambodia","12 June 17"));
        arrayList.add(new Document(R.drawable.content2,"How to speak English","There are so many way that can help you to speak English very well","19 June 17"));
        arrayList.add(new Document(R.drawable.content3,"Scholarship","Scholarship to openning now such as Singapore, Korea, Indonesi","10 June 17"));
        arrayList.add(new Document(R.drawable.content4,"How to develop yourself","There are so many that can develop yourself to be stronger ","12 June 17"));
        arrayList.add(new Document(R.drawable.content1,"The way to find university","There are so many to choose the university in cambodia","12 June 17"));
        arrayList.add(new Document(R.drawable.content2,"How to speak English","There are so many way that can help you to speak English very well","19 June 17"));
        arrayList.add(new Document(R.drawable.content3,"Scholarship","Scholarship to openning now such as Singapore, Korea, Indonesi","10 June 17"));
        arrayList.add(new Document(R.drawable.content4,"How to develop yourself","There are so many that can develop yourself to be stronger ","12 June 17"));


        listView= (ListView) findViewById(R.id.list_document);
        DocumentAdapter adapter=new DocumentAdapter(arrayList,R.layout.content_list_document,DocumentActivity.this);
        listView.setAdapter(adapter);

        buttonReadMore=(Button)findViewById(R.id.btn_readMore);

        /*buttonReadMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DocumentActivity.this,DetailDocumentActivity.class);
                startActivity(intent);

            }
        });
*/


    }
}
