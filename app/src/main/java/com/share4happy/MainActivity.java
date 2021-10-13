package com.share4happy;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TabHost tabHost;
    ListView listV_history;
    EditText inputA,inputB;
    TextView output_KetQua;
    Button btn_cong,btn_tru,btn_nhan,btn_chia;

    int cong,tru,nhan;
    float chia;

    ArrayList<String> dsPheptoan = new ArrayList<>();
    ArrayAdapter<String> adapterHistory;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addEvents() {
        //Tạo sự kiện khi nhấn nút thực hiện phép cộng
        btn_cong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cong = Integer.parseInt(inputA.getText().toString())+Integer.parseInt(inputB.getText().toString());
                output_KetQua.setText(inputA.getText().toString()+" + "+inputB.getText().toString()+" = "+cong);
                dsPheptoan.add(output_KetQua.getText().toString());
                adapterHistory.notifyDataSetChanged();
                listV_history.setAdapter(adapterHistory);
                inputA.setText("");
                inputB.setText("");
                inputA.requestFocus(); // đưa con trỏ về vị trí inputA

            }
        });
        //Tạo sự kiện khi nhấn nút thực hiện phép trừ
        btn_tru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tru = Integer.parseInt(inputA.getText().toString())-Integer.parseInt(inputB.getText().toString());
                output_KetQua.setText(inputA.getText().toString()+" - "+inputB.getText().toString()+" = "+tru);
                dsPheptoan.add(output_KetQua.getText().toString());
                adapterHistory.notifyDataSetChanged();
                listV_history.setAdapter(adapterHistory);
                inputA.setText("");
                inputB.setText("");
                inputA.requestFocus(); // đưa con trỏ về vị trí inputA

            }
        });
        //Tạo sự kiện khi nhấn nút thực hiện phép nhân
        btn_nhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nhan = Integer.parseInt(inputA.getText().toString())*Integer.parseInt(inputB.getText().toString());
                output_KetQua.setText(inputA.getText().toString()+" x "+inputB.getText().toString()+" = "+nhan);
                dsPheptoan.add(output_KetQua.getText().toString());
                adapterHistory.notifyDataSetChanged();
                listV_history.setAdapter(adapterHistory);
                inputA.setText("");
                inputB.setText("");
                inputA.requestFocus(); // đưa con trỏ về vị trí inputA

            }
        });
        //Tạo sự kiện khi nhấn nút thực hiện phép chia
        btn_chia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chia = Integer.parseInt(inputA.getText().toString())/Integer.parseInt(inputB.getText().toString());
                output_KetQua.setText(inputA.getText().toString()+" % "+inputB.getText().toString()+" = "+chia);
                dsPheptoan.add(output_KetQua.getText().toString());
                adapterHistory.notifyDataSetChanged();
                listV_history.setAdapter(adapterHistory);
                inputA.setText("");
                inputB.setText("");
                inputA.requestFocus(); // đưa con trỏ về vị trí inputA

            }
        });
    }

    private void addControls() {

        listV_history = findViewById(R.id.list_History);
        inputA = findViewById(R.id.input_A);
        inputB = findViewById(R.id.input_B);
        btn_cong = findViewById(R.id.btn_Cong);
        btn_tru = findViewById(R.id.btn_Tru);
        btn_nhan = findViewById(R.id.btn_Nhan);
        btn_chia = findViewById(R.id.btn_Chia);
        output_KetQua = findViewById(R.id.output_KetQua);

        adapterHistory = new ArrayAdapter<>(MainActivity.this,
                android.R.layout.simple_list_item_1,
                dsPheptoan);

        tabHost = findViewById(R.id.tabhost);
        // gọi hàm setup
        tabHost.setup();
        createTab();

    }

    private void createTab() {
        // tạo tab thứ 1
        TabHost.TabSpec tabSpec1;
        tabSpec1 = tabHost.newTabSpec("tab1");
        tabSpec1.setContent(R.id.tab1);
        tabSpec1.setIndicator("Thực hiện phép toán");
        tabHost.addTab(tabSpec1);
        // Tạo tab thứ 2
        TabHost.TabSpec tabSpec2;
        tabSpec2 = tabHost.newTabSpec("tab2");
        tabSpec2.setContent(R.id.tab2);
        tabSpec2.setIndicator("Lịch sử phép toán");
        tabHost.addTab(tabSpec2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("For example TabSelector");
        return super.onCreateOptionsMenu(menu);
    }
}