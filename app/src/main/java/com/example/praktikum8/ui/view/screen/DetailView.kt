package com.example.praktikum8.ui.view.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.praktikum8.R
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
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.primary))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.profil),
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(50.dp)
                    .clip(shape = CircleShape)
            )
        }
    }
}