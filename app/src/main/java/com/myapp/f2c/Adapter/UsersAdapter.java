package com.myapp.f2c.Adapter;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import com.myapp.f2c.Model.RecentChatUsermodel;
import com.myapp.f2c.R;
import com.myapp.f2c.ViewHolders.UsersViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rohit Kadam
 */
public class UsersAdapter extends RecyclerView.Adapter<UsersViewHolder>
    implements Filterable {
  private List<RecentChatUsermodel> items;
  private List<RecentChatUsermodel> allitems;

  public UsersAdapter() {
  }

  public void setItems(List<RecentChatUsermodel> items) {
    this.items = items;
    this.allitems = items;
    notifyDataSetChanged();
  }

  @NonNull
  @Override
  public UsersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = ViewGroup.inflate(parent.getContext(), R.layout.holder_chat, null);
    return new UsersViewHolder(view);
  }

  @SuppressLint("ResourceAsColor")
  @Override
  public void onBindViewHolder(@NonNull final UsersViewHolder holder, int position) {

  }

  @Override
  public int getItemCount() {
    return (null == items || items.isEmpty()) ? 0 : items.size();
  }


  @Override
  public Filter getFilter() {
    return new Filter() {
      @Override
      protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();
        String charString = constraint.toString();
        List<RecentChatUsermodel> filteredList = new ArrayList<>();
        if (charString.length() == 0) {
          filteredList = allitems;
        } else {
          for (RecentChatUsermodel recentUsermodel : allitems) {
            if (recentUsermodel
                .getDisplayname()
                .toLowerCase()
                .contains(charString.toLowerCase())) {
              filteredList.add(recentUsermodel);
            }
          }
        }
        results.values = filteredList;
        return results;
      }

      @Override
      protected void publishResults(CharSequence constraint, FilterResults results) {
        items = (ArrayList<RecentChatUsermodel>) results.values;
        notifyDataSetChanged();
      }
    };
  }
}
