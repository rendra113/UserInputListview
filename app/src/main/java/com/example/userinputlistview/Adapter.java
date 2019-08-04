package com.example.userinputlistview;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Adapter extends ArrayAdapter<Hero> {

    List<Hero> herolist;
    Context context;
    int resource;

    public Adapter(Context context, int resource, List<Hero>herolist){
        super(context,resource,herolist);
        this.context  = context;
        this.resource = resource;
        this.herolist = herolist;

    }
    @NonNull

    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        View view = layoutInflater.inflate(resource, null, false);

        ImageView imageView = view.findViewById(R.id.image);
        TextView textViewName = view.findViewById(R.id.txt_hero_name);
        TextView textViewTeam = view.findViewById(R.id.team);
        Button btnDel = view.findViewById(R.id.);

        Hero hero = herolist.get(position);

        imageView.setImageDrawable(context.getResources().getDrawable(hero.getImage()));
        textViewName.setText(hero.getName());
        textViewTeam.setText(hero.getTeam());

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hapusGambar(position);
            }
        });

        return view;
    }

    private void hapusGambar(final int position) {
        AlertDialog.Builder adb = new AlertDialog.Builder(context);
        adb.setTitle("Yakin Ingin Menghapus Gambar ?");
        adb.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                herolist.remove(position);
            }
        }).setNegativeButton("No ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(context, "Tidak Jadi Di Hapus", Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog alertDialog = adb.create();
        alertDialog.show();
    }
}
