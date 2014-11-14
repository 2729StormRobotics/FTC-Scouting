package com.example.stormscouter;

import java.util.Hashtable;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
 
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
 
@SuppressLint("ViewConstructor")
public class DrawQRCode extends View{
     
    String input = "";
    int size;
    int csize = 8;
     
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    public DrawQRCode(Context context, String message){
        super(context);
         
        WindowManager window = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = window.getDefaultDisplay();
        Point wS = new Point();
         
        display.getSize(wS);
         
        this.size = wS.x / 8;
         
        input = message;
    }
    @SuppressWarnings("unchecked")
    public void draw(Canvas c){
        c.scale(csize, csize, 5, 0);
         
        //qr code
        //makes a qr code then draws it
        try{            
            @SuppressWarnings("rawtypes")
            Hashtable hintMap = new Hashtable();
            hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
            QRCodeWriter qrCodeWriter = new QRCodeWriter(); //from zxing library
            BitMatrix Matrix = qrCodeWriter.encode(input, BarcodeFormat.QR_CODE, size, size, hintMap);
             
            //drawing from bitMatrix
            int matrixWidth = Matrix.getWidth();
             
            Paint b = new Paint();
            b.setColor(Color.BLACK);
            b.setStyle(Paint.Style.FILL);
             
            for (int i = 0; i < matrixWidth; i++) {
                for (int j = 0; j < matrixWidth; j++) {
                    if (Matrix.get(i, j)) {
                        //drawing black rectangles
                        Rect r = new Rect();
                        r.set(i, j, i+1, j+1);
                         
                        c.drawRect(r, b);
                    }
                }
            }
             
             
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
