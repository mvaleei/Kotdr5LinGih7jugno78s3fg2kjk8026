package com.example.navgiugno

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import com.example.navgiugno.ui.theme.NavGiugnoTheme

class MainActivity : ComponentActivity() {

    //creiamo oggetti per passare valori da un componen te all'altro
    companion object {
        var nomeutente:String ="mrossi"
        var password:String ="Password"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavGiugnoTheme {
                NavGiugnoApp()
            }
        }
    }
}

@PreviewScreenSizes
@Composable
fun NavGiugnoApp() {
    var currentDestination by rememberSaveable { mutableStateOf(AppDestinations.HOME) }

    NavigationSuiteScaffold(
        navigationSuiteItems = {
            AppDestinations.entries.forEach {
                item(
                    icon = {
                        Icon(
                            painterResource(it.icon),
                            contentDescription = it.label
                        )
                    },
                    label = { Text(it.label) },
                    selected = it == currentDestination,
                    onClick = { currentDestination = it }
                )
            }
        }
    ) {
        Scaffold(modifier = Modifier) {
            innerPadding ->
            when (currentDestination){
                AppDestinations.HOME -> Home(Modifier.padding(innerPadding))
                AppDestinations.FAVORITES -> Favoriti(Modifier.padding(innerPadding))
                AppDestinations.PROFILE -> Profilo(Modifier.padding(innerPadding))
                AppDestinations.MIO -> Mio(Modifier.padding(innerPadding))
            }


        }
    }
}

enum class AppDestinations(
    val label: String,
    val icon: Int,
    val nome:String
) {
    HOME("Home", R.drawable.ic_home, nome = "Mario"),
    FAVORITES("Favorites", R.drawable.ic_favorite,nome="Giorgio"),
    PROFILE("Profile", R.drawable.ic_account_box,nome="Fabio"),
    MIO("Mio comp",R.drawable.ic_home,nome="Alberto")
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NavGiugnoTheme {
        Greeting("Android")
    }
}