package com.example.alertaperu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.alertaperu.databinding.ActivityMainBinding
import com.example.alertaperu.fragments.AlertaPeruFragment
import com.example.alertaperu.fragments.ComunidadFragment
import com.example.alertaperu.fragments.MapaFragment
import com.example.alertaperu.fragments.NumeroUtilFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(AlertaPeruFragment())

        binding.bnMenu.setOnItemSelectedListener {
            when(it.itemId){

                R.id.it_alertaPeru -> replaceFragment(AlertaPeruFragment())
                R.id.it_comunidad -> replaceFragment(ComunidadFragment())
                R.id.it_mapa -> replaceFragment(MapaFragment())
                R.id.it_numero_util -> replaceFragment(NumeroUtilFragment())
                else ->{

                }
            }

            true
        }

    }

    private fun replaceFragment(fragment : Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fl_wrapper,fragment)
        fragmentTransaction.commit()
    }
}