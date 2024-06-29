
package sg.edu.np.mad.madpractical4;


import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;


public class UserAdapter extends RecyclerView.Adapter<UserViewHolder> {
    private List<User> userList;
    private Context context;


    public UserAdapter(List<User> userList, Context context) {
        this.userList = userList;
        this.context = context;
    }


    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_activity_list, parent, false);
        return new UserViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = userList.get(position);
        holder.nameTextView.setText(user.getName());
        holder.descriptionTextView.setText(user.getDescription());
        holder.smallImageView.setImageResource(R.mipmap.ic_launcher);
        holder.largeImageView.setImageResource(R.mipmap.ic_launcher);


        if (user.getName().endsWith("7")) {
            holder.largeImageView.setVisibility(View.VISIBLE);


            ViewGroup.LayoutParams layoutParams = holder.largeImageView.getLayoutParams();
            layoutParams.height = layoutParams.width;
            holder.largeImageView.setLayoutParams(layoutParams);
        } else {
            holder.largeImageView.setVisibility(View.GONE);
        }


        holder.itemView.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle("Profile");
            builder.setMessage(user.getName());
            builder.setPositiveButton("Close", null);
            builder.setNegativeButton("View", (dialog, which) -> {
                Intent intent = new Intent(context, MainActivity.class);
                intent.putExtra("name", user.getName());
                intent.putExtra("description", user.getDescription());
                intent.putExtra("followed", user.getFollowed());
                context.startActivity(intent);
            });
            builder.create().show();
        });
    }


    @Override
    public int getItemCount() {
        return userList.size();
    }
}
