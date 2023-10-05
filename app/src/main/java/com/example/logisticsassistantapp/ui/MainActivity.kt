package com.example.logisticsassistantapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.logisticsassistantapp.R
import com.example.logisticsassistantapp.ui.navigation.ChatScreen
import com.example.logisticsassistantapp.ui.navigation.ProfileScreen
import com.example.logisticsassistantapp.ui.navigation.ScheduleScreen
import com.example.logisticsassistantapp.ui.navigation.Screens
import com.example.logisticsassistantapp.ui.navigation.StartScreen
import com.example.logisticsassistantapp.ui.navigation.TasksScreen
import com.example.logisticsassistantapp.ui.theme.AppBarType
import com.example.logisticsassistantapp.ui.theme.LogisticsAssistantAppTheme
import com.example.logisticsassistantapp.ui.theme.NavigationBarType
import com.example.logisticsassistantapp.ui.theme.SecondaryBackground
import com.example.logisticsassistantapp.ui.theme.TextDark
import com.example.logisticsassistantapp.ui.theme.TextLight

class MainActivity : ComponentActivity() {

    private lateinit var screenState: MutableState<Screens>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen()

        setContent {
            LogisticsAssistantAppTheme {
                val currentScreen = Screens.Start
                screenState = rememberSaveable(currentScreen) { mutableStateOf(currentScreen) }

                val paddings = PaddingValues(dimensionResource(R.dimen.main_paddings))

                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.background)
                        .padding(paddings),
                    topBar = { TopBar() },
                    content = {
                        Surface(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(it),
                            color = MaterialTheme.colorScheme.background,
                            content = { MainScreen() })
                    },
                    bottomBar = { NavigationBar() }
                )
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun TopBar() {
        val tabText = stringResource(R.string.app_name)
        TopAppBar(
            title = { Text(text = tabText, style = AppBarType) },
            navigationIcon = { Icons.Filled.Build }
        )
    }

    @Composable
    fun MainScreen() {
        when (screenState.value) {
            Screens.Start -> StartScreen()
            Screens.Tasks -> TasksScreen()
            Screens.Schedule -> ScheduleScreen()
            Screens.Chat -> ChatScreen()
            Screens.Profile -> ProfileScreen()
        }
    }

    @Composable
    fun NavigationBar() {
        NavigationBar {
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.background)
            ) {
                NavigationBarItem(
                    Screens.Tasks,
                    ImageVector.vectorResource(R.drawable.ic_navigation_bar_tasks),
                    stringResource(R.string.navigation_bar_tasks)
                )

                NavigationBarItem(
                    Screens.Schedule,
                    ImageVector.vectorResource(R.drawable.ic_navigation_bar_schedule),
                    stringResource(R.string.navigation_bar_schedule)
                )

                NavigationBarItem(
                    Screens.Chat,
                    ImageVector.vectorResource(R.drawable.ic_navigation_bar_chat),
                    stringResource(R.string.navigation_bar_chat)
                )

                NavigationBarItem(
                    Screens.Profile,
                    ImageVector.vectorResource(R.drawable.ic_navigation_bar_profile),
                    stringResource(R.string.navigation_bar_profile)
                )
            }
        }
    }

    @Composable
    fun NavigationBarItem(screen: Screens, icon: ImageVector, text: String) {
        IconButton(
            onClick = { screenState.value = screen },
            modifier = Modifier
                .fillMaxHeight()
                .width(dimensionResource(R.dimen.navigation_bar_item_width))
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                val shape = RoundedCornerShape(dimensionResource(R.dimen.navigation_bar_shape_radius))
                val shapeWidth = dimensionResource(R.dimen.navigation_bar_shape_width)
                val shapeHeight = dimensionResource(R.dimen.navigation_bar_shape_height)

                Box(
                    contentAlignment = Alignment.Center,
                    modifier = if (screenState.value == screen) {
                        Modifier
                            .background(color = SecondaryBackground, shape = shape)
                            .size(width = shapeWidth, height = shapeHeight)
                    } else {
                        Modifier
                            .background(color = Color.White, shape = shape)
                            .size(width = shapeWidth, height = shapeHeight)
                    }
                ) {
                    Icon(
                        imageVector = icon,
                        contentDescription = text,
                        tint = if (screenState.value == screen) TextDark else TextLight
                    )
                }
                Text(
                    text = text,
                    color = if (screenState.value == screen) TextDark else TextLight,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Center,
                    style = NavigationBarType
                )
            }
        }
    }
}