//package br.com.fsilveira.onroute_mobile;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import android.graphics.Color;
//import android.os.Bundle;
//import android.support.v4.app.FragmentActivity;
//import br.com.fsilveira.onroute_mobile.directions.Route;
//import br.com.fsilveira.onroute_mobile.directions.RoutingListener;
//import br.com.fsilveira.onroute_mobile.directions.TravelMode;
//import br.com.fsilveira.onroute_mobile.route.TaskRouteAPI;
//
//import com.google.android.gms.maps.CameraUpdate;
//import com.google.android.gms.maps.CameraUpdateFactory;
//import com.google.android.gms.maps.GoogleMap;
//import com.google.android.gms.maps.MapFragment;
//import com.google.android.gms.maps.model.BitmapDescriptorFactory;
//import com.google.android.gms.maps.model.LatLng;
//import com.google.android.gms.maps.model.MarkerOptions;
//import com.google.android.gms.maps.model.PolylineOptions;
//
//public class ExampleMainActivity extends FragmentActivity implements RoutingListener {
//
//	protected GoogleMap map;
//	protected List<String> pointsStr = new ArrayList<String>();
//	private TaskRouteAPI<String> taskRouteAPI;
//	/**
//	 * This activity loads a map and then displays the route and pushpins on it.
//	 */
//	@Override
//	public void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		setContentView(R.layout.example_activity_main);
//
//		map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
//
//		taskRouteAPI = new TaskRouteAPI<String>(TravelMode.DRIVING);
//		taskRouteAPI.registerListener(this);
//		taskRouteAPI.execute();		
//
//	}
//
//	public void onRoutingSuccess(PolylineOptions mPolyOptions, Route route) {
//		PolylineOptions polyoptions = new PolylineOptions();
//		polyoptions.color(Color.BLUE);
//		polyoptions.width(10);
//		polyoptions.addAll(mPolyOptions.getPoints());
//		map.addPolyline(polyoptions);
//
//		int index = 0;
//		for (LatLng point : route.getMarkers()) {
//			int resource;
//			if (index == 0) {
//				resource = R.drawable.start_blue;
//			} else if (index == route.getMarkers().size()-1 ) {
//				 resource = R.drawable.end_green;
//			} else {
//				 resource = R.drawable.end_orange;
//			}
//
//			MarkerOptions options = new MarkerOptions();
//			options.position(point);
//
//			options.icon(BitmapDescriptorFactory.fromResource(resource));
//			map.addMarker(options);
//			
//			index++;
//		}
//
//		List<LatLng> performedPoints = getPerformedPoints();
//
//		PolylineOptions polyoptions3 = new PolylineOptions();
//		polyoptions3.color(Color.RED);
//		polyoptions3.width(8);
//		polyoptions3.addAll(performedPoints);
//		map.addPolyline(polyoptions3);
//
//		// CameraUpdate center = CameraUpdateFactory.newLatLng(new LatLng(-27.7994928, -49.487481));
//		LatLng currentPosition = performedPoints.get(performedPoints.size() - 1);
//		MarkerOptions options = new MarkerOptions();
//		options.position(currentPosition);
//		options.icon(BitmapDescriptorFactory.fromResource(R.drawable.end_red));
//		map.addMarker(options);
//		CameraUpdate center = CameraUpdateFactory.newLatLng(currentPosition);
//		CameraUpdate zoom = CameraUpdateFactory.zoomTo(15);
//
//		map.moveCamera(center);
//		map.animateCamera(zoom);
//
//	}
//
//	public void onRoutingFailure() {
//		// TODO Auto-generated method stub
//
//	}
//
//	public void onRoutingStart() {
//		// TODO Auto-generated method stub
//
//	}
//
//	private List<LatLng> getPerformedPoints() {
//		List<LatLng> latLngs = new ArrayList<LatLng>();
//		latLngs.add(new LatLng(-28.81083, -49.88255));
//		latLngs.add(new LatLng(-28.81168, -49.88145));
//		latLngs.add(new LatLng(-28.81239, -49.88052));
//		latLngs.add(new LatLng(-28.81379, -49.87868));
//		latLngs.add(new LatLng(-28.8148, -49.87738));
//		latLngs.add(new LatLng(-28.81496, -49.87716));
//		latLngs.add(new LatLng(-28.81503, -49.87705));
//		latLngs.add(new LatLng(-28.81509, -49.87692));
//		latLngs.add(new LatLng(-28.81518, -49.87669));
//		latLngs.add(new LatLng(-28.81531, -49.87623));
//		latLngs.add(new LatLng(-28.81553, -49.87533));
//		latLngs.add(new LatLng(-28.81561, -49.87504));
//		latLngs.add(new LatLng(-28.81566, -49.87491));
//		latLngs.add(new LatLng(-28.81577, -49.87465));
//		latLngs.add(new LatLng(-28.81605, -49.87409));
//		latLngs.add(new LatLng(-28.81622, -49.87387));
//		latLngs.add(new LatLng(-28.81638, -49.87369));
//		latLngs.add(new LatLng(-28.81645, -49.8736));
//		latLngs.add(new LatLng(-28.8172, -49.87287));
//		latLngs.add(new LatLng(-28.8181, -49.87199));
//		latLngs.add(new LatLng(-28.8186, -49.87149));
//		latLngs.add(new LatLng(-28.81891, -49.87118));
//		latLngs.add(new LatLng(-28.81941, -49.87068));
//		latLngs.add(new LatLng(-28.81968, -49.8704));
//		latLngs.add(new LatLng(-28.81988, -49.87016));
//		latLngs.add(new LatLng(-28.8199, -49.87014));
//		latLngs.add(new LatLng(-28.82001, -49.86997));
//		latLngs.add(new LatLng(-28.82014, -49.86971));
//		latLngs.add(new LatLng(-28.82024, -49.86949));
//		latLngs.add(new LatLng(-28.82037, -49.86896));
//		latLngs.add(new LatLng(-28.82038, -49.86892));
//		latLngs.add(new LatLng(-28.82046, -49.86843));
//		latLngs.add(new LatLng(-28.82049, -49.86824));
//		latLngs.add(new LatLng(-28.82057, -49.86787));
//		latLngs.add(new LatLng(-28.82062, -49.86773));
//		latLngs.add(new LatLng(-28.82066, -49.86764));
//		latLngs.add(new LatLng(-28.82073, -49.86747));
//		latLngs.add(new LatLng(-28.82083, -49.86732));
//		latLngs.add(new LatLng(-28.82085, -49.86727));
//		latLngs.add(new LatLng(-28.821, -49.86705));
//		latLngs.add(new LatLng(-28.82111, -49.86687));
//		latLngs.add(new LatLng(-28.82127, -49.86663));
//		latLngs.add(new LatLng(-28.82149, -49.86627));
//		latLngs.add(new LatLng(-28.82153, -49.86621));
//		latLngs.add(new LatLng(-28.82178, -49.86582));
//		latLngs.add(new LatLng(-28.82185, -49.8657));
//		latLngs.add(new LatLng(-28.82217, -49.86523));
//		latLngs.add(new LatLng(-28.8224, -49.86488));
//		latLngs.add(new LatLng(-28.82275, -49.86434));
//		latLngs.add(new LatLng(-28.82285, -49.86417));
//		latLngs.add(new LatLng(-28.82305, -49.86386));
//		latLngs.add(new LatLng(-28.82324, -49.86356));
//		latLngs.add(new LatLng(-28.8239, -49.8625));
//		latLngs.add(new LatLng(-28.82417, -49.86209));
//		latLngs.add(new LatLng(-28.82467, -49.8613));
//		latLngs.add(new LatLng(-28.82477, -49.86115));
//		latLngs.add(new LatLng(-28.8249, -49.86094));
//		latLngs.add(new LatLng(-28.82502, -49.86072));
//		latLngs.add(new LatLng(-28.82517, -49.8605));
//		latLngs.add(new LatLng(-28.82531, -49.86027));
//		latLngs.add(new LatLng(-28.82533, -49.86024));
//		latLngs.add(new LatLng(-28.82567, -49.85972));
//		latLngs.add(new LatLng(-28.82577, -49.85955));
//		latLngs.add(new LatLng(-28.82608, -49.85905));
//		latLngs.add(new LatLng(-28.82618, -49.85889));
//		latLngs.add(new LatLng(-28.82638, -49.85856));
//		latLngs.add(new LatLng(-28.82659, -49.85824));
//		latLngs.add(new LatLng(-28.82683, -49.85786));
//		latLngs.add(new LatLng(-28.82702, -49.85755));
//		latLngs.add(new LatLng(-28.82736, -49.85699));
//		latLngs.add(new LatLng(-28.8274, -49.85692));
//		latLngs.add(new LatLng(-28.8278, -49.8563));
//		latLngs.add(new LatLng(-28.82787, -49.8562));
//		latLngs.add(new LatLng(-28.82808, -49.85585));
//		latLngs.add(new LatLng(-28.82867, -49.85483));
//		latLngs.add(new LatLng(-28.82868, -49.85479));
//		latLngs.add(new LatLng(-28.82872, -49.85471));
//		latLngs.add(new LatLng(-28.82878, -49.8546));
//		latLngs.add(new LatLng(-28.82885, -49.85449));
//		latLngs.add(new LatLng(-28.82891, -49.85438));
//		latLngs.add(new LatLng(-28.82897, -49.85428));
//		latLngs.add(new LatLng(-28.82903, -49.85418));
//		latLngs.add(new LatLng(-28.82909, -49.85409));
//		latLngs.add(new LatLng(-28.82914, -49.85401));
//		latLngs.add(new LatLng(-28.82919, -49.85393));
//		latLngs.add(new LatLng(-28.82926, -49.85383));
//		latLngs.add(new LatLng(-28.82932, -49.85374));
//		latLngs.add(new LatLng(-28.82938, -49.85367));
//		latLngs.add(new LatLng(-28.82946, -49.85356));
//		latLngs.add(new LatLng(-28.8295, -49.8535));
//		latLngs.add(new LatLng(-28.8296, -49.85338));
//		latLngs.add(new LatLng(-28.8297, -49.85324));
//		latLngs.add(new LatLng(-28.82979, -49.85312));
//		latLngs.add(new LatLng(-28.83003, -49.85277));
//		latLngs.add(new LatLng(-28.8303, -49.85238));
//		latLngs.add(new LatLng(-28.83032, -49.85235));
//		latLngs.add(new LatLng(-28.83035, -49.8523));
//		latLngs.add(new LatLng(-28.83038, -49.85226));
//		latLngs.add(new LatLng(-28.83041, -49.85221));
//		latLngs.add(new LatLng(-28.83045, -49.85215));
//		latLngs.add(new LatLng(-28.83047, -49.85211));
//		latLngs.add(new LatLng(-28.8305, -49.85206));
//		latLngs.add(new LatLng(-28.83054, -49.85199));
//		latLngs.add(new LatLng(-28.83058, -49.85191));
//		latLngs.add(new LatLng(-28.83061, -49.85184));
//		latLngs.add(new LatLng(-28.8307, -49.85165));
//		latLngs.add(new LatLng(-28.8308, -49.85145));
//		latLngs.add(new LatLng(-28.83091, -49.8512));
//		latLngs.add(new LatLng(-28.83106, -49.85088));
//		latLngs.add(new LatLng(-28.83121, -49.85057));
//		latLngs.add(new LatLng(-28.83129, -49.85038));
//		latLngs.add(new LatLng(-28.83138, -49.85019));
//		latLngs.add(new LatLng(-28.83149, -49.84995));
//		latLngs.add(new LatLng(-28.83189, -49.84912));
//		latLngs.add(new LatLng(-28.83249, -49.84785));
//		latLngs.add(new LatLng(-28.83263, -49.84756));
//		latLngs.add(new LatLng(-28.83274, -49.84732));
//		latLngs.add(new LatLng(-28.83286, -49.84707));
//		latLngs.add(new LatLng(-28.83285, -49.84705));
//		latLngs.add(new LatLng(-28.83285, -49.84702));
//		latLngs.add(new LatLng(-28.83284, -49.84697));
//		latLngs.add(new LatLng(-28.83283, -49.84691));
//		latLngs.add(new LatLng(-28.83282, -49.84686));
//		latLngs.add(new LatLng(-28.83281, -49.84684));
//		latLngs.add(new LatLng(-28.83269, -49.84651));
//		latLngs.add(new LatLng(-28.83258, -49.84621));
//		latLngs.add(new LatLng(-28.83243, -49.84584));
//		latLngs.add(new LatLng(-28.83243, -49.84583));
//		latLngs.add(new LatLng(-28.83243, -49.84581));
//		latLngs.add(new LatLng(-28.83245, -49.84574));
//		latLngs.add(new LatLng(-28.83269, -49.84485));
//		latLngs.add(new LatLng(-28.83287, -49.84418));
//		latLngs.add(new LatLng(-28.83317, -49.84308));
//		latLngs.add(new LatLng(-28.83325, -49.84276));
//		latLngs.add(new LatLng(-28.83353, -49.8417));
//		latLngs.add(new LatLng(-28.83366, -49.84122));
//		latLngs.add(new LatLng(-28.83375, -49.84088));
//		latLngs.add(new LatLng(-28.83384, -49.84053));
//		latLngs.add(new LatLng(-28.83393, -49.84017));
//		latLngs.add(new LatLng(-28.83403, -49.8398));
//		latLngs.add(new LatLng(-28.83414, -49.83926));
//		latLngs.add(new LatLng(-28.83415, -49.8392));
//		latLngs.add(new LatLng(-28.83415, -49.83916));
//		latLngs.add(new LatLng(-28.83416, -49.83912));
//		latLngs.add(new LatLng(-28.83417, -49.83905));
//		latLngs.add(new LatLng(-28.83417, -49.83897));
//		latLngs.add(new LatLng(-28.83416, -49.83888));
//		latLngs.add(new LatLng(-28.83416, -49.83878));
//		latLngs.add(new LatLng(-28.83415, -49.83868));
//		latLngs.add(new LatLng(-28.83415, -49.83863));
//		latLngs.add(new LatLng(-28.83414, -49.83857));
//		latLngs.add(new LatLng(-28.83413, -49.83851));
//		latLngs.add(new LatLng(-28.83412, -49.83846));
//		latLngs.add(new LatLng(-28.83411, -49.8384));
//		latLngs.add(new LatLng(-28.83409, -49.83835));
//		latLngs.add(new LatLng(-28.83408, -49.83831));
//		latLngs.add(new LatLng(-28.83407, -49.83825));
//		latLngs.add(new LatLng(-28.83405, -49.8382));
//		latLngs.add(new LatLng(-28.83404, -49.83817));
//		latLngs.add(new LatLng(-28.83402, -49.83811));
//		latLngs.add(new LatLng(-28.83394, -49.83786));
//		latLngs.add(new LatLng(-28.83376, -49.8373));
//		latLngs.add(new LatLng(-28.8337, -49.83709));
//		latLngs.add(new LatLng(-28.83362, -49.83683));
//		latLngs.add(new LatLng(-28.83352, -49.83653));
//		latLngs.add(new LatLng(-28.83345, -49.8363));
//		latLngs.add(new LatLng(-28.83334, -49.83597));
//		latLngs.add(new LatLng(-28.83329, -49.83581));
//		latLngs.add(new LatLng(-28.83323, -49.83565));
//		latLngs.add(new LatLng(-28.83319, -49.8355));
//		latLngs.add(new LatLng(-28.83315, -49.8353));
//		latLngs.add(new LatLng(-28.83314, -49.83528));
//		latLngs.add(new LatLng(-28.83312, -49.83517));
//		latLngs.add(new LatLng(-28.83311, -49.83503));
//		latLngs.add(new LatLng(-28.8331, -49.83492));
//		latLngs.add(new LatLng(-28.8331, -49.83477));
//		latLngs.add(new LatLng(-28.83311, -49.83455));
//		latLngs.add(new LatLng(-28.83313, -49.83435));
//		latLngs.add(new LatLng(-28.83315, -49.83418));
//		latLngs.add(new LatLng(-28.83317, -49.83402));
//		latLngs.add(new LatLng(-28.8332, -49.83379));
//		latLngs.add(new LatLng(-28.83321, -49.83364));
//		latLngs.add(new LatLng(-28.83322, -49.83361));
//		latLngs.add(new LatLng(-28.83322, -49.83359));
//		latLngs.add(new LatLng(-28.83324, -49.83342));
//		latLngs.add(new LatLng(-28.83328, -49.83314));
//		latLngs.add(new LatLng(-28.83328, -49.83308));
//		latLngs.add(new LatLng(-28.83329, -49.83305));
//		latLngs.add(new LatLng(-28.83332, -49.83279));
//		latLngs.add(new LatLng(-28.83335, -49.83247));
//		latLngs.add(new LatLng(-28.8334, -49.83203));
//		latLngs.add(new LatLng(-28.83345, -49.83158));
//		latLngs.add(new LatLng(-28.83346, -49.8315));
//		latLngs.add(new LatLng(-28.83353, -49.83089));
//		latLngs.add(new LatLng(-28.83353, -49.83088));
//		latLngs.add(new LatLng(-28.83358, -49.83047));
//		latLngs.add(new LatLng(-28.83365, -49.82993));
//		latLngs.add(new LatLng(-28.83369, -49.82952));
//		latLngs.add(new LatLng(-28.83377, -49.82888));
//		latLngs.add(new LatLng(-28.83382, -49.82843));
//		latLngs.add(new LatLng(-28.83384, -49.82818));
//		latLngs.add(new LatLng(-28.83385, -49.82806));
//		latLngs.add(new LatLng(-28.83392, -49.82748));
//		latLngs.add(new LatLng(-28.83399, -49.82694));
//		latLngs.add(new LatLng(-28.83405, -49.82644));
//		latLngs.add(new LatLng(-28.83414, -49.82565));
//		latLngs.add(new LatLng(-28.83417, -49.82543));
//		latLngs.add(new LatLng(-28.8342, -49.8252));
//		latLngs.add(new LatLng(-28.83423, -49.82494));
//		latLngs.add(new LatLng(-28.83426, -49.82466));
//		latLngs.add(new LatLng(-28.83426, -49.82465));
//		latLngs.add(new LatLng(-28.83429, -49.8244));
//		latLngs.add(new LatLng(-28.83432, -49.82411));
//		latLngs.add(new LatLng(-28.83435, -49.82388));
//		latLngs.add(new LatLng(-28.83437, -49.82365));
//		latLngs.add(new LatLng(-28.83439, -49.82348));
//		latLngs.add(new LatLng(-28.83441, -49.82329));
//		latLngs.add(new LatLng(-28.83442, -49.82313));
//		latLngs.add(new LatLng(-28.83442, -49.82296));
//		latLngs.add(new LatLng(-28.83442, -49.82279));
//		latLngs.add(new LatLng(-28.83441, -49.82267));
//		latLngs.add(new LatLng(-28.83439, -49.82255));
//		latLngs.add(new LatLng(-28.83438, -49.82242));
//		latLngs.add(new LatLng(-28.83435, -49.82227));
//		latLngs.add(new LatLng(-28.83433, -49.82213));
//		latLngs.add(new LatLng(-28.8343, -49.82198));
//		latLngs.add(new LatLng(-28.83428, -49.82182));
//		latLngs.add(new LatLng(-28.83425, -49.82166));
//		latLngs.add(new LatLng(-28.83422, -49.82153));
//		latLngs.add(new LatLng(-28.83419, -49.82132));
//		latLngs.add(new LatLng(-28.83414, -49.82102));
//		latLngs.add(new LatLng(-28.83412, -49.82085));
//		latLngs.add(new LatLng(-28.83409, -49.82068));
//		latLngs.add(new LatLng(-28.83406, -49.82054));
//		latLngs.add(new LatLng(-28.83404, -49.8204));
//		latLngs.add(new LatLng(-28.83403, -49.82028));
//		latLngs.add(new LatLng(-28.83402, -49.82018));
//		latLngs.add(new LatLng(-28.83402, -49.82005));
//		latLngs.add(new LatLng(-28.83402, -49.81988));
//		latLngs.add(new LatLng(-28.83402, -49.81987));
//		latLngs.add(new LatLng(-28.83402, -49.81974));
//		latLngs.add(new LatLng(-28.83402, -49.81963));
//		latLngs.add(new LatLng(-28.83402, -49.8195));
//		latLngs.add(new LatLng(-28.83403, -49.81928));
//		latLngs.add(new LatLng(-28.83403, -49.81892));
//		latLngs.add(new LatLng(-28.83404, -49.81862));
//		latLngs.add(new LatLng(-28.83405, -49.81817));
//		latLngs.add(new LatLng(-28.83406, -49.81774));
//		latLngs.add(new LatLng(-28.83407, -49.81704));
//		latLngs.add(new LatLng(-28.83408, -49.8168));
//		latLngs.add(new LatLng(-28.83408, -49.81657));
//		latLngs.add(new LatLng(-28.83408, -49.81654));
//		latLngs.add(new LatLng(-28.83408, -49.81638));
//		latLngs.add(new LatLng(-28.83409, -49.81619));
//		latLngs.add(new LatLng(-28.83409, -49.81595));
//		latLngs.add(new LatLng(-28.8341, -49.81576));
//		latLngs.add(new LatLng(-28.83411, -49.81555));
//		latLngs.add(new LatLng(-28.83411, -49.81531));
//		latLngs.add(new LatLng(-28.83411, -49.81507));
//		latLngs.add(new LatLng(-28.83412, -49.81482));
//		latLngs.add(new LatLng(-28.83412, -49.81461));
//		latLngs.add(new LatLng(-28.83412, -49.81438));
//		latLngs.add(new LatLng(-28.83413, -49.81419));
//		latLngs.add(new LatLng(-28.83413, -49.81395));
//		latLngs.add(new LatLng(-28.83414, -49.8137));
//		latLngs.add(new LatLng(-28.83415, -49.81349));
//		latLngs.add(new LatLng(-28.83415, -49.81328));
//		latLngs.add(new LatLng(-28.83416, -49.8131));
//		latLngs.add(new LatLng(-28.83416, -49.81292));
//		latLngs.add(new LatLng(-28.83416, -49.81278));
//		latLngs.add(new LatLng(-28.83416, -49.81261));
//		latLngs.add(new LatLng(-28.83417, -49.81242));
//		latLngs.add(new LatLng(-28.83417, -49.81229));
//		latLngs.add(new LatLng(-28.83417, -49.81221));
//		latLngs.add(new LatLng(-28.83417, -49.81214));
//		latLngs.add(new LatLng(-28.83418, -49.81206));
//		latLngs.add(new LatLng(-28.83419, -49.81199));
//		latLngs.add(new LatLng(-28.83419, -49.81196));
//		latLngs.add(new LatLng(-28.8342, -49.81192));
//		latLngs.add(new LatLng(-28.83422, -49.81186));
//		latLngs.add(new LatLng(-28.83424, -49.8118));
//		latLngs.add(new LatLng(-28.83426, -49.81174));
//		latLngs.add(new LatLng(-28.83428, -49.81168));
//		latLngs.add(new LatLng(-28.83431, -49.81163));
//		latLngs.add(new LatLng(-28.83434, -49.81158));
//		latLngs.add(new LatLng(-28.83437, -49.81152));
//		latLngs.add(new LatLng(-28.8344, -49.81147));
//		latLngs.add(new LatLng(-28.83444, -49.8114));
//		latLngs.add(new LatLng(-28.8345, -49.8113));
//		latLngs.add(new LatLng(-28.83457, -49.81117));
//		latLngs.add(new LatLng(-28.83463, -49.81106));
//		latLngs.add(new LatLng(-28.83464, -49.81105));
//		latLngs.add(new LatLng(-28.83468, -49.81097));
//		latLngs.add(new LatLng(-28.83479, -49.81078));
//		latLngs.add(new LatLng(-28.8349, -49.81057));
//		latLngs.add(new LatLng(-28.835, -49.81039));
//		latLngs.add(new LatLng(-28.83517, -49.81009));
//		latLngs.add(new LatLng(-28.83531, -49.80985));
//		latLngs.add(new LatLng(-28.83546, -49.80958));
//		latLngs.add(new LatLng(-28.83558, -49.80937));
//		latLngs.add(new LatLng(-28.83576, -49.80906));
//		latLngs.add(new LatLng(-28.83588, -49.80884));
//		latLngs.add(new LatLng(-28.83602, -49.80859));
//		latLngs.add(new LatLng(-28.83616, -49.80834));
//		latLngs.add(new LatLng(-28.83634, -49.80802));
//		latLngs.add(new LatLng(-28.83636, -49.80799));
//		latLngs.add(new LatLng(-28.83656, -49.80763));
//		latLngs.add(new LatLng(-28.83676, -49.80729));
//		latLngs.add(new LatLng(-28.83693, -49.80698));
//		latLngs.add(new LatLng(-28.83708, -49.80671));
//		latLngs.add(new LatLng(-28.83725, -49.80642));
//		latLngs.add(new LatLng(-28.83741, -49.80615));
//		latLngs.add(new LatLng(-28.83752, -49.80596));
//		latLngs.add(new LatLng(-28.83758, -49.80584));
//		latLngs.add(new LatLng(-28.83772, -49.8056));
//		latLngs.add(new LatLng(-28.83787, -49.80535));
//		latLngs.add(new LatLng(-28.83797, -49.80517));
//		latLngs.add(new LatLng(-28.83809, -49.80496));
//		latLngs.add(new LatLng(-28.83816, -49.80482));
//		latLngs.add(new LatLng(-28.83827, -49.80462));
//		latLngs.add(new LatLng(-28.83836, -49.80447));
//		latLngs.add(new LatLng(-28.83845, -49.8043));
//		latLngs.add(new LatLng(-28.8385, -49.80421));
//		latLngs.add(new LatLng(-28.83861, -49.80402));
//		latLngs.add(new LatLng(-28.8387, -49.80386));
//		latLngs.add(new LatLng(-28.83882, -49.80366));
//		latLngs.add(new LatLng(-28.83888, -49.80354));
//		latLngs.add(new LatLng(-28.83898, -49.80337));
//		latLngs.add(new LatLng(-28.83904, -49.80326));
//		latLngs.add(new LatLng(-28.83912, -49.80312));
//		latLngs.add(new LatLng(-28.8392, -49.80298));
//		latLngs.add(new LatLng(-28.83929, -49.80284));
//		latLngs.add(new LatLng(-28.83935, -49.80275));
//		latLngs.add(new LatLng(-28.83943, -49.80262));
//		latLngs.add(new LatLng(-28.8395, -49.80251));
//		latLngs.add(new LatLng(-28.83956, -49.80242));
//		latLngs.add(new LatLng(-28.83961, -49.80234));
//		latLngs.add(new LatLng(-28.83967, -49.80226));
//		latLngs.add(new LatLng(-28.83973, -49.80218));
//		latLngs.add(new LatLng(-28.83979, -49.8021));
//		latLngs.add(new LatLng(-28.83986, -49.80199));
//		latLngs.add(new LatLng(-28.83997, -49.80183));
//		latLngs.add(new LatLng(-28.84005, -49.80169));
//		latLngs.add(new LatLng(-28.8401, -49.80156));
//		latLngs.add(new LatLng(-28.84013, -49.80148));
//		latLngs.add(new LatLng(-28.84016, -49.80137));
//		latLngs.add(new LatLng(-28.84017, -49.80129));
//		latLngs.add(new LatLng(-28.84017, -49.80121));
//		latLngs.add(new LatLng(-28.84017, -49.80114));
//		latLngs.add(new LatLng(-28.84016, -49.80106));
//		latLngs.add(new LatLng(-28.84016, -49.80099));
//		latLngs.add(new LatLng(-28.84015, -49.80093));
//		latLngs.add(new LatLng(-28.84014, -49.80088));
//		latLngs.add(new LatLng(-28.84012, -49.80081));
//		latLngs.add(new LatLng(-28.84009, -49.80066));
//		latLngs.add(new LatLng(-28.84008, -49.80062));
//		latLngs.add(new LatLng(-28.84007, -49.8006));
//		latLngs.add(new LatLng(-28.84005, -49.80053));
//		latLngs.add(new LatLng(-28.84003, -49.80046));
//		latLngs.add(new LatLng(-28.84002, -49.80041));
//		latLngs.add(new LatLng(-28.83999, -49.80033));
//		latLngs.add(new LatLng(-28.83997, -49.80026));
//		latLngs.add(new LatLng(-28.83995, -49.80018));
//		latLngs.add(new LatLng(-28.83993, -49.80009));
//		latLngs.add(new LatLng(-28.8399, -49.79999));
//		latLngs.add(new LatLng(-28.83988, -49.79989));
//		latLngs.add(new LatLng(-28.83985, -49.79979));
//		latLngs.add(new LatLng(-28.83983, -49.7997));
//		latLngs.add(new LatLng(-28.83981, -49.79963));
//		latLngs.add(new LatLng(-28.8398, -49.7996));
//		latLngs.add(new LatLng(-28.8398, -49.79957));
//		latLngs.add(new LatLng(-28.83979, -49.79951));
//		latLngs.add(new LatLng(-28.83978, -49.79946));
//		latLngs.add(new LatLng(-28.83978, -49.79941));
//		latLngs.add(new LatLng(-28.83977, -49.79934));
//		latLngs.add(new LatLng(-28.83977, -49.79927));
//		latLngs.add(new LatLng(-28.83978, -49.79922));
//		latLngs.add(new LatLng(-28.83978, -49.79917));
//		latLngs.add(new LatLng(-28.83979, -49.7991));
//		latLngs.add(new LatLng(-28.8398, -49.79903));
//		latLngs.add(new LatLng(-28.83981, -49.79895));
//		latLngs.add(new LatLng(-28.83982, -49.79891));
//		latLngs.add(new LatLng(-28.83984, -49.79884));
//		latLngs.add(new LatLng(-28.83986, -49.79879));
//		latLngs.add(new LatLng(-28.83989, -49.79873));
//		latLngs.add(new LatLng(-28.83992, -49.79866));
//		latLngs.add(new LatLng(-28.83995, -49.79861));
//		latLngs.add(new LatLng(-28.83998, -49.79856));
//		latLngs.add(new LatLng(-28.84002, -49.7985));
//		latLngs.add(new LatLng(-28.84004, -49.79847));
//		latLngs.add(new LatLng(-28.84006, -49.79845));
//		latLngs.add(new LatLng(-28.8401, -49.79841));
//		latLngs.add(new LatLng(-28.84015, -49.79836));
//		latLngs.add(new LatLng(-28.8402, -49.79831));
//		latLngs.add(new LatLng(-28.84025, -49.79827));
//		latLngs.add(new LatLng(-28.8403, -49.79824));
//		latLngs.add(new LatLng(-28.84036, -49.7982));
//		latLngs.add(new LatLng(-28.84043, -49.79816));
//		latLngs.add(new LatLng(-28.8405, -49.79813));
//		latLngs.add(new LatLng(-28.84056, -49.7981));
//		latLngs.add(new LatLng(-28.84063, -49.79806));
//		latLngs.add(new LatLng(-28.84072, -49.79802));
//		latLngs.add(new LatLng(-28.84079, -49.79799));
//		latLngs.add(new LatLng(-28.84086, -49.79795));
//		latLngs.add(new LatLng(-28.84095, -49.79791));
//		latLngs.add(new LatLng(-28.84102, -49.79787));
//		latLngs.add(new LatLng(-28.84112, -49.79783));
//		latLngs.add(new LatLng(-28.84125, -49.79775));
//		latLngs.add(new LatLng(-28.84136, -49.79769));
//		latLngs.add(new LatLng(-28.84147, -49.79762));
//		latLngs.add(new LatLng(-28.8416, -49.79754));
//		latLngs.add(new LatLng(-28.84174, -49.79745));
//		latLngs.add(new LatLng(-28.84185, -49.79737));
//		latLngs.add(new LatLng(-28.84193, -49.79731));
//		latLngs.add(new LatLng(-28.84202, -49.79725));
//		latLngs.add(new LatLng(-28.84211, -49.79717));
//		latLngs.add(new LatLng(-28.84225, -49.79705));
//		latLngs.add(new LatLng(-28.84241, -49.79691));
//		latLngs.add(new LatLng(-28.84256, -49.79676));
//		latLngs.add(new LatLng(-28.84274, -49.79661));
//		latLngs.add(new LatLng(-28.84288, -49.79647));
//		latLngs.add(new LatLng(-28.84297, -49.79638));
//		latLngs.add(new LatLng(-28.84308, -49.79628));
//		latLngs.add(new LatLng(-28.84318, -49.79619));
//		latLngs.add(new LatLng(-28.84333, -49.79605));
//		latLngs.add(new LatLng(-28.84345, -49.79594));
//		latLngs.add(new LatLng(-28.8436, -49.7958));
//		latLngs.add(new LatLng(-28.84377, -49.79564));
//		latLngs.add(new LatLng(-28.84379, -49.79562));
//		latLngs.add(new LatLng(-28.84394, -49.79548));
//		latLngs.add(new LatLng(-28.84409, -49.79534));
//		latLngs.add(new LatLng(-28.84426, -49.79518));
//		latLngs.add(new LatLng(-28.84443, -49.79503));
//		latLngs.add(new LatLng(-28.84457, -49.7949));
//		latLngs.add(new LatLng(-28.84467, -49.7948));
//		latLngs.add(new LatLng(-28.84479, -49.79469));
//		latLngs.add(new LatLng(-28.8449, -49.79459));
//		latLngs.add(new LatLng(-28.845, -49.79449));
//		latLngs.add(new LatLng(-28.84511, -49.7944));
//		latLngs.add(new LatLng(-28.84525, -49.79427));
//		latLngs.add(new LatLng(-28.84539, -49.79414));
//		latLngs.add(new LatLng(-28.84549, -49.79404));
//		latLngs.add(new LatLng(-28.8456, -49.79395));
//		latLngs.add(new LatLng(-28.84576, -49.7938));
//		latLngs.add(new LatLng(-28.84592, -49.79364));
//		latLngs.add(new LatLng(-28.84617, -49.79342));
//		latLngs.add(new LatLng(-28.84635, -49.79325));
//		latLngs.add(new LatLng(-28.84658, -49.79304));
//		latLngs.add(new LatLng(-28.84677, -49.79286));
//		latLngs.add(new LatLng(-28.84695, -49.79269));
//		latLngs.add(new LatLng(-28.84705, -49.7926));
//		latLngs.add(new LatLng(-28.84713, -49.79252));
//		latLngs.add(new LatLng(-28.8473, -49.79237));
//		latLngs.add(new LatLng(-28.84743, -49.79224));
//		latLngs.add(new LatLng(-28.84759, -49.7921));
//		latLngs.add(new LatLng(-28.84772, -49.79198));
//		latLngs.add(new LatLng(-28.84784, -49.79187));
//		latLngs.add(new LatLng(-28.84795, -49.79177));
//		latLngs.add(new LatLng(-28.84798, -49.79174));
//		latLngs.add(new LatLng(-28.84807, -49.79165));
//		latLngs.add(new LatLng(-28.84821, -49.79152));
//		latLngs.add(new LatLng(-28.84835, -49.79139));
//		latLngs.add(new LatLng(-28.84849, -49.79127));
//		latLngs.add(new LatLng(-28.84864, -49.79114));
//		latLngs.add(new LatLng(-28.8488, -49.79101));
//		latLngs.add(new LatLng(-28.84894, -49.7909));
//		latLngs.add(new LatLng(-28.84909, -49.79078));
//		latLngs.add(new LatLng(-28.84931, -49.79061));
//		latLngs.add(new LatLng(-28.84992, -49.79015));
//		latLngs.add(new LatLng(-28.85004, -49.79006));
//		latLngs.add(new LatLng(-28.85052, -49.78971));
//		latLngs.add(new LatLng(-28.85101, -49.78933));
//		latLngs.add(new LatLng(-28.8513, -49.78912));
//		latLngs.add(new LatLng(-28.85161, -49.7889));
//		latLngs.add(new LatLng(-28.85193, -49.78866));
//		latLngs.add(new LatLng(-28.85216, -49.78848));
//		latLngs.add(new LatLng(-28.85225, -49.78842));
//		latLngs.add(new LatLng(-28.85249, -49.78823));
//		latLngs.add(new LatLng(-28.85271, -49.78807));
//		latLngs.add(new LatLng(-28.85286, -49.78795));
//		latLngs.add(new LatLng(-28.85307, -49.7878));
//		latLngs.add(new LatLng(-28.85324, -49.78767));
//		latLngs.add(new LatLng(-28.85347, -49.7875));
//		latLngs.add(new LatLng(-28.85372, -49.78731));
//		latLngs.add(new LatLng(-28.85396, -49.78713));
//		latLngs.add(new LatLng(-28.85422, -49.78694));
//		latLngs.add(new LatLng(-28.85442, -49.78679));
//		latLngs.add(new LatLng(-28.85456, -49.78668));
//		latLngs.add(new LatLng(-28.85466, -49.78662));
//		latLngs.add(new LatLng(-28.85475, -49.78655));
//		latLngs.add(new LatLng(-28.85487, -49.78646));
//		latLngs.add(new LatLng(-28.85498, -49.78638));
//		latLngs.add(new LatLng(-28.85506, -49.7863));
//		latLngs.add(new LatLng(-28.85514, -49.78624));
//		latLngs.add(new LatLng(-28.85536, -49.78607));
//		latLngs.add(new LatLng(-28.85554, -49.78593));
//		latLngs.add(new LatLng(-28.85602, -49.78557));
//		latLngs.add(new LatLng(-28.85622, -49.78542));
//		latLngs.add(new LatLng(-28.85642, -49.78528));
//		latLngs.add(new LatLng(-28.85662, -49.78513));
//		latLngs.add(new LatLng(-28.85681, -49.785));
//		latLngs.add(new LatLng(-28.85688, -49.78494));
//		latLngs.add(new LatLng(-28.85697, -49.78488));
//		latLngs.add(new LatLng(-28.85708, -49.78479));
//		latLngs.add(new LatLng(-28.85709, -49.78478));
//		latLngs.add(new LatLng(-28.8572, -49.7847));
//		latLngs.add(new LatLng(-28.85733, -49.7846));
//		latLngs.add(new LatLng(-28.85745, -49.78449));
//		latLngs.add(new LatLng(-28.85755, -49.7844));
//		latLngs.add(new LatLng(-28.85765, -49.78429));
//		latLngs.add(new LatLng(-28.85772, -49.7842));
//		latLngs.add(new LatLng(-28.85781, -49.78409));
//		latLngs.add(new LatLng(-28.85789, -49.78397));
//		latLngs.add(new LatLng(-28.85801, -49.78381));
//		latLngs.add(new LatLng(-28.85813, -49.78362));
//		latLngs.add(new LatLng(-28.85815, -49.78358));
//		latLngs.add(new LatLng(-28.85825, -49.78341));
//		latLngs.add(new LatLng(-28.85845, -49.78309));
//		latLngs.add(new LatLng(-28.85858, -49.78287));
//		latLngs.add(new LatLng(-28.85872, -49.78265));
//		latLngs.add(new LatLng(-28.85892, -49.78234));
//		latLngs.add(new LatLng(-28.85921, -49.78189));
//		latLngs.add(new LatLng(-28.85943, -49.78155));
//		latLngs.add(new LatLng(-28.85961, -49.78127));
//		latLngs.add(new LatLng(-28.85977, -49.78104));
//		latLngs.add(new LatLng(-28.85986, -49.78091));
//		latLngs.add(new LatLng(-28.85994, -49.78077));
//		latLngs.add(new LatLng(-28.85999, -49.78068));
//		latLngs.add(new LatLng(-28.86004, -49.78057));
//		latLngs.add(new LatLng(-28.86011, -49.78042));
//		latLngs.add(new LatLng(-28.86018, -49.78023));
//		latLngs.add(new LatLng(-28.86022, -49.78008));
//		latLngs.add(new LatLng(-28.86026, -49.77993));
//		latLngs.add(new LatLng(-28.86029, -49.77979));
//		latLngs.add(new LatLng(-28.86033, -49.77962));
//		latLngs.add(new LatLng(-28.86042, -49.77921));
//		latLngs.add(new LatLng(-28.8605, -49.77884));
//		latLngs.add(new LatLng(-28.86052, -49.77877));
//		latLngs.add(new LatLng(-28.86057, -49.7785));
//		latLngs.add(new LatLng(-28.86064, -49.77814));
//		latLngs.add(new LatLng(-28.86068, -49.77792));
//		latLngs.add(new LatLng(-28.8607, -49.77783));
//		latLngs.add(new LatLng(-28.86075, -49.7776));
//		latLngs.add(new LatLng(-28.86083, -49.77727));
//		latLngs.add(new LatLng(-28.86093, -49.77682));
//		latLngs.add(new LatLng(-28.861, -49.77652));
//		latLngs.add(new LatLng(-28.86106, -49.77622));
//		latLngs.add(new LatLng(-28.86112, -49.77594));
//		latLngs.add(new LatLng(-28.86116, -49.77576));
//		latLngs.add(new LatLng(-28.86118, -49.77566));
//		latLngs.add(new LatLng(-28.86123, -49.77541));
//		latLngs.add(new LatLng(-28.86128, -49.77517));
//		latLngs.add(new LatLng(-28.86132, -49.77496));
//		latLngs.add(new LatLng(-28.86136, -49.77477));
//		latLngs.add(new LatLng(-28.8614, -49.77457));
//		latLngs.add(new LatLng(-28.86144, -49.7744));
//		latLngs.add(new LatLng(-28.86148, -49.77422));
//		latLngs.add(new LatLng(-28.8615, -49.77412));
//		latLngs.add(new LatLng(-28.86151, -49.77404));
//		latLngs.add(new LatLng(-28.86153, -49.77395));
//		latLngs.add(new LatLng(-28.86155, -49.77387));
//		latLngs.add(new LatLng(-28.86155, -49.77386));
//		latLngs.add(new LatLng(-28.86157, -49.77374));
//		latLngs.add(new LatLng(-28.86159, -49.77363));
//		latLngs.add(new LatLng(-28.8616, -49.77352));
//		latLngs.add(new LatLng(-28.8616, -49.77339));
//		latLngs.add(new LatLng(-28.8616, -49.77328));
//		latLngs.add(new LatLng(-28.8616, -49.77317));
//		latLngs.add(new LatLng(-28.8616, -49.77304));
//		latLngs.add(new LatLng(-28.86158, -49.77295));
//		latLngs.add(new LatLng(-28.86158, -49.77287));
//		latLngs.add(new LatLng(-28.86149, -49.77237));
//		latLngs.add(new LatLng(-28.86138, -49.77172));
//		latLngs.add(new LatLng(-28.86126, -49.77108));
//		latLngs.add(new LatLng(-28.86119, -49.77064));
//		latLngs.add(new LatLng(-28.86113, -49.77029));
//		latLngs.add(new LatLng(-28.86111, -49.77005));
//		latLngs.add(new LatLng(-28.8611, -49.76994));
//		latLngs.add(new LatLng(-28.8611, -49.76987));
//		latLngs.add(new LatLng(-28.8611, -49.7698));
//		latLngs.add(new LatLng(-28.8611, -49.76973));
//		latLngs.add(new LatLng(-28.8611, -49.76969));
//		latLngs.add(new LatLng(-28.86111, -49.76962));
//		latLngs.add(new LatLng(-28.86111, -49.76957));
//		latLngs.add(new LatLng(-28.86111, -49.76955));
//		latLngs.add(new LatLng(-28.86113, -49.76942));
//		latLngs.add(new LatLng(-28.86114, -49.76933));
//		latLngs.add(new LatLng(-28.86117, -49.76916));
//		latLngs.add(new LatLng(-28.86133, -49.76838));
//		latLngs.add(new LatLng(-28.86134, -49.76834));
//		latLngs.add(new LatLng(-28.86147, -49.7677));
//		latLngs.add(new LatLng(-28.86155, -49.76734));
//		latLngs.add(new LatLng(-28.86165, -49.76699));
//		latLngs.add(new LatLng(-28.86176, -49.76659));
//		latLngs.add(new LatLng(-28.86182, -49.76634));
//		latLngs.add(new LatLng(-28.86192, -49.76597));
//		latLngs.add(new LatLng(-28.862, -49.76566));
//		latLngs.add(new LatLng(-28.86206, -49.7654));
//		latLngs.add(new LatLng(-28.8621, -49.76525));
//		latLngs.add(new LatLng(-28.86214, -49.76511));
//		latLngs.add(new LatLng(-28.8622, -49.76497));
//		latLngs.add(new LatLng(-28.86229, -49.7648));
//		latLngs.add(new LatLng(-28.86235, -49.7647));
//		latLngs.add(new LatLng(-28.8624, -49.76462));
//		latLngs.add(new LatLng(-28.86246, -49.76455));
//		latLngs.add(new LatLng(-28.86257, -49.76444));
//		latLngs.add(new LatLng(-28.86271, -49.76433));
//		latLngs.add(new LatLng(-28.86285, -49.76425));
//		latLngs.add(new LatLng(-28.86292, -49.76422));
//		latLngs.add(new LatLng(-28.86299, -49.76418));
//		latLngs.add(new LatLng(-28.86308, -49.76416));
//		latLngs.add(new LatLng(-28.86335, -49.76409));
//		latLngs.add(new LatLng(-28.86349, -49.76405));
//		latLngs.add(new LatLng(-28.86365, -49.764));
//		latLngs.add(new LatLng(-28.86383, -49.76396));
//		latLngs.add(new LatLng(-28.86409, -49.76391));
//		latLngs.add(new LatLng(-28.86428, -49.76389));
//		latLngs.add(new LatLng(-28.86451, -49.76387));
//		latLngs.add(new LatLng(-28.86474, -49.76387));
//		latLngs.add(new LatLng(-28.86488, -49.76388));
//		latLngs.add(new LatLng(-28.86503, -49.7639));
//		latLngs.add(new LatLng(-28.86507, -49.7639));
//		latLngs.add(new LatLng(-28.86539, -49.76393));
//		latLngs.add(new LatLng(-28.86545, -49.76394));
//		latLngs.add(new LatLng(-28.86563, -49.76395));
//		latLngs.add(new LatLng(-28.86589, -49.76398));
//		latLngs.add(new LatLng(-28.86623, -49.76402));
//		latLngs.add(new LatLng(-28.86647, -49.76405));
//		latLngs.add(new LatLng(-28.86683, -49.76409));
//		latLngs.add(new LatLng(-28.86712, -49.76411));
//		latLngs.add(new LatLng(-28.86747, -49.76415));
//		latLngs.add(new LatLng(-28.86775, -49.76419));
//		latLngs.add(new LatLng(-28.86805, -49.76422));
//		latLngs.add(new LatLng(-28.86822, -49.76423));
//		latLngs.add(new LatLng(-28.86834, -49.76425));
//		latLngs.add(new LatLng(-28.86848, -49.76426));
//		latLngs.add(new LatLng(-28.86874, -49.76429));
//		latLngs.add(new LatLng(-28.86885, -49.76429));
//		latLngs.add(new LatLng(-28.86898, -49.7643));
//		latLngs.add(new LatLng(-28.86913, -49.76429));
//		latLngs.add(new LatLng(-28.86926, -49.76427));
//		latLngs.add(new LatLng(-28.86935, -49.76426));
//		latLngs.add(new LatLng(-28.86946, -49.76425));
//		latLngs.add(new LatLng(-28.86956, -49.76422));
//		latLngs.add(new LatLng(-28.86966, -49.76419));
//		latLngs.add(new LatLng(-28.86984, -49.76413));
//		latLngs.add(new LatLng(-28.86997, -49.76407));
//		latLngs.add(new LatLng(-28.87011, -49.76399));
//		latLngs.add(new LatLng(-28.87021, -49.76395));
//		latLngs.add(new LatLng(-28.87022, -49.76394));
//		latLngs.add(new LatLng(-28.87039, -49.76383));
//		latLngs.add(new LatLng(-28.87059, -49.76368));
//		latLngs.add(new LatLng(-28.87095, -49.7634));
//		latLngs.add(new LatLng(-28.87116, -49.76323));
//		latLngs.add(new LatLng(-28.87148, -49.763));
//		latLngs.add(new LatLng(-28.87172, -49.76281));
//		latLngs.add(new LatLng(-28.87214, -49.76249));
//		latLngs.add(new LatLng(-28.87236, -49.76232));
//		return latLngs;
//	}
//
//}
