package s.www.myapplication;

import com.microsoft.appcenter.AppCenter;
import com.microsoft.appcenter.analytics.Analytics;
import com.microsoft.appcenter.crashes.Crashes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    int clickCount = 0;

    // Choose authentication providers
    List<AuthUI.IdpConfig> providers = Arrays.asList(
            new AuthUI.IdpConfig.GoogleBuilder().build());
    private static final int RC_SIGN_IN = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCenter.start(getApplication(), "5e93b328-32bc-45b8-aee9-4ae0093efbe3",
                Analytics.class, Crashes.class);
        setContentView(R.layout.activity_main); // Displays activity_main.xml when the activity is started

        Button myButton = findViewById(R.id.button2);   // Sets myButton as a reference to button2 in the xml layout file


        myButton.setOnClickListener(new View.OnClickListener() {    // Set an event to happen when button is clicked
            @Override
            public void onClick(View v) {   // The event to be executed
                clickCount = clickCount + 1;
                Toast.makeText(getApplicationContext(), "Button Clicked", Toast.LENGTH_LONG).show(); // Displays text

                // Create and launch sign-in intent
                startActivityForResult(
                        AuthUI.getInstance()
                                .createSignInIntentBuilder()
                                .setAvailableProviders(providers)
                                .build(),
                        RC_SIGN_IN);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {
            IdpResponse response = IdpResponse.fromResultIntent(data);

            if (resultCode == RESULT_OK) {
                // Successfully signed in
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                // TODO: Add code here to Welcome the user with a Toast and go to CategoryActivity
                // Remember Toast.makeText and remember to show()!
                // You can get the user's name with user.getDisplayName()
                // You can get the text "Welcome <user>" with the following code:
                // "Welcome " + user.getDisplayName()

                Toast.makeText(getApplicationContext(), "Welcome " + user.getDisplayName(),
                        Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, CategoryActivity.class);
                startActivity(intent);

            } else {
                // Sign in failed
                // TODO: Add code here to Toast to the user that sign-in failed!
                Toast.makeText(getApplicationContext(), "Sign-in  failed!",
                        Toast.LENGTH_LONG).show();
            }
        }
    }
}
