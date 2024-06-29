package sg.edu.np.mad.madpractical4;


import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {


    private User currentUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView titleTextView = findViewById(R.id.titleTextView);
        TextView descriptionTextView = findViewById(R.id.descriptionTextView);
        Button followButton = findViewById(R.id.followButton);


        String name = getIntent().getStringExtra("name");
        String description = getIntent().getStringExtra("description");
        boolean followed = getIntent().getBooleanExtra("followed", false);


        currentUser = new User(name, description, 0, followed);


        titleTextView.setText(currentUser.getName());
        descriptionTextView.setText(currentUser.getDescription());
        followButton.setText(currentUser.getFollowed() ? "UNFOLLOW" : "FOLLOW");


        followButton.setOnClickListener(v -> {
            currentUser.setFollowed(!currentUser.getFollowed());
            followButton.setText(currentUser.getFollowed() ? "UNFOLLOW" : "FOLLOW");
            Toast.makeText(this, currentUser.getFollowed() ? "Followed" : "Unfollowed", Toast.LENGTH_SHORT).show();
        });
    }
}