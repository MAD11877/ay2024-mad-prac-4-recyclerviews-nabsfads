package sg.edu.np.mad.madpractical4;


import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class ListActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);


        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        List<User> userList = new ArrayList<>();
        Random random = new Random();


        for (int i = 0; i < 20; i++) {
            String name = "User " + random.nextInt(10000);
            String description = "Description " + random.nextInt(10000);
            boolean followed = random.nextBoolean();
            userList.add(new User(name, description, i, followed));
        }


        UserAdapter userAdapter = new UserAdapter(userList, this);
        recyclerView.setAdapter(userAdapter);
    }
}