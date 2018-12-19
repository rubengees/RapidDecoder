package rapid.decoder.sample;

import android.graphics.Bitmap;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import rapid.decoder.BitmapDecoder;

public class ScaledDecodingFragment extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		return inflater.inflate(R.layout.fragment_scaled_decoding, container, false);
	}

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageView imageJpeg = (ImageView) view.findViewById(R.id.image_jpeg);
        ImageView imagePng = (ImageView) view.findViewById(R.id.image_png);
        TextView textJpegInfo = (TextView) view.findViewById(R.id.text_jpeg_info);
        TextView textPngInfo = (TextView) view.findViewById(R.id.text_png_info);

        int width = getResources().getDimensionPixelSize(R.dimen.scaled_decoding_width);
        int height = getResources().getDimensionPixelSize(R.dimen.scaled_decoding_height);

        BitmapDecoder decoder;
        Bitmap bitmap;
        int sourceWidth;
        int sourceHeight;

        // Jpeg

        decoder = BitmapDecoder.from(getResources(), R.drawable.amanda);
        sourceWidth = decoder.width();
        sourceHeight = decoder.height();

        bitmap = decoder
                .scale(width, height)
                .useBuiltInDecoder(MainActivity.TEST_BUILT_IN_DECODER)
                .decode();
        imageJpeg.setImageBitmap(bitmap);

        //noinspection ConstantConditions
        textJpegInfo.setText("Source width = " + sourceWidth + ", Source height = " + sourceHeight + "\n" +
                "Bitmap width = " + bitmap.getWidth() + ", Bitmap height = " + bitmap.getHeight());

        // Png

        decoder = BitmapDecoder.from(getResources(), R.drawable.amanda2);
        sourceWidth = decoder.width();
        sourceHeight = decoder.height();

        bitmap = decoder
                .scale(width, height)
                .useBuiltInDecoder(MainActivity.TEST_BUILT_IN_DECODER)
                .decode();
        imagePng.setImageBitmap(bitmap);

        //noinspection ConstantConditions
        textPngInfo.setText("Source width = " + sourceWidth + ", Source height = " + sourceHeight + "\n" +
                "Bitmap width = " + bitmap.getWidth() + ", Bitmap height = " + bitmap.getHeight());
    }
}
