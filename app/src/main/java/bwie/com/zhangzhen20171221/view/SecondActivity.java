package bwie.com.zhangzhen20171221.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import bwie.com.zhangzhen20171221.R;
import bwie.com.zhangzhen20171221.adapter.ElvAdapter;
import bwie.com.zhangzhen20171221.bean.PriceAndCount;
import bwie.com.zhangzhen20171221.bean.ShowCarBean;
import bwie.com.zhangzhen20171221.presenter.ShowCarPresenter;

public class SecondActivity extends AppCompatActivity implements ISecondActivity{

    private ShowCarPresenter showCarPresenter;
    private ImageView mBackIv;
    private ExpandableListView mElv;
    private CheckBox mCheckAll;
    private TextView mSum;
    private TextView mTvCount;
    private ElvAdapter elvAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        initView();
        showCarPresenter = new ShowCarPresenter(this);
        showCarPresenter.show();
        mCheckAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                elvAdapter.AllOrNone(mCheckAll.isChecked());
            }
        });
    }

    private void initView() {
        mBackIv = (ImageView) findViewById(R.id.back_iv);
        mElv = (ExpandableListView) findViewById(R.id.elv);
        mCheckAll = (CheckBox) findViewById(R.id.checkAll);
        mSum = (TextView) findViewById(R.id.sum);
        mTvCount = (TextView) findViewById(R.id.tvCount);
    }

    @Override
    public void show(String str) {

    }

    @Override
    public void showCar(List<ShowCarBean.DataBean> group, List<List<ShowCarBean.DataBean.ListBean>> child) {
        elvAdapter = new ElvAdapter(group, child, SecondActivity.this);
        mElv.setAdapter(elvAdapter);
        for (int i = 0; i < group.size(); i++) {
            mElv.expandGroup(i);
        }
    }
    public void setPriceAndCount(PriceAndCount priceAndCount) {
        mSum.setText("合计：" + priceAndCount.getPrice());
        mTvCount.setText("去结算(" + priceAndCount.getCount() + ")");
    }

    public void setAllChecked(boolean bool) {
        mCheckAll.setChecked(bool);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        //防止内存泄露
        showCarPresenter.Dettouch();
        //注销EventBus
    }
}
