package com.example.android.recyview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.android.recyview.R;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static RecyclerView mRecyclerView;
    private static RecyclerView.LayoutManager mLayoutManager;
    private static RecyclerView.Adapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);



        // specify an adapter
        mAdapter = new AppAdaptor(numbers);
        mRecyclerView.setAdapter(mAdapter);

    }
}
class AppAdaptor extends RecyclerView.Adapter<AppAdaptor.ViewHolder> {
    private  List<Integer> mDataset;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;

        public ViewHolder(View v) {
            super(v);
            mTextView = (TextView) v.findViewById(R.id.itemTest);
        }
    }

    public AppAdaptor( List<Integer> myDataset) {
        mDataset = myDataset;
    }

    // Create new views
    @Override
    public AppAdaptor.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v =   LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item1, parent, false);
        ViewHolder vh =  new ViewHolder(v);
        return vh;

    }

    // Replace the contents of a view (recycle)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        int number = mDataset.get(position);

        holder.mTextView.setText(Integer.toString(number));

    }

    // Return the size of your dataset
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}







