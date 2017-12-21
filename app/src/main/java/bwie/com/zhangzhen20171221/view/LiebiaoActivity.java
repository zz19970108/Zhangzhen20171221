package bwie.com.zhangzhen20171221.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import bwie.com.zhangzhen20171221.MainActivity;
import bwie.com.zhangzhen20171221.R;
import bwie.com.zhangzhen20171221.adapter.LvAdapter;
import bwie.com.zhangzhen20171221.bean.BaseBean;
import bwie.com.zhangzhen20171221.presenter.BasePresenter;

public class LiebiaoActivity extends AppCompatActivity implements ILieBiaoActivity{

    private BasePresenter basePresenter;
    private XRecyclerView mXrecycleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liebiao);

        initView();
        basePresenter = new BasePresenter(this);
        basePresenter.dopost();
    }

    private void initView() {
        mXrecycleView = (XRecyclerView) findViewById(R.id.xrecycleView);
        mXrecycleView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void show(String str) {

    }

    @Override
    public void showNews(BaseBean baseBean) {
        List<BaseBean.MiaoshaBean.ListBeanX> list = baseBean.getMiaosha().getList();
        LvAdapter lvAdapter = new LvAdapter(this, list);
        mXrecycleView.setAdapter(lvAdapter);
        lvAdapter.setOnclick(new LvAdapter.Onclick() {
            @Override
            public void Onclik(String pid) {
                Intent intent = new Intent(LiebiaoActivity.this, MainActivity.class);
                intent.putExtra("pid",pid);
                startActivity(intent);
                Toast.makeText(LiebiaoActivity.this,pid,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
