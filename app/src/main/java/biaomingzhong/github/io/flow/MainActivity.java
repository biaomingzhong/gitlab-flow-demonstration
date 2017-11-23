package biaomingzhong.github.io.flow;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import biaomingzhong.github.io.support.XTextUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        // TODO: 2017/11/24 UI 单元测试

        // TODO: 2017/11/23 将要在这里开发下一个版本的功能
    }

    private void initView() {
        TextView tvContent = findViewById(R.id.content);

        tvContent.setText(XTextUtil.format("Message from developer: %s", "Hello world!"));
    }
}
