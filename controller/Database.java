package controller;

// Class ini bersifat sementara untuk menyimpan data

import java.util.ArrayList;

import model.User;
import model.matakuliah.*;

public class Database {
    public static ArrayList<User> users = new ArrayList<User>();
    public static ArrayList<MataKuliah> mataKuliah = new ArrayList<MataKuliah>();
    public static ArrayList<MataKuliahPilihan> mataKuliahPilihan = new ArrayList<MataKuliahPilihan>();
}
