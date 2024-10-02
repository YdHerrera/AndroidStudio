package com.example.mymodels

import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Window
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import androidx.drawerlayout.widget.DrawerLayout

class HomeActivity : AppCompatActivity() {

    private lateinit var fab: FloatingActionButton
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        bottomNavigationView = findViewById(R.id.bottomNavigationView)
        fab = findViewById(R.id.fab)
        drawerLayout = findViewById(R.id.drawer_layout)
        val navigationView: NavigationView = findViewById(R.id.nav_view)
        val toolbar: Toolbar = findViewById(R.id.toolbar)

        setSupportActionBar(toolbar)
        val toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.open_nav,
            R.string.close_nav
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.frame_layout, HomeFragment()).commit()
            navigationView.setCheckedItem(R.id.nav_home)
        }

        replaceFragment(HomeFragment())

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> replaceFragment(HomeFragment())
                R.id.balance -> replaceFragment(BalanceFragment())
                R.id.inventario -> replaceFragment(InventarioFragment())
                R.id.proveedor -> replaceFragment(ProveedorFragment())
            }
            true
        }

        fab.setOnClickListener {
            showBottomDialog()
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }

    private fun showBottomDialog() {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.bottomsheetlayou)

        val inventarioLayout: LinearLayout = dialog.findViewById(R.id.layoutInventario)
        val balanceLayout: LinearLayout = dialog.findViewById(R.id.layoutBalance)
        val proveedorLayout: LinearLayout = dialog.findViewById(R.id.layoutProveedor)
        val cancelButton: ImageView = dialog.findViewById(R.id.cancelButton)

        inventarioLayout.setOnClickListener {
            dialog.dismiss()
            Toast.makeText(this, "Abriste elinventario", Toast.LENGTH_SHORT).show()
        }

        balanceLayout.setOnClickListener {
            dialog.dismiss()
            Toast.makeText(this, "Crea un balance", Toast.LENGTH_SHORT).show()
        }

        proveedorLayout.setOnClickListener {
            dialog.dismiss()
            Toast.makeText(this, "Nuevo proveedor", Toast.LENGTH_SHORT).show()
        }

        cancelButton.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
        dialog.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.window?.attributes?.windowAnimations = R.style.DialogAnimation
        dialog.window?.setGravity(Gravity.BOTTOM)

    }

    }

