package com.example.prak7.viewmodel;

public class SiswaViewModel {
    class SiswaViewModel : ViewModel() {
        private val _statusUI = MutableStateFlow(Siswa())
        val statusUI: StateFlow<Siswa> = _statusUI.asStateFlow()

        fun setSiswa(ls: MutableList<String>){
            _statusUI.update { statusSaatIni ->
                    statusSaatIni.copy(nama=ls[0], gender=ls[1], alamat=ls[2])
            }
        }
    }
}
