package com.example.itrain.demohackathon;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_POSITION = "position";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Set Collapsing Toolbar layout to the screen
        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        // Set title of Detail page
        // collapsingToolbar.setTitle(getString(R.string.item_title));

        int postion = getIntent().getIntExtra(EXTRA_POSITION, 0);
        Resources resources = getResources();
        String[] card = resources.getStringArray(R.array.cards);
        collapsingToolbar.setTitle(card[postion % card.length]);

        String[] details = resources.getStringArray(R.array.card_name);
        TextView detail = (TextView) findViewById(R.id.detail);
        detail.setText(details[postion % details.length]);

        TypedArray pictures = resources.obtainTypedArray(R.array.my_cards);
        ImageView picture = (ImageView) findViewById(R.id.image);
        picture.setImageDrawable(pictures.getDrawable(postion % pictures.length()));

        pictures.recycle();
    }
}

