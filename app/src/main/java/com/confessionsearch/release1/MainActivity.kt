package com.confessionsearch.release1

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.confessionsearch.release1.data.notes.Notes
import com.confessionsearch.release1.databinding.ActivityMainBinding
import com.confessionsearch.release1.ui.notesActivity.NotesComposeActivity
import com.confessionsearch.release1.ui.notesActivity.NotesFragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    val context: Context = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            var binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)

            val navView: BottomNavigationView = binding.navView

            val navController = findNavController(R.id.nav_host_fragment_activity_main)
            // Passing each menu ID as a set of Ids because each
            // menu should be considered as top level destinations.
            val appBarConfiguration = AppBarConfiguration(
                setOf(
                    R.id.navigation_home, R.id.navigation_notes
                )
            )
            setupActionBarWithNavController(navController, appBarConfiguration)
            navView.setupWithNavController(navController)
        } catch (ex: Exception) {
            ex.printStackTrace()
            Toast.makeText(this, ex.message, Toast.LENGTH_LONG).show()
        }

    }

    //required to be here for adding notes to the note list fragment
    fun NewNote(view: View?) {
        val intent = Intent(context, NotesComposeActivity::class.java)
        intent.putExtra("activity_ID", NotesFragment.ACTIVITY_ID)
        startActivity(intent)

    }

    //Pass any static variables along here
    companion object {
        var notesArrayList = ArrayList<Notes>()


    }


}

