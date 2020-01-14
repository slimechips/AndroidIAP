package s.www.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ChickenRiceStallActivity extends AppCompatActivity {

    TextView chickenRiceText;
    TextView duckRiceText;
    Button chickenRiceGoodBtn;
    Button duckRiceGoodBtn;
    int chickenRiceVoteGood = 0;
    int duckRiceVoteGood = 0;
    DatabaseReference mDatabase;
    DatabaseReference chickenRiceRef;
    DatabaseReference duckRiceRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chicken_rice_stall);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        chickenRiceRef = mDatabase.child("chicken_rice_stall").child("chicken_rice");
        duckRiceRef = mDatabase.child("chicken_rice_stall").child("duck_rice");

        chickenRiceText = findViewById(R.id.chicken_rice_text);
        chickenRiceGoodBtn = findViewById(R.id.chicken_rice_good);

        duckRiceText = findViewById(R.id.duck_rice_text);
        duckRiceGoodBtn = findViewById(R.id.duck_rice_good);

        chickenRiceRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // This code in this function is executed when the db value is updated
                // The following line of code retrieves the updated db value
                // And it also sets the chickenRiceVoteGood variable to the updated value
                // TODO: Update the text on the page with this updated value
                chickenRiceVoteGood = dataSnapshot.getValue(int.class);
                chickenRiceText.setText(Integer.toString(chickenRiceVoteGood));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        duckRiceRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                duckRiceVoteGood = dataSnapshot.getValue(int.class);
                duckRiceText.setText(Integer.toString(duckRiceVoteGood));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        duckRiceText.setText(Integer.toString(duckRiceVoteGood));

        chickenRiceGoodBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chickenRiceVoteGood = chickenRiceVoteGood + 1;
                chickenRiceRef.setValue(chickenRiceVoteGood);
            }
        });

        duckRiceGoodBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                duckRiceVoteGood = duckRiceVoteGood + 1;
                duckRiceRef.setValue(duckRiceVoteGood);
            }
        });

    }
}
