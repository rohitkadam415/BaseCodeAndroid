package com.myapp.f2c.ViewHolder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.myapp.f2c.R;


/**
 * @author Rohit Kadam
 */
public class UsersViewHolder extends RecyclerView.ViewHolder {
  private ImageView ivDisplay;
  private TextView tvName, tvEchoes;
  private View vwDeviderLine;


  public UsersViewHolder(@NonNull View itemView) {
    super(itemView);
    ivDisplay = itemView.findViewById(R.id.iv_display);
    tvName = itemView.findViewById(R.id.tv_name);
    tvEchoes = itemView.findViewById(R.id.tv_echoes);
    vwDeviderLine = itemView.findViewById(R.id.vw_devider);
  }

  public View getVwDeviderLine() {
    return vwDeviderLine;
  }


  public TextView getTvName() {
    return tvName;
  }

  public TextView getTvEchoes() {
    return tvEchoes;
  }

  public ImageView getIvDisplay() {

    return ivDisplay;
  }
}
