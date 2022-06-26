package com.atorresveiga.playingwithtransitions.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.atorresveiga.playingwithtransitions.R
import com.atorresveiga.playingwithtransitions.ui.theme.PlayingWithTransitionsThemeWithSurface

class MainComposableActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlayingWithTransitionsThemeWithSurface { NavGraph() }
        }
    }
}

class MainFragmentActivity: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}