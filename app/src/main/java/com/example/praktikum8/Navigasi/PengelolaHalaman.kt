package com.example.praktikum8.Navigasi

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.praktikum8.ui.view.screen.DetailView
import com.example.praktikum8.ui.view.screen.MahasiswaFormView
import com.example.praktikum8.ui.view.screen.RencanaStudyView
import com.example.praktikum8.ui.view.screen.SplashView
import com.example.praktikum8.ui.view.viewmodel.MahasiswaViewModel
import com.example.praktikum8.ui.view.viewmodel.RencanaStudiViewModel

enum class Halaman{
    Splash,
    Mahasiswa,
    MataKuliah,
    Tampil
}

@Composable
fun MahasiswaApp(
    modifier: Modifier = Modifier,
    mahasiswaViewModel: MahasiswaViewModel = viewModel(),
    krsViewModel: RencanaStudiViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
){
    val mahasiswaUiState = mahasiswaViewModel.mahasiswaStateUi.collectAsState().value
    val krsUiState = krsViewModel.krsStateUi.collectAsState().value
    NavHost(
        navController = navController,
        startDestination = Halaman.Splash.name,
        modifier = Modifier.padding()
    ){
        composable(route = Halaman.Splash.name) {
            SplashView(onMulaiButton = {
               navController.navigate(
                   Halaman.Mahasiswa.name
               )
            })
            composable(route = Halaman.Mahasiswa.name){
                MahasiswaFormView(
                    onSubmitButtonClicked = {
                        mahasiswaViewModel.saveDataMahasiswa(it)
                        navController.navigate(Halaman.MataKuliah.name)
                    },
                    onBackButtonClicked = {
                        navController.popBackStack()
                    }
                )
            }
            composable(route = Halaman.MataKuliah.name) {
                RencanaStudyView(
                    mahasiswa = mahasiswaUiState,
                    onSubmitButtonClicked = {
                        krsViewModel.saveDataKRS(it)
                        navController.navigate(Halaman.Tampil.name)
                    },
                    onBackButtonClicked = {
                        navController.popBackStack()
                    }
                )
            }
            composable(route = Halaman.Tampil.name) {
                DetailView(
                    dataMhs = mahasiswaUiState,
                    dataKRS = krsUiState,
                    mahasiswa = mahasiswaUiState,
                    modifier = Modifier,
                    onBackButton = {navController.popBackStack()}
                )
            }
        }
    }
}