package com.example.myfirsttestapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.widget.ImageView;

public class DetailView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);

        Intent previousIntent = getIntent();
        int index = previousIntent.getIntExtra("com.example.myfirsttestapplication.ITEM_INDEX", -1);

        if (index > -1){
            int pic = getImage(index);
            ImageView img = (ImageView) findViewById(R.id.itemView);
            scaleImage(img, pic);
        }

    }

    private int getImage(int index){
        switch (index) {
            case 0:
                return R.drawable.briochebread;
            case 1:
                return R.drawable.poachedeggs;
            case 2:
                return R.drawable.hollandaisesauce;
            case 3:
                return R.drawable.salmon;
            case 4:
                return R.drawable.avocado;
            default:
                return -1;
        }

    }

    private void scaleImage(ImageView img, int pic ){
        Display screen = getWindowManager().getDefaultDisplay();
        BitmapFactory.Options options = new BitmapFactory.Options();

        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), pic, options);

        int imgWidth = options.outWidth;
        int screenWidth = screen.getWidth();

        if (imgWidth > screenWidth) {
            int ratio = Math.round((float) imgWidth/(float) screenWidth);
            options.inSampleSize = ratio;
        }

        options.inJustDecodeBounds = false;
        Bitmap scaleImage = BitmapFactory.decodeResource(getResources(), pic, options);
        img.setImageBitmap(scaleImage);

    }
}
