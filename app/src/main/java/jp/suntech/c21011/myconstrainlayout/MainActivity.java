package jp.suntech.c21011.myconstrainlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        ListView lvMenu = findViewById(R.id.nation_list);
//        lvMenu.setOnItemClickListener(new ListItemClickListener());


//        Button btClick = findViewById(R.id.btClick);
        HelloListener Listener = new HelloListener();  //リスナのインスタンスを生成
        //btClick.setOnClickListener(Listener);         //ボタンにリスナを組み込む

        Button btClear = findViewById(R.id.btClear);
        btClear.setOnClickListener(Listener);
        Button btConfirm = findViewById(R.id.btConfirm);
        btConfirm.setOnClickListener(Listener);
        Button btSend = findViewById(R.id.btSend);
        btSend.setOnClickListener(Listener);

    }

//    private class ListItemClickListener implements AdapterView.OnItemClickListener{
//
//        @Override
//        public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
//
//
//            Button btConfirm = findViewById(R.id.btConfirm);
//            btConfirm.setOnClickListener((View.OnClickListener) new ListItemClickListener());
//        }
//    }

    private  class HelloListener implements View.OnClickListener{
        //イベントハンドラ <= イベント発生時の処理
        @Override
        public void onClick(View view){
            EditText input = findViewById(R.id.etName);
            EditText inputs = findViewById(R.id.etMtitle);
            EditText inputx = findViewById(R.id.etMail);
            EditText inputy = findViewById(R.id.etComment);

            String comment = inputy.getText().toString();

            String mail = inputx.getText().toString();

            String mtitle = inputs.getText().toString();

            String name = input.getText().toString();
            //TextView output = findViewById(R.id.tvOutput);



            int id = view.getId();
            switch(id) {
                case R.id.btConfirm:
                    OrderConfirmDialogFragment dialogFragment = new OrderConfirmDialogFragment();
                    dialogFragment.show(getSupportFragmentManager(),"Oooooooooooo");
                    String show = name+"\n"+mtitle+"\n"+mail+"\n"+comment;
                    Toast.makeText(MainActivity.this,show,Toast.LENGTH_LONG).show();
                    break;
                case R.id.btSend:

                    String showx = name+"\n"+mtitle+"\n"+mail+"\n"+comment;
                    Toast.makeText(MainActivity.this,showx,Toast.LENGTH_LONG).show();
                    break;
                case R.id.btClear:

                    input.setText("");
                    inputs.setText("");
                    inputx.setText("");
                    inputy.setText("");
                    break;
            }
        }
    }
}