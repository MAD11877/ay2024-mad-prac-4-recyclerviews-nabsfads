package sg.edu.np.mad.madpractical4;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;


public class UserViewHolder extends RecyclerView.ViewHolder {
    ImageView smallImageView;
    ImageView largeImageView;
    TextView nameTextView;
    TextView descriptionTextView;


    public UserViewHolder(View itemView) {
        super(itemView);
        smallImageView = itemView.findViewById(R.id.smallImageView);
        largeImageView = itemView.findViewById(R.id.largeImageView);
        nameTextView = itemView.findViewById(R.id.nameTextView);
        descriptionTextView = itemView.findViewById(R.id.descriptionTextView);
    }
}