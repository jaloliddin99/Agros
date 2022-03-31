package com.abdullaev.smartagro.fragment

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.abdullaev.smartagro.R
import com.google.android.gms.maps.*

import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsFragment : Fragment() {

    private val callback = OnMapReadyCallback { googleMap ->
        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */

        val sydney = LatLng(41.33268450800833, 69.26496095347474)
        val sydney2 = LatLng(41.35467448831901, 69.37681966477535)
        val sydney3 = LatLng(41.30097523868657, 69.38547602274896)
        val sydney4 = LatLng(41.24751471281354, 69.11976346929815)
        val sydney5 = LatLng(41.27043172787457, 69.2496088389023)
        val sydney6 = LatLng(41.17644919937921, 69.18374524562483)
        val sydney7 = LatLng(41.39986057785325, 69.27482518604282)
        googleMap.addMarker(MarkerOptions().position(sydney).icon(requireContext().bitmapDescriptorFromVector(R.drawable.ic_dest)))
        googleMap.addMarker(MarkerOptions().position(sydney2).icon(requireContext().bitmapDescriptorFromVector(R.drawable.ic_locationn)))
        googleMap.addMarker(MarkerOptions().position(sydney3).icon(requireContext().bitmapDescriptorFromVector(R.drawable.ic_locationn)))
        googleMap.addMarker(MarkerOptions().position(sydney4).icon(requireContext().bitmapDescriptorFromVector(R.drawable.ic_locationn)))
        googleMap.addMarker(MarkerOptions().position(sydney5).icon(requireContext().bitmapDescriptorFromVector(R.drawable.ic_locationn)))
        googleMap.addMarker(MarkerOptions().position(sydney6).icon(requireContext().bitmapDescriptorFromVector(R.drawable.ic_locationn)))
        googleMap.addMarker(MarkerOptions().position(sydney7).icon(requireContext().bitmapDescriptorFromVector(R.drawable.ic_locationn)))

        val update: CameraUpdate = CameraUpdateFactory.newLatLngZoom(sydney, 10f)
        googleMap.animateCamera(update)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_maps, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }


    fun Context.bitmapDescriptorFromVector(vectorResId: Int): BitmapDescriptor {
        val vectorDrawable = ContextCompat.getDrawable(this, vectorResId)
        vectorDrawable!!.setBounds(
            0,
            0,
            vectorDrawable.intrinsicWidth,
            vectorDrawable.intrinsicHeight
        )
        val bitmap = Bitmap.createBitmap(
            vectorDrawable.intrinsicWidth,
            vectorDrawable.intrinsicHeight,
            Bitmap.Config.ARGB_8888
        )
        vectorDrawable.draw(Canvas(bitmap))
        return BitmapDescriptorFactory.fromBitmap(bitmap)
    }

}