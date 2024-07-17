package com.tmpsolutions.ui.MainScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.tmpsolutions.ApplicationScreen
import com.tmpsolutions.R
import com.tmpsolutions.domain.model.AquariumDomain
import com.tmpsolutions.ui.designUtils.AddButton
import com.tmpsolutions.ui.designUtils.BackgroundDesign
import com.tmpsolutions.ui.designUtils.Loader
import com.tmpsolutions.ui.navigation.Screen
import java.util.Date

@Composable
fun MainScreen(
    navController: NavHostController? = null,
    mainViewModel: MainViewModel? = null,
    aquariums: List<AquariumDomain> = emptyList()
) {
    var showAddAquariumDialog by remember { mutableStateOf(false) }

    val state : State<AquariumListState>? = mainViewModel?.state?.collectAsState(initial = AquariumListState.Loading)

    BackgroundDesign(
        title = "Welcome, ####",
        header = { UserArea() }
    ) {
        if (state != null) {
            when(state.value) {
                is AquariumListState.Success -> {
                    val aquariumsList = (state.value as AquariumListState.Success).aquariums
                    AquariumCardList(aquariumsList) { aquariumID ->
                        navController?.navigate(route = Screen.AquariumDetailScreen.route + "/$aquariumID")
                    }
                    AddButton(
                        onClick = {
                            showAddAquariumDialog = true
                        }
                    )
                }
                AquariumListState.Empty -> TODO()
                is AquariumListState.Error -> TODO() //Log.e(...)
                AquariumListState.Loading -> {
                    Loader()
                }
            }
        }
    }

    if (showAddAquariumDialog){
        AddAquariumDialog(
            onDismiss = { showAddAquariumDialog = false },
            onSave = mainViewModel!!::saveNewAquarium
        )
    }
}

@Composable
fun UserArea() {
    Box(modifier = Modifier.fillMaxSize()) {
        IconButton (
            onClick = {  },
            modifier = Modifier
                .size(ApplicationScreen.Width / 8)
                .padding(6.dp)
                .align(Alignment.BottomStart)
                .background(Color.Transparent),
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_menu),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
            )
        }
    }
}

@Preview
@Composable
fun TestCard(modifier: Modifier = Modifier) {
    val lstAquariums: MutableList<AquariumDomain> = mutableListOf(
        AquariumDomain(
            0,
            "",
            false,
            Date(),
            Date(),
            emptyList(),
            0,
            0,
            0,
            0f
        )
    )
    MainScreen(aquariums = lstAquariums)
}