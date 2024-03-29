package com.example.mymoveleview;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.net.URL;
import java.util.HashMap;

public class ImageLodeTask extends AsyncTask<Void, Void, Bitmap> {

    private String urlStr;
    private ImageView imageView;

    private static HashMap<String, Bitmap> bitmapHash = new HashMap<String, Bitmap>();

    public ImageLodeTask(String urlStr, ImageView imageView) {

        this.urlStr = urlStr;
        this.imageView = imageView;

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }


    @Override
    protected Bitmap doInBackground(Void... voids) {
        Bitmap bitmap = null;

        try {

            if (bitmapHash.containsKey(urlStr)){
                Bitmap oldbitmap = bitmapHash.remove(urlStr);

                if (oldbitmap != null){
                    oldbitmap.recycle();
                    oldbitmap = null;
                }
            }

            URL url2 = new URL(urlStr);
            bitmap = BitmapFactory.decodeStream(url2.openConnection().getInputStream());


            bitmapHash.put(urlStr, bitmap);

        }catch (Exception e){
            e.printStackTrace();
        }

            return bitmap;
    }



    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);

        imageView.setImageBitmap(bitmap);
        imageView.invalidate();
    }

}
