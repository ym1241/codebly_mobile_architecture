package com.codebly.zibro.view.home.menu.customerservice;

import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.codebly.zibro.R;
//ExpandableListView사용하는 패키지
import android.os.Bundle;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CustomerServiceActivity extends AppCompatActivity {
    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> listDataHeader;
    HashMap<String, List<String>> listHashMap;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_customerservice2);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true); //이게지금null이래
        actionBar.setHomeAsUpIndicator(R.drawable.baseline_arrow_back_24);
        //actionBar.setDisplayShowTitleEnabled(false);

        // TODO : 고객센터 기능 구현
        expandableListView = findViewById(R.id.expandableListView);
        initData();
        expandableListAdapter = new CustomExpandableListAdapter(this, listDataHeader, listHashMap);
        expandableListView.setAdapter(expandableListAdapter);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    //expandable 리스트 추가메서드
    private void initData() {
        listDataHeader = new ArrayList<>();
        listHashMap = new HashMap<>();

        listDataHeader.add("안심귀가서비스는 어떤 서비스인가요?");
        List<String> question1 = new ArrayList<>();
        question1.add("안심귀가서비스는 이용자의 안전한 귀가를 돕기 위한 서비스로, 혼자 귀가할 때 안전한 경로를 안내하거나, 실시간으로 위치를 추적하여 보호자에게 알리는 등의 기능을 제공합니다. 특정 지역에 따라 제공되는 서비스는 다를 수 있습니다.");

        listDataHeader.add("안심귀가서비스를 이용할 때 어떤 절차를 따르나요?");
        List<String> question2 = new ArrayList<>();
        question2.add("서비스를 이용하려면 먼저 등록된 정보를 기반으로 출발 및 도착지를 설정하고, 경로 안내를 받거나, 보호자에게 실시간 위치를 공유할 수 있습니다.");

        listDataHeader.add("질문3");
        List<String> question3 = new ArrayList<>();
        question3.add("Apple");

        listDataHeader.add("질문4");
        List<String> question4 = new ArrayList<>();
        question4.add("Apple");

        listHashMap.put(listDataHeader.get(0), question1);
        listHashMap.put(listDataHeader.get(1), question2);
        listHashMap.put(listDataHeader.get(2), question3);
        listHashMap.put(listDataHeader.get(3), question4);
    }
}
