package za.co.boxstudio.Old;

import android.app.LocalActivityManager;
import android.content.Context;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.renderscript.Element;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import mehdi.sakout.aboutpage.AboutPage;
import za.co.boxstudio.R;

public class tab4 extends Fragment implements OnMapReadyCallback {

    private MapView mMapView;
    //constants.jav file
    public static final String MAPVIEW_BUNDLE_KEY = "MapViewBundleKey";
    private GoogleMap map;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.tab4contents, container, false);

        Bundle mapViewBundle = null;
        if(savedInstanceState != null){
            mapViewBundle = savedInstanceState.getBundle(MAPVIEW_BUNDLE_KEY);
        }
        mMapView.onCreate(mapViewBundle);
        mMapView.getMapAsync( this);

        return root;

    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        mMapView = (MapView)getView().findViewById(R.id.map1);

    }

        public void onStart() {
        super.onStart();

            TextView text1 = (TextView) getView().findViewById(R.id.textView2);
            text1.setMovementMethod(LinkMovementMethod.getInstance());

            TextView text2 = (TextView) getView().findViewById(R.id.textView3);
            text2.setMovementMethod(LinkMovementMethod.getInstance());

            TextView text3 = (TextView) getView().findViewById(R.id.textView4);
            text3.setMovementMethod(LinkMovementMethod.getInstance());

            TextView text4 = (TextView) getView().findViewById(R.id.textView5);
            text4.setMovementMethod(LinkMovementMethod.getInstance());

            mMapView.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        mMapView.onStop();
    }

    @Override
    public void onMapReady(GoogleMap map) {
        map.addMarker(new MarkerOptions().position(new LatLng(0, 0)).title("Marker"));
    }

    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }
}



