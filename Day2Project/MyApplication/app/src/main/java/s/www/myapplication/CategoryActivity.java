package s.www.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        CardView chickenRiceStallCard = findViewById(R.id.chicken_rice_stall_card); // Reference to Chicken Rice Stall CardView
        CardView westernStallCard = findViewById(R.id.western_stall_card); // Reference to Western Stall CardView
        CardView japaneseStallCard = findViewById(R.id.japanese_stall_card); // Reference to Japanese Stall CardView

        chickenRiceStallCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoryActivity.this, ChickenRiceStallActivity.class);
                startActivity(intent);  // Go to ChickenRiceStallActivity when button clicked
            }
        });

        westernStallCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoryActivity.this, WesternStallActivity.class);
                startActivity(intent);  // Go to WesternStallActivity when button clicked
            }
        });

        japaneseStallCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoryActivity.this, JapaneseStallActivity.class);
                startActivity(intent);  // Go to JapaneseStallActivity when button clicked
            }
        });
    }
}
