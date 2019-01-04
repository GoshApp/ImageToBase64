package com.rikmen00gmail.imagetobase64;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView2;
    private EditText textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (EditText) findViewById(R.id.txView);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.testimage);
//R.drawable.images is image for my ImageView
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 90, stream);
        byte[] imageByteArray = stream.toByteArray();
        System.out.println("byte array:" + imageByteArray);

        String img_str = Base64.encodeToString(imageByteArray, 0);
        Log.d("deb", img_str);
        System.out.println("string:" + img_str);
        textView.setText(img_str);

        //decode base64 string to image
        imageByteArray = Base64.decode(img_str, Base64.DEFAULT);
        Bitmap decodedImage = BitmapFactory.decodeByteArray(imageByteArray, 0, imageByteArray.length);
        imageView2.setImageBitmap(decodedImage);
    }

}
