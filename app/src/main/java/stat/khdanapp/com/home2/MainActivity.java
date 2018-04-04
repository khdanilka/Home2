package stat.khdanapp.com.home2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.jakewharton.rxbinding2.widget.RxTextView;

import org.reactivestreams.Subscription;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.preview_text) TextView textView;
    @BindView(R.id.edit_text)    EditText editText;

    private Observer<TextView> observer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        Disposable editT = RxTextView.textChanges(editText).subscribe(new Consumer<CharSequence>(){
            @Override
            public void accept(CharSequence charSequence) throws Exception {
                textView.setText(charSequence);
            }
        });

    }
}
