package com.example.alertaperu.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.alertaperu.R
import com.example.alertaperu.UserFirestore
import com.example.alertaperu.fragments.MapaFragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.firebase.firestore.FirebaseFirestore
import com.google.android.gms.maps.model.MarkerOptions


class MapsActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var map: GoogleMap

    private lateinit var firestore: FirebaseFirestore
    val listUsuarios = arrayListOf<UserFirestore>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)

        val mapFragment = supportFragmentManager.findFragmentById(R.id.map_content)
                as SupportMapFragment
        mapFragment.getMapAsync(this)

        val mapaFragment = MapaFragment.newInstance("param1", "param2")
        supportFragmentManager.beginTransaction()
            .add(R.id.map_contenedor, mapaFragment)
            .commit()
    }

    override fun onMapReady(p0: GoogleMap) {
        map = p0

        val location = LatLng(-8.1116778, -79.0287742)
        map.addMarker(MarkerOptions().position(location).title("Marker"))
        map.moveCamera(CameraUpdateFactory.newLatLng(location))
        map.animateCamera(CameraUpdateFactory.zoomTo(15.0f))
    }
}