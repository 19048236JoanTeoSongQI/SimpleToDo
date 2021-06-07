package sg.edu.rp.c346.id19048236.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText etNewTodo;
    Button btnAdd,btnClearAll;
    ListView lvToDo;

    ArrayList<String> alTodo;
    ArrayAdapter<String> aaTodo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNewTodo=findViewById(R.id.editTextTodo);
        btnAdd=findViewById(R.id.buttonAdd);
        btnClearAll=findViewById(R.id.buttonClear);
        lvToDo=findViewById(R.id.listViewToDo);

        alTodo=new ArrayList<>();
      //Test
        //  alTodo.add("Watch movie");

        aaTodo=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,alTodo);
        lvToDo.setAdapter(aaTodo);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newTodo=etNewTodo.getText().toString();
                alTodo.add(newTodo);
                aaTodo.notifyDataSetChanged();
                etNewTodo.setText(null);
            }
        });

        btnClearAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alTodo.clear();
                aaTodo.notifyDataSetChanged();
            }
        });
    }
}