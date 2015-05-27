package fox.test.bikemethere;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.app.Activity;
import android.text.AlteredCharSequence;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.support.v4.app.Fragment;
import android.widget.EditText;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import com.android.volley.*;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import android.app.AlertDialog;
import android.widget.FrameLayout;
import android.content.DialogInterface;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import org.json.JSONObject;



public class MainActivity extends FragmentActivity {
	public LocationManager locationManager;
	public LocationListener locationListener;
	public Context context;

	//public Context context = this;
	public AlertDialog myalert;
	private JSONObject jsonObject;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		//Setting layout to the mail layout
		setContentView(R.layout.activity_main);

		//FrameLayout f1 = (FrameLayout) findViewById(android.R.id.custom);
		//f1.addView(R.layout.activity_main, new LayoutParams(MATCH_PARENT, WRAP_CONTENT));

		Button startSearch = (Button) findViewById(R.id.button1);

		startSearch.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				final EditText textbox1 = (EditText) findViewById(R.id.editText1);
				final EditText textbox2 = (EditText) findViewById(R.id.editText2);

				// Instantiate the RequestQueue
				String url = "https://maps.googleapis.com/maps/api/directions/json?origin=\" + textbox1 + \"&destination=\" + textbox2&mode=bicycling&key=AIzaSyADIGXHor2l0qKD-cF21Iw-ZxaHgP2-zJo";
				RequestQueue queue = Volley.newRequestQueue(context);

				// Request a string response from string "url".
				StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
					@Override
					public void onResponse(String response) {
						//Extract myextract = new Extract(response);
						//TODO: extract search data
						//TODO: load up google results - switch views
					}
				}, new Response.ErrorListener() {
					 @Override
					 public void onErrorResponse(VolleyError error) {
					 	//TODO: on error, pop up error message
					 }
				 });
				// Add the request to the RequestQueue
				queue.add(stringRequest);

			}

			;
		});



		locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);

		locationListener = new LocationListener() {
			@Override
			public void onLocationChanged(Location location) {

			}

			@Override
			public void onStatusChanged(String s, int i, Bundle bundle) {
			}

			@Override
			public void onProviderEnabled(String s) {

			}

			@Override
			public void onProviderDisabled(String s) {
				//myalert.setMessage("Error: GPS Disabled.");
			}
		};

		locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);

		//if GPS is off, alert user
	}

	/*public Context contextStatus() {
		return Context(this);
	}*/

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void onDestroy() {
		locationManager.removeUpdates(locationListener);
	}

}
