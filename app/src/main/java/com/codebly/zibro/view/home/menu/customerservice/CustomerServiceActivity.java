package com.codebly.zibro.view.home.menu.customerservice;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.codebly.zibro.R;

import java.util.ArrayList;
import java.util.List;

public class CustomerServiceActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private QnAAdapter qnaAdapter;
    private List<QnAItem> qnaList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_customerservice2);

        //toolbar내용
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.baseline_arrow_back_24);
        //actionBar.setDisplayShowTitleEnabled(false);

        // TODO : 고객센터 기능 구현(현재 구현중)
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Q&A 데이터 초기화
        // TODO : 이것이 가장 근본 리스트. 구현하고나서 다음단계로 넘어갈것임
        // TODO : 이제 여기에 crud 대면 됨.졸라 간단하고 이지함.
        qnaList = new ArrayList<>();
        qnaList.add(new QnAItem("안심귀가서비스는 무엇인가요?", "안심귀가서비스는 이용자가 늦은 시간이나 위험할 수 있는 상황에서 안전하게 귀가할 수 있도록 돕는 서비스입니다. GPS를 통해 실시간 위치를 추적하거나 안전한 경로를 안내하고, 보호자에게 귀가 상황을 알리는 기능 등이 포함됩니다."));
        qnaList.add(new QnAItem("안심귀가서비스는 어떻게 이용하나요", "안심귀가서비스는 대개 모바일 앱을 통해 제공됩니다. 앱을 다운로드하고 회원가입 후, 귀가할 때 출발지와 목적지를 설정하면 GPS를 통해 안전한 경로 안내 및 실시간 위치 추적이 가능합니다. 특정 지역에서는 전화로도 신청할 수 있습니다."));
        qnaList.add(new QnAItem("서비스는 모든 지역에서 이용할 수 있나요?", "대부분의 안심귀가서비스는 특정 지역에서만 제공되며, 이용 가능 여부는 지역에 따라 다를 수 있습니다. 거주 지역의 해당 서비스 제공 여부를 확인해 주세요."));
        qnaList.add(new QnAItem("안심귀가서비스는 무료인가요?", "안심귀가서비스는 대부분 무료로 제공되지만, 일부 지역에서는 유료 서비스가 제공될 수 있습니다. 서비스 이용 전에 요금 정책을 확인하는 것이 좋습니다."));
        qnaList.add(new QnAItem("안심귀가서비스는 언제 이용할 수 있나요?", "서비스 운영 시간은 지역에 따라 다르지만, 대개 야간 시간대에 집중적으로 운영됩니다. 해당 지역의 서비스 제공 시간을 미리 확인해 주세요."));
        qnaList.add(new QnAItem("서비스를 이용하려면 미리 예약해야 하나요?", "서비스에 따라 예약이 필요한 경우도 있고, 실시간으로 이용할 수 있는 경우도 있습니다. 앱을 통해 자세한 절차를 확인할 수 있습니다."));
        qnaList.add(new QnAItem("안심귀가서비스는 안전한가요?", "안심귀가서비스는 GPS 추적과 보호자 알림 기능을 통해 안전한 귀가를 돕습니다. 그러나 이용자의 안전을 100% 보장하는 것은 아니므로, 추가적인 안전 수칙도 지키는 것이 중요합니다."));
        qnaAdapter = new QnAAdapter(qnaList);
        recyclerView.setAdapter(qnaAdapter);
    }
    //툴바 뒤로가기구현
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
}
