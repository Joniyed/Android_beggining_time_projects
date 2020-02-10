package dell.example.friendzonegrid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {

    Context context;
    String[] friends;
    int[] flags;

    private LayoutInflater inflater;

    CustomAdapter(Context context, String[] friends, int[] flags){
        this.context = context;
        this.friends = friends;
        this.flags = flags;
    }

    @Override
    public int getCount() {
        return friends.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if(view == null) {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.sample_view, viewGroup,false);
        }

        ImageView imageView = view.findViewById(R.id.sampleImageViewId);
        TextView textView = view.findViewById(R.id.sampleTextViewId);


        imageView.setImageResource(flags[i]);
        textView.setText(friends[i]);

        return view;
    }
}
