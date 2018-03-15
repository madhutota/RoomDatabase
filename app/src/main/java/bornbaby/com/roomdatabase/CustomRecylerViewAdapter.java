package bornbaby.com.roomdatabase;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by madhu on 15-Mar-18.
 */

public class CustomRecylerViewAdapter  extends RecyclerView.Adapter<CustomRecylerViewAdapter.ViewHolder>{
    private List<User> dataModels = new ArrayList<>();
    private MainActivity mainActivity;

    public CustomRecylerViewAdapter(List<User> dataModels, MainActivity mainActivity) {
        this.dataModels = dataModels;
        this.mainActivity = mainActivity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recylerview,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        User user = dataModels.get(position);
        holder.user.setText(user.getUserName());
        holder.email.setText(user.getEmail());
        holder.phone.setText(user.getPhoneNumber());


    }

    @Override
    public int getItemCount() {
        return dataModels.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private TextView  user;
        private TextView  email;
        private TextView  phone;

        public ViewHolder(View itemView) {
            super(itemView);
            user = itemView.findViewById(R.id.user);
            email = itemView.findViewById(R.id.email);
            phone = itemView.findViewById(R.id.phone);
        }

    }
}
