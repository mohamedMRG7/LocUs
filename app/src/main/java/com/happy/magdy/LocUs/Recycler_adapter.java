package com.happy.magdy.LocUs;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * Created by moham on 17/10/2016.
 */

public class Recycler_adapter extends RecyclerView.Adapter<Recycler_adapter.ViewHolder>
{

    int [] img;
    String[] title ,placeRegion;
    Context ctx;
    boolean [] isAvailable;

    public Recycler_adapter(String[] title, int [] img, Context ctx, String[] placeregion , boolean []isAvailable) {
        this.title = title;
        this.ctx =ctx;
        this.img=img;
        this.placeRegion=placeregion;
        this.isAvailable=isAvailable;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView txt,placeRegion,avalability;
        public ImageView imageView;
        public CardView cv;
        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            txt=(TextView)itemView.findViewById(R.id.txt_placeName);
            imageView=(ImageView)itemView.findViewById(R.id.img_place);
            placeRegion=(TextView) itemView.findViewById(R.id.txt_placeRegion);
            avalability=(TextView)itemView.findViewById(R.id.txt_internetAvalability);
            cv=(CardView)itemView.findViewById(R.id.card);
        }
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater= LayoutInflater.from(ctx);
        View v=inflater.inflate(R.layout.inf_recycler,parent,false);

        ViewHolder viewHolder=new ViewHolder(v);


        return viewHolder;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        TextView textView=holder.txt;
        TextView placeregion=holder.placeRegion;
        TextView available=holder.avalability;
        ImageView imgholder=holder.imageView;
        CardView card=holder.cv;
        textView.setText(title[position]);
        placeregion.setText(placeRegion[position]);

        available(available,isAvailable[position]);


        imgholder.setImageResource(img[position]);

        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ctx,details.class);
                i.putExtra("name", img[position]);
                i.putExtra("pos",position);
                ctx.startActivity(i);
            }
        });


    }

        public  void available (TextView v, boolean isAvailable)
        {

            if(isAvailable)
            {
                v.setText("AVAILABLE");

                v.setTextColor(ctx.getResources().getColor(R.color.screen2));
            } else
            {
                v.setText("UNAVAILABLE");

                v.setTextColor(ctx.getResources().getColor(R.color.screen1));
            }
        }


    @Override
    public int getItemCount() {
        return title.length;
    }
}
