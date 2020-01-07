package s.www.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Displays activity_main.xml when the activity is started

        Button myButton = findViewById(R.id.button2);   // Sets myButton as a reference to button2 in the xml layout file

        myButton.setOnClickListener(new View.OnClickListener() {    // Set an event to happen when button is clicked
            @Override
            public void onClick(View v) {   // The event to be executed
                Toast.makeText(getApplicationContext(), "Button Clicked", Toast.LENGTH_LONG).show(); // Displays text
            }
        });
    }
}
