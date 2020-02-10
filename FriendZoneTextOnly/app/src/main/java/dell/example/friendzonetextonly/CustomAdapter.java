package dell.example.friendzonetextonly;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {

    Context context;
    String [] friendsZone;
    int [] images;
    private LayoutInflater layoutInflater;

    CustomAdapter(Context context,String[] friendsZone,int[]images){
        this.context = context;
        this.friendsZone = friendsZone;
        this.images = images;
    }

    @Override
    public int getCount() {
        return friendsZone.length;
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


        if(view == null)
        {
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.sampleview,viewGroup,false);
        }

        TextView textView = view.findViewById(R.id.sampleTextView);
        ImageView imageView = view.findViewById(R.id.sampleImageId);

        textView.setText(friendsZone[i]);
        imageView.setImageResource(images[i]);

        return view;
    }
}
