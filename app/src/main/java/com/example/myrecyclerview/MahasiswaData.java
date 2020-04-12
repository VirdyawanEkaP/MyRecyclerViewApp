package com.example.myrecyclerview;

import com.example.myrecyclerview.R;

import java.util.ArrayList;

public class MahasiswaData {
    private static String[] mahasiswaNama = {
            "Virdyawan Eka Prayoga",
            "Andi Purnama",
            "Wiwin Winarti",
            "Mega Restu Mirantika",
            "Yulianti"
    };

    private static String[] mahasiswaNim = {
            "311710003",
            "311710112",
            "311710465",
            "311710080",
            "311710092"
    };

    private static String[] mahasiswaHp = {
            "0857-9493-2912",
            "0896-8857-1302",
            "0858-6009-6469",
            "0838-0695-8903",
            "0881-5386-873"
    };

    private static int[] mahasiswaImage = {
            R.drawable.virdyawan,
            R.drawable.andi,
            R.drawable.wiwin,
            R.drawable.mega,
            R.drawable.yulianti
    };

    static ArrayList<Mahasiswa> getListData() {
        ArrayList<Mahasiswa> list = new ArrayList<>();
        for (int position =0; position < mahasiswaNama.length; position++) {
            Mahasiswa mahasiswa = new Mahasiswa();
            mahasiswa.setNama(mahasiswaNama[position]);
            mahasiswa.setNim(mahasiswaNim[position]);
            mahasiswa.setPhoto(mahasiswaImage[position]);
            mahasiswa.setNoHp(mahasiswaHp[position]);
            list.add(mahasiswa);
        }
        return list;
    }
}