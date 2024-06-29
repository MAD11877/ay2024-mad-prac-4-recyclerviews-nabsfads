package sg.edu.np.mad.madpractical4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list);

        Toast.makeText(this, "ListActivity Loaded", Toast.LENGTH_SHORT).show(); // Debugging line

        List<User> userList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            String randomNameNumber = String.format(Locale.getDefault(), "%09d", new Random().nextInt(1000000000));
            String randomDescriptionNumber = String.format(Locale.getDefault(), "%09d", new Random().nextInt(1000000000));
            userList.add(new User("Name " + randomNameNumber, "Description " + randomDescriptionNumber, i, new Random().nextBoolean()));
        }

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        UserAdapter adapter = new UserAdapter(userList, this);
        recyclerView.setAdapter(adapter);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void onUserClicked(User user) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Profile");
        alert.setMessage("Name: " + user.getName());

        alert.setPositiveButton("View", (dialog, which) -> {
            Intent intent = new Intent(ListActivity.this, MainActivity.class);
            intent.putExtra("name", user.getName());
            intent.putExtra("description", user.getDescription());
            intent.putExtra("followed", user.isFollowed());
            startActivity(intent);
        });

        alert.setNegativeButton("Cancel", (dialog, which) -> {
            // Do nothing on cancel
        });

        alert.show();
    }
}
