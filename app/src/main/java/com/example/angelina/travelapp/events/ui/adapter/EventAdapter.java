package com.example.angelina.travelapp.events.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.angelina.travelapp.R;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import com.example.angelina.travelapp.events.api.model.Event;
import com.example.angelina.travelapp.events.ui.event.LoadMoreEvents;
import com.example.angelina.travelapp.events.ui.viewholder.EventViewHolder;

public class EventAdapter extends RecyclerView.Adapter<EventViewHolder> {
    private List<Event> listEvents;
    private boolean isKeepLoading;

    public EventAdapter(ArrayList<Event> listEvents) {
        this.listEvents = listEvents;
        this.isKeepLoading = true;
    }

    @Override
    public EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_event, parent, false);
        EventViewHolder eventViewHolder = new EventViewHolder(view);
        return eventViewHolder;
    }

    @Override
    public void onBindViewHolder(EventViewHolder holder, int position) {
        if (isKeepLoading && position == listEvents.size() - 10) {
            EventBus.getDefault().post(new LoadMoreEvents());
        }
        holder.setEvent(listEvents.get(position));
    }

    @Override
    public int getItemCount() {
        return listEvents.size();
    }

    public void add(List<Event> eventList) {
        listEvents.addAll(eventList);
    }

    public void setKeepLoading(boolean keepLoading) {
        isKeepLoading = keepLoading;
    }

    public void reset() {
        isKeepLoading = true;
        listEvents.clear();
        notifyDataSetChanged();
    }
}
