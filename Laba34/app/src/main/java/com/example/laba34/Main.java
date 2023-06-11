package com.example.laba34;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class Main extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ArrayAdapter<String> arad;
    ListView lw;
    EditText editText;
    Button edit, del;
    public int pos;
    private View curView=null;
    MenuItem menuItem, menuItem2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        arad = new ArrayAdapter<String>(this,R.layout.tv);

        editText = (EditText)findViewById(R.id.et1);
        lw = (ListView)findViewById(R.id.lw);
        edit = (Button)findViewById(R.id.Btn2);
        del = (Button)findViewById(R.id.Btn3);
        lw.setAdapter(arad);
        arad.add("first");
        arad.add("second");
        lw.setOnItemClickListener(this);
        edit.setEnabled(false);
        del.setEnabled(false);
    }

    public void Add(View view) {
        add();
    }

    public void add(){
        String n = editText.getText().toString();
        arad.add(n);
        editText.setText(null);
    }

    public void Clear(View view) {
        clear();
    }

    public void clear(){
        arad.clear();
    }

    public void Edit(View view){
        edit();
    }

    public void edit(){
        String s = arad.getItem(pos);
        arad.remove(s);
        arad.insert(editText.getText().toString(),pos);
        editText.setText(null);
        edit.setEnabled(false);
        del.setEnabled(false);
        menuItem.setEnabled(false);
        menuItem2.setEnabled(false);
    }

    public void Del(View view){
        del();
    }

    public void del(){
        String s = arad.getItem(pos);
        arad.remove(s);
        editText.setText(null);
        edit.setEnabled(false);
        del.setEnabled(false);
        menuItem.setEnabled(false);
        menuItem2.setEnabled(false);
    }


    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (curView != null) {
            curView.setBackgroundColor(ContextCompat.getColor(this,R.color.lvBack));
        }

        edit.setEnabled(true);
        del.setEnabled(true);
        menuItem.setEnabled(true);
        menuItem2.setEnabled(true);

        pos = position;
        String s = arad.getItem(position);
        view.setBackgroundColor(ContextCompat.getColor(this,R.color.white));
        editText.setText(s);
        curView=view;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        menuItem = menu.getItem(1);
        menuItem2 = menu.getItem(2);
        menuItem.setEnabled(false);
        menuItem2.setEnabled(false);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getTitle().toString()){
            case "Add": {
                add();
                break;
            }
            case "Edit": {
                edit();
                break;
            }
            case "Del": {
                del();
                break;
            }
            case "Clear": {
                clear();
                break;
            }

        }

        return super.onOptionsItemSelected(item);
    }
}
