package com.example.mapstarter;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    //sets the map type to be "hybrid"
    //map.setMapType(GoogleMap.M)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng home = new LatLng(-0.938165791280557, 119.88626815093869);
        LatLng bakery = new LatLng(-0.9308999066103801, 119.88516256147314);
        mMap.addMarker(new MarkerOptions().position(home).title("My Home").
                snippet("Digit's Home").icon(BitmapFromVector(getApplicationContext(),R.mipmap.ic_start)));
        mMap.addMarker(new MarkerOptions().position(bakery).title("GOLDEN BAKERY").
                snippet("Digit's Home").icon(BitmapFromVector(getApplicationContext(),R.drawable.ic_finish)));
        mMap.addPolyline(new PolylineOptions().add(
                home,
                /** BTN **/
                new LatLng(-0.938207799431874, 119.8862662962392),
                new LatLng(-0.9382319365992545, 119.88583513468795),
                new LatLng(-0.938231936598911, 119.88574930399537),
                new LatLng(-0.9382373002970634, 119.88569163650142),
                new LatLng(-0.9382533913929708, 119.88535166650642),
                new LatLng(-0.9382624476060789, 119.88475053925804),
                /** Jl. Guru Tua **/
                new LatLng(-0.9382792202696647, 119.88435686917852),
                new LatLng(-0.9368091055749079, 119.88454370510638),
                new LatLng(-0.9367465757021406, 119.88455621275212),
                new LatLng(-0.936162744074974, 119.88462612173488),
                new LatLng(-0.935852906268577, 119.88461910315321),
                new LatLng(-0.9350298530902906, 119.88463219308818),
                new LatLng(-0.9328181146396238, 119.88469483042566),
                new LatLng(-0.9327024080970503, 119.88470117659763),
                /** Jl. Towua **/
                new LatLng(-0.9325415734002982, 119.88472563168507),
                new LatLng(-0.9315672340095457, 119.88491618687611),
                new LatLng(-0.9310907198759355, 119.88503683675587),
                new LatLng(-0.9308963024105732, 119.88505536952475),
                bakery
                ).width(20)
                .color(Color.rgb(0, 129, 227))
        );
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(home, 14.5f));
        UiSettings uiSettings = googleMap.getUiSettings();
        uiSettings.setCompassEnabled(true);
        uiSettings.setZoomControlsEnabled(true);
        uiSettings.setMyLocationButtonEnabled(true);
    }

    private BitmapDescriptor BitmapFromVector(Context context, int vectorResId) {
        Drawable vectorDrawable = ContextCompat.getDrawable(context, vectorResId);

        vectorDrawable.setBounds(0, 0, vectorDrawable.getIntrinsicWidth(),
                vectorDrawable.getIntrinsicHeight());

        Bitmap bitmap = Bitmap.createBitmap(vectorDrawable.getIntrinsicWidth(),
                vectorDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(bitmap);

        vectorDrawable.draw(canvas);

        return BitmapDescriptorFactory.fromBitmap(bitmap);
    }
}