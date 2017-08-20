package com.arpan.applauncher;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class AppsAdapter extends RecyclerView.Adapter<AppsAdapter.AppsViewHolder>{

    private static final String TAG = AppsAdapter.class.getSimpleName();
    private App[] mApps;

    public AppsAdapter(App[] apps) {

        mApps = apps;

    }

    @Override
    public AppsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.app_list_item, parent, false);

        AppsViewHolder appsViewHolder = new AppsViewHolder(view);

        return appsViewHolder;
    }

    @Override
    public void onBindViewHolder(AppsViewHolder holder, int position) {

        while (mApps == null) {
            Log.d(TAG, "onBindViewHolder: NULL");
        }

        Log.d(TAG, "onBindViewHolder: EXA " + mApps[position].getAppName() + " " + mApps[position].getAppActivity());
        holder.mAppsLabel.setText(mApps[position].getAppName());
        holder.mAppsActivityLabel.setText(mApps[position].getAppActivity());

    }

    @Override
    public int getItemCount() {
        return mApps.length;
    }

    public class AppsViewHolder extends RecyclerView.ViewHolder {

        public TextView mAppsLabel;
        public TextView mAppsActivityLabel;

        public AppsViewHolder(View itemView) {
            super(itemView);

            mAppsLabel = (TextView) itemView.findViewById(R.id.AppNameLabel);
            mAppsActivityLabel = (TextView) itemView.findViewById(R.id.AppActivityLabel);

        }

        public void bindApp(App app) {

            app.setAppName(mAppsLabel.toString());
            app.setAppActivity(mAppsActivityLabel.toString());

        }
    }

}
