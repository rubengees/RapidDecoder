package rapid.decoder.util;

import android.graphics.Point;
import android.view.Display;

import static rapid.decoder.cache.ResourcePool.POINT;

public class DisplayUtils {

    public static int getWidth(Display display) {
        final Point size = POINT.obtain();
        display.getSize(size);
        final int width = size.x;
        POINT.recycle(size);

        return width;
    }

    public static int getHeight(Display display) {
        final Point size = POINT.obtain();
        display.getSize(size);
        final int height = size.y;
        POINT.recycle(size);

        return height;
    }

    public static void getSize(Display display, Point outSize) {
        display.getSize(outSize);
    }
}
