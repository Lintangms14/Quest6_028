package com.example.praktikum8.ui.view.viewmodel

import androidx.lifecycle.ViewModel
import com.example.praktikum8.model.Mahasiswa
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MahasiswaViewModel : ViewModel() {
    private val _mahasiswaState = MutableStateFlow(Mahasiswa())
    val mahasiswaStateUi : StateFlow<Mahasiswa> = _mahasiswaState.asStateFlow()

    fun saveDataMahasiswa(ls: MutableList<String>){
        _mahasiswaState.update { status ->
            status.copy(
                nim = ls[0],
                nama = ls[1],
                email = ls[2]
            )
        }
    }
}