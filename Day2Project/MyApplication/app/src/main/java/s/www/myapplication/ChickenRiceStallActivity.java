package s.www.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ChickenRiceStallActivity extends AppCompatActivity {

    TextView chickenRiceText;
    TextView duckRiceText;
    Button chickenRiceGoodBtn;
    Button duckRiceGoodBtn;
    int chickenRiceVoteGood = 5;
    int duckRiceVoteGood = 9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chicken_rice_stall);

        chickenRiceText = findViewById(R.id.chicken_rice_text);
        chickenRiceGoodBtn = findViewById(R.id.chicken_rice_good);

        duckRiceText = findViewById(R.id.duck_rice_text);
        duckRiceGoodBtn = findViewById(R.id.duck_rice_good);

        chickenRiceText.setText(Integer.toString(chickenRiceVoteGood));
        duckRiceText.setText(Integer.toString(duckRiceVoteGood));

        chickenRiceGoodBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chickenRiceVoteGood = chickenRiceVoteGood + 1;
                chickenRiceText.setText(Integer.toString(chickenRiceVoteGood));
            }
        });

        duckRiceGoodBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                duckRiceVoteGood = duckRiceVoteGood + 1;
                duckRiceText.setText(Integer.toString(duckRiceVoteGood));
            }
        });

    }
}
