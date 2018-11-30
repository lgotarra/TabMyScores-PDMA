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

public class TabView extends View {



    public TabView(Context context) {
        super(context);
    }

    public TabView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TabView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int y = 30;
        int x = 0;

        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setARGB(255,128,128,128);

        for (int i = 0; i < 6; i++) {
            canvas.drawRect(0, y, canvas.getWidth(), 10+y, paint);
            y+=40;
        }
        for (int i = 0; i<5; i++) {
            canvas.drawRect(x,30,x+10,y-40,paint);
            x+=canvas.getWidth()/4-10;

        }

    }

}


