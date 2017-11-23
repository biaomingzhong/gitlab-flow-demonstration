package biaomingzhong.github.io.flow;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import biaomingzhong.github.io.support.XTextUtil;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = "flow.MainActivity.java";

    private final static String MESSAGE_TEMPLATE = "Message from developer: %s";

    private TextView tvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        // TODO: 2017/11/24 UI 单元测试

        // TODO: 2017/11/23 将要在这里开发下一个版本的功能
    }

    private void initView() {
        tvContent = findViewById(R.id.content);

        tvContent.setText(XTextUtil.format(MESSAGE_TEMPLATE, "Hello world!"));
    }

    /**
     * resume 的时候打一个日志，并修改 Hello
     */
    @Override protected void onResume() {
        super.onResume();
        Log.e(TAG, XTextUtil.format(MESSAGE_TEMPLATE, "this log changed."));
        tvContent.setText(XTextUtil.format(MESSAGE_TEMPLATE, "Activity resumed."));
    }
}
