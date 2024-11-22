package com.example.praktikum8.ui.view.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.praktikum8.model.Mahasiswa
import com.example.praktikum8.model.RencanaStudi

@Composable
fun DetailView(
    dataMhs: Mahasiswa,
    dataKRS: RencanaStudi,
    mahasiswa: Mahasiswa,
    modifier: Modifier = Modifier,
    onBackButton: () -> Unit
){
    val ListDataMhs = listOf(
        Pair("NIM", dataMhs.nim),
        Pair("Nama", dataMhs.nama),
        Pair("Email", dataMhs.email)
    )
    val ListDataKRS = listOf(
        Pair("Mata Kuliah", dataKRS.Matkul),
        Pair("Kelas", dataKRS.Kelas)
    )
}