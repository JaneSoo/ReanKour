package com.example.janesoo.reankour.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.example.janesoo.reankour.DocumentActivity;
import com.example.janesoo.reankour.R;
import com.example.janesoo.reankour.adapter.DocumentAdapter;
import com.example.janesoo.reankour.model.Document;

import java.util.ArrayList;

/**
 * Created by JaneSoo on 17-Jun-17.
 */

public class FragmentVideo extends Fragment {
    ListView listView;
    DocumentAdapter documentAdapter;
    DocumentActivity documentActivity;

    public void setDocumentActivity(DocumentActivity documentActivity){
        this.documentActivity= documentActivity;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View myView = inflater.inflate(R.layout.content_document,container,false);
        listView= (ListView)myView.findViewById(R.id.list_document);
        Button buttonReadMore=(Button)myView.findViewById(R.id.btn_readMore);
        ArrayList<Document> newDocument =new ArrayList<>();


        newDocument.add(new Document(R.drawable.pic,"The way to find university","There are so many to choose the university in cambodia","12 June 17"));
        newDocument.add(new Document(R.drawable.pic,"How to speak English","There are so many way that can help you to speak English very well","19 June 17"));
        newDocument.add(new Document(R.drawable.pic,"Scholarship","Scholarship to openning now such as Singapore, Korea, Indonesi","10 June 17"));
        newDocument.add(new Document(R.drawable.pic,"How to develop yourself","There are so many that can develop yourself to be stronger ","12 June 17"));
        newDocument.add(new Document(R.drawable.pic,"The way to find university","There are so many to choose the university in cambodia","12 June 17"));
        newDocument.add(new Document(R.drawable.pic,"How to speak English","There are so many way that can help you to speak English very well","19 June 17"));
        newDocument.add(new Document(R.drawable.pic,"Scholarship","Scholarship to openning now such as Singapore, Korea, Indonesi","10 June 17"));
        newDocument.add(new Document(R.drawable.pic,"How to develop yourself","There are so many that can develop yourself to be stronger ","12 June 17"));

        documentAdapter=new DocumentAdapter(newDocument,getContext());
        listView.setAdapter(documentAdapter);
        documentAdapter.notifyDataSetChanged();
        return myView;

    }
}
