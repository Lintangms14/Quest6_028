package com.example.praktikum8.ui.view.screen

import android.widget.Button
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
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
) {
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
            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = mahasiswa.nama,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = Color.White
                )
                Text(
                    text = mahasiswa.nim,
                    fontWeight = FontWeight.Light,
                    fontSize = 12.sp,
                    color = Color.White
                )
            }
            Icon(
                imageVector = Icons.Filled.Notifications,
                contentDescription = "Notification Icon",
                tint = Color.White
            )
        }
        Box(
            modifier = Modifier
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp)
                )
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Text(
                    text = "Detail Data Mahasiswa",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                ListDataMhs.forEach { data ->
                    DetailRow(judul = data.first, isinya = data.second)
                }
                HorizontalDivider()
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Detail Rencana Studi",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                ListDataKRS.forEach { data ->
                    DetailRow(judul = data.first, isinya = data.second)
                }
                HorizontalDivider()
                Spacer(modifier = Modifier.height(22.dp))
                Button(onClick = {onBackButton()},
                    modifier = Modifier.fillMaxWidth().padding(top = 16.dp), shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(text = "Kembali")
                }
            }
        }
    }
}

@Composable
fun DetailRow(judul: String, isinya: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = judul,
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = ":",
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            modifier = Modifier.padding(horizontal = 8.dp)
        )
        Text(
            text = isinya,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            modifier = Modifier.weight(2f)
        )
    }
}