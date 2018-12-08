package laura.gotarra.tabmyscores;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TabView extends View {

    //private ArrayList<Integer> chords_frets;
    private int min = 22;
    private TabFret F;


    public TabView(Context context) {
        super(context);
        //chords_frets = new ArrayList<>();
        F = new TabFret();
    }

    public TabView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        //this.chords_frets = chords_frets;
        F = new TabFret();
    }

    public TabView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        F = new TabFret();
    }

    /*public void AddChord(ArrayList<Integer> chords_frets){
        this.chords_frets = chords_frets;
    }*/
    public void calculMin(){
        for (int i = 0; i < 6; i++){
            if (F.getFret(i) < min ) {
                min = F.getFret(i);
            }
        }
        System.out.println(min);
        if ( min == 0 ){
            min = 1;
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //Integer min = chords_frets.get(0); //last guitar_fret
        calculMin();

        Paint lines = new Paint();
        lines.setStyle(Paint.Style.STROKE);
        lines.setStrokeWidth(3);
        lines.setARGB(255,128,128,128);

        Paint text = new Paint();
        text.setStrokeWidth(0);
        text.setStyle(Paint.Style.FILL);
        text.setColor(Color.BLACK);
        text.setTextSize(35);

        float y = 30;
        float x = 1;

        for (int i = 0; i < 6; i++) {
            canvas.drawLine(0, y, canvas.getWidth(), y, lines);
            // canvas.drawRect(0, y, canvas.getWidth(), 10+y, lines);
            y+=40;
        }
        for (int i = 0; i<4; i++) {
            canvas.drawLine(x,30,x,y-40,lines);
            //canvas.drawRect(x,30,x+10,y-40,lines);
            x+=(canvas.getWidth()-lines.getStrokeWidth()*10)/4;
        }


        Rect bounds = new Rect();
        text.getTextBounds(Integer.toString(min), 0, 1, bounds);
        x = canvas.getWidth()/8 - bounds.width()/2;
        for (int i = min; i < min + 5; i++) {
            text.getTextBounds(Integer.toString(i), 0, 1, bounds);
            canvas.drawText(Integer.toString(i), x, y+3, text);
            x += canvas.getWidth()/4 - bounds.width()/2;
        }

        /*for (Integer element : chords_frets){


        }*/

    }

}


