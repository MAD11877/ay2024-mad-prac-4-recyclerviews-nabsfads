package sg.edu.np.mad.madpractical4;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private boolean isFollowed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        String name = getIntent().getStringExtra("name");
        String description = getIntent().getStringExtra("description");
        isFollowed = getIntent().getBooleanExtra("followed", false);

        TextView tvName = findViewById(R.id.tvName);
        TextView tvDescription = findViewById(R.id.tvDescription);
        Button btnFollow = findViewById(R.id.btnFollow);

        tvName.setText(name);
        tvDescription.setText(description);

        btnFollow.setText(isFollowed ? "Unfollow" : "Follow");

        btnFollow.setOnClickListener(v -> {
            isFollowed = !isFollowed;
            btnFollow.setText(isFollowed ? "Unfollow" : "Follow");
            Toast.makeText(MainActivity.this, isFollowed ? "Followed" : "Unfollowed", Toast.LENGTH_SHORT).show(); // Show toast message
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
