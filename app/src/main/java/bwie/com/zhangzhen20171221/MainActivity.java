package bwie.com.zhangzhen20171221;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.nostra13.universalimageloader.core.ImageLoader;

import bwie.com.zhangzhen20171221.bean.GoodXiangBean;
import bwie.com.zhangzhen20171221.presenter.AddPresenter;
import bwie.com.zhangzhen20171221.presenter.XiangPresenter;
import bwie.com.zhangzhen20171221.view.IMainActivity;
import bwie.com.zhangzhen20171221.view.SecondActivity;

public class MainActivity extends AppCompatActivity implements IMainActivity, View.OnClickListener{

    private XiangPresenter xiangPresenter;
    private AddPresenter addPresenter;
    private ImageView mImageView;
    private TextView mTvTitle;
    private TextView mTvOldprice;
    private TextView mTvNewprice;
    private ImageView mBackIv;
    private Button mShowCart;
    private Button mAddCart;
    private GoodXiangBean.DataBean data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        Intent intent = getIntent();
        String pid = intent.getStringExtra("pid");
        xiangPresenter = new XiangPresenter(this);
        addPresenter = new AddPresenter(this);
        xiangPresenter.getGood(pid);
    }

    private void initView() {
        mImageView = (ImageView) findViewById(R.id.imageView);
        mTvTitle = (TextView) findViewById(R.id.tv_title);
        mTvOldprice = (TextView) findViewById(R.id.tv_oldprice);
        mTvNewprice = (TextView) findViewById(R.id.tv_newprice);
        mBackIv = (ImageView) findViewById(R.id.back_iv);
        mShowCart = (Button) findViewById(R.id.show_cart);
        mShowCart.setOnClickListener(this);
        mAddCart = (Button) findViewById(R.id.add_cart);
        mAddCart.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.show_cart:
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
                break;
            case R.id.add_cart:
                addPresenter.addShop(data.getPid());
                break;
        }
    }

    @Override
    public void show(String str) {
        Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showNews(GoodXiangBean goodXiangBean) {
        data = goodXiangBean.getData();
        String images = data.getImages();
        String[] split = images.split("\\|");
        ImageLoader.getInstance().displayImage(split[0], mImageView);
        mTvTitle.setText(data.getTitle());
        mTvOldprice.setText(data.getPrice() + "");
        mTvNewprice.setText(data.getBargainPrice() + "");
    }
}
