#include "header.h"

struct databarangadmin
{
    int count;
    int id;
    char barang[100];
    int batas = 0;
    int stok;
    long long modal;
    long long harga;
    long long total;
    long long hasil;
    int tanggal;
    int bulan;
    int tahun;
};
struct infototal
{
    long long totalbarang = 0;
    long long totalstok = 0;
    long long totalmodal = 0;
    long long totalkeluaran = 0;
    long long totallaba = 0;
    char keterangan[20];
};
struct datakasiradmin
{
    int id;
    char barang[100];
    int stok;
    long long jumlah;
    long long totall;
    int tanggal;
    int bulan;
    int tahun;
};
// opsi 3 riwayat struk;
void riwayatstruk()
{
    int jhg, kwqsa, dt, mn, yr, kor, kir, kur, totalbeli, totalsma, pendapatan, pendapatanlw, aw1, aw2, aw3, ls1, ls2, ls3, bab = 0, idts1, idts2;
    ;
    kwqsa = 0;
    totalbeli = 0;
    pendapatan = 0;
    totalsma = 0;
qw:
    printf("|********** Info Riwayat Pembelian **********|\n");
    printf("|--------------------------------------------|\n");
    printf("|         1. Tampilkan Semua Data            |\n");
    printf("|         2. Custom Berdasarkan Tanggal      |\n");
    printf("|         3. Hapus Data Riwayat              |\n");
    printf("|--------------------------------------------|\n");
    printf("  Pilih [1-3] : ");
    scanf("%d", &jhg);
    if (jhg == 2)
    {
        kwqsa = 1;
    }
    else if (jhg == 1)
    {
    }
    else if (jhg == 3)
    {
        remove(".\\database\\riwayatstruk.txt");
        remove(".\\database\\riwayatpembelian.txt");
        printf("\n***************! Data Riwayat Berhasil Dihapus !***************\n");
        goto kaaa;
    }
    else
    {
        system("cls");
        system("cls");
        printf("\n*****************! Input Anda Salah !*****************\n");
        goto qw;
    }
    if (kwqsa == 1)
    {
        printf("Custom Tanggal mulai(Date Mount Year)\n");
        scanf("%d %d %d", &dt, &mn, &yr);
        printf("Custom Tanggal Akhir (Date Mount Year)\n");
        scanf("%d %d %d", &kor, &kir, &kur);
    }
    FILE *weq;
    datakasiradmin gini;
    weq = fopen(".\\database\\riwayatstruk.txt", "rb");
    system("cls");
    system("cls");
    printf("\n\n********************************* Riwayat Pembelian Barang ********************************\n");
    printf("|__________________________________________________________________________________________|\n");
    printf("|  No\t|     Barang\t|     Jumlah\t|     Stok\t|     Total\t|     Tanggal\t   |\n");
    printf("|__________________________________________________________________________________________|\n");
    if (kwqsa == 0)
    {
        totalbeli = 0;
        pendapatan = 0;
        pendapatanlw = 0;
        idts1 = 0;
        while (!feof(weq))
        {
            bab++;
            fread(&gini, sizeof(struct datakasiradmin), 1, weq);
            if (idts1 == gini.id)
            {
                break;
            }
            idts1 = gini.id;
            totalbeli += gini.stok;
            totalsma += gini.stok;
            pendapatanlw += (gini.stok * gini.jumlah);
            pendapatan += (gini.stok * gini.jumlah);
            if (bab == 1)
            {
                aw1 = gini.tanggal;
                aw2 = gini.bulan;
                aw3 = gini.tahun;
            }
            if (strlen(gini.barang) < 7)
            {
                printf("| %d\t|\t%s\t|\t%d\t|\t", gini.id, gini.barang, gini.jumlah);
                printf("%d\t|\t", gini.stok);
                printf("%d\t|\t", gini.totall);
                printf("%d/%d/%d |\n", gini.tanggal, gini.bulan, gini.tahun);
            }
            else
            {
                printf("| %d\t|\t%s |\t%d\t|\t", gini.id, gini.barang, gini.jumlah);
                printf("%d\t|\t", gini.stok);
                printf("%d\t|\t", gini.totall);
                printf("%d/%d/%d |\n", gini.tanggal, gini.bulan, gini.tahun);
            }
        }
        ls1 = gini.tanggal;
        ls2 = gini.bulan;
        ls3 = gini.tahun;
        fclose(weq);
    }
    else
    {
        bab = 0;
        totalbeli = 0;
        pendapatan = 0;
        totalsma = 0;
        pendapatanlw = 0;
        while (!feof(weq))
        {
            bab++;
            fread(&gini, sizeof(struct datakasiradmin), 1, weq);
            totalsma += gini.stok;
            pendapatan += (gini.stok * gini.jumlah);
            if (bab == 1)
            {
                aw1 = gini.tanggal;
                aw2 = gini.bulan;
                aw3 = gini.tahun;
            }
            if (gini.tanggal >= dt && gini.bulan >= mn && gini.tahun >= yr && gini.tanggal <= kor && gini.bulan <= kir && gini.tahun <= kur)
            {
                totalbeli += gini.stok;
                pendapatanlw += (gini.stok * gini.jumlah);
                printf("| %d\t|\t%s\t|\t%d\t|\t", gini.id, gini.barang, gini.jumlah);
                printf("%d\t|\t", gini.stok);
                printf("%d\t|\t", gini.totall);
                printf("%d/%d/%d |\n", gini.tanggal, gini.bulan, gini.tahun);
                ls1 = gini.tanggal;
                ls2 = gini.bulan;
                ls3 = gini.tahun;
            }
        }
        fclose(weq);
    }
    printf("|__________________________________________________________________________________________|\n");
kaaa:

    printf("\n|*************** KETERANGAN PEMBELIAN ***************|");
    printf("\n|                                                    |");
    printf("\n|     Barang Dibeli     : %d                        |", totalbeli);
    printf("\n|     Total Pembelian   : %d                        |", totalsma);
    printf("\n|     Penghasilan       : %d                    |", pendapatanlw);
    printf("\n|     Total Penghasilan : %d                    |", pendapatan);
    printf("\n|     Awal Transaksi    : %d/%d/%d                 |", aw1, aw2, aw3);
    printf("\n|     Akhir Transaksi   : %d/%d/%d                 |", ls1, ls2, ls3);
    printf("\n|                                                    |");
    printf("\n|****************************************************|");
    printf("\n");
}

// Opsi 2 (keterangan tambahan);
void infototall()
{
    FILE *uk, *gq, *iiu;
    databarangadmin hewe;
    infototal hawa;
    uk = fopen(".\\database\\infobarang.txt", "rb+");
    iiu = fopen(".\\database\\infobarang.txt", "rb");
    int bus = 0;
    databarangadmin gess;
    while (!feof(iiu))
    {
        fread(&gess, sizeof(struct databarangadmin), 1, iiu);
    }
    while (!feof(uk))
    {
        if (bus == gess.count)
        {
            break;
        }
        fread(&hewe, sizeof(struct databarangadmin), 1, uk);
        gq = fopen(".\\database\\infototal.txt", "wb+");
        hawa.totalbarang = hewe.count;
        hawa.totalstok += hewe.stok;
        hawa.totalmodal += hewe.modal;
        hawa.totallaba += hewe.hasil;
        hawa.totalkeluaran += hewe.total;

        bus++;
    }
    fclose(iiu);
    if (hawa.totallaba >= 0)
    {
        char kata[] = "UNTUNG";
        for (int bem = 0; bem < strlen(kata); bem++)
        {
            hawa.keterangan[bem] = kata[bem];
        }
    }
    else
    {
        char kata1[] = "RUGI";
        for (int bem = 0; bem < strlen(kata1); bem++)
        {
            hawa.keterangan[bem] = kata1[bem];
        }
    }
    fwrite(&hawa, sizeof(struct infototal), 1, gq);
    fclose(gq);
    fclose(uk);

    printf("|************* KETERANGAN TAMBAHAN *************|\n");
    printf("|_______________________________________________|\n");
    FILE *jjk;
    infototal hih;
    jjk = fopen(".\\database\\infototal.txt", "rb+");
    fread(&hih, sizeof(struct infototal), 1, jjk);
    printf("|  Total Barang \t: %d\t\t\t|\n", hih.totalbarang);
    printf("|  Total Asset \t\t: %d\t\t|\n", hih.totalkeluaran);
    printf("|  Total Modal \t\t: %d\t\t|\n", hih.totalmodal);
    printf("|  Total Laba \t\t: %d\t\t|\n", hih.totallaba);
    printf("|  Totak Stok \t\t: %d\t\t\t|\n", hih.totalstok);
    printf("|  Keterangan \t\t: %s\t\t|\n", hih.keterangan);
    printf("|_______________________________________________|\n");
    fclose(jjk);
    //akhir
    system("pause");
}

//opsi 1 menambahkan barang ;
void tambahbarang()
{
    databarangadmin add_barang, cekk;
    FILE *kasir, *lastdt;
    lastdt = fopen(".\\database\\infobarang.txt", "rb+");
    kasir = fopen(".\\database\\infobarang.txt", "ab+");
    while (!feof(lastdt))
    {
        fread(&cekk, sizeof(struct databarangadmin), 1, lastdt);
    }

    system("cls");
    printf("*************** Tambah Ketersediaan Barang ***************\n");
    printf("___________________________________________________________\n\n");
    printf("Data ke- %d\n", cekk.count + 1);
    add_barang.count = cekk.count + 1;
    fclose(lastdt);
    printf("id\t\t: ");
    scanf("%d", &add_barang.id);
    printf("Barang\t\t: ");
    scanf("%s", &add_barang.barang);
    printf("Stok\t\t: ");
    scanf("%d", &add_barang.stok);
    printf("Harga @\t\t: ");
    scanf("%lld", &add_barang.harga);
    printf("Modal\t\t: ");
    scanf("%lld", &add_barang.modal);
    long long total;
    long long hasil;
    total = (add_barang.harga * add_barang.stok);
    hasil = total - add_barang.modal;
    add_barang.total = total;
    add_barang.hasil = hasil;
    add_barang.batas++;
    //waktu
    struct tm *waktu;
    time_t haha;
    haha = time(NULL);
    waktu = localtime(&haha);
    add_barang.tanggal = waktu->tm_mday;
    add_barang.bulan = waktu->tm_mon + 1;
    add_barang.tahun = waktu->tm_year + 1900;
    fwrite(&add_barang, sizeof(struct databarangadmin), 1, kasir);
    printf("\n***** Data Berhasil Ditambahkan *****");
    fclose(kasir);
}

// Opsi 2 (menampilkan data barang) ;
void tampildataadmin()
{
    FILE *bn;
    databarangadmin masuk;
    system("cls");
    system("cls");
    bn = fopen(".\\database\\infobarang.txt", "rb+");
    printf("\n|************************************ Data ketersedian Barang di Toko Barokah ***********************************|\n");
    printf("|________________________________________________________________________________________________________________|\n");
    printf("|                                                                                                                |\n");
    printf("|   No\tNama Barang\tStok\tHarga jual\tTotal Asset\tModal\t\tHasil/Laba\tWaktu\t\t |\n");
    printf("|                                                                                                                |\n");
    int hop = 0;
    databarangadmin kari;
    FILE *auoh;
    int limit = 0;
    auoh = fopen(".\\database\\infobarang.txt", "rb");
    while (!feof(auoh))
    {
        fread(&kari, sizeof(struct databarangadmin), 1, auoh);
    }
    while (!feof(bn))
    {
        if (limit == kari.count)
        {
            fclose(auoh);
            break;
        }
        limit++;
        databarangadmin jos;
        FILE *tp;
        tp = fopen(".\\database\\infobarang.txt", "rb+");
        fclose(tp);
        hop++;
        fread(&masuk, sizeof(struct databarangadmin), 1, bn);
        /* display record */

        if (strlen(masuk.barang) < 5)
        {
            printf("| %d\t   %s\t\t%d\t%d\t\t", masuk.id, masuk.barang,
                   masuk.stok, masuk.harga);
            printf("%d\t\t", masuk.total);
            printf("%d\t\t", masuk.modal);
            printf("%d\t\t", masuk.hasil);
            printf("%d/%d/%d\t |\n", masuk.tanggal, masuk.bulan, masuk.tahun);
        }
        else if (strlen(masuk.barang) > 4)
        {
            printf("| %d\t   %s\t%d\t%d\t\t", masuk.id, masuk.barang,
                   masuk.stok, masuk.harga);
            printf("%d\t\t", masuk.total);
            printf("%d\t\t", masuk.modal);
            printf("%d\t\t", masuk.hasil);
            printf("%d/%d/%d\t |\n", masuk.tanggal, masuk.bulan, masuk.tahun);
        }
    }
    printf("|                                                                                                                |\n");
    printf("|________________________________________________________________________________________________________________|\n\n");
}

void hapusdata()
{
    system("cls");
    system("cls");
    tampildataadmin();
    printf("|******************* DELETE DATA BARANG *******************|\n");
    int hhh;
    printf("            pilih nomor id yang ingin dihapus : ");
    scanf("%d", &hhh);
    FILE *mls, *mlk, *miss, *moss, *ftr;
    databarangadmin gas, moh, read, chge;
    mls = fopen(".\\database\\infobarang.txt", "rb");
    mlk = fopen(".\\database\\deleteadmin.txt", "wb");
    ftr = fopen(".\\database\\infobarang.txt", "rb");
    int jas = 100;
    int sas = 0;

    while (!feof(ftr))
    {
        fread(&read, sizeof(struct databarangadmin), 1, ftr);
    }
    int b = 0;
    while (!feof(mls))
    {
        if (b == read.count)
        {
            break;
        }
        b++;
        fread(&gas, sizeof(struct databarangadmin), 1, mls);
        if (hhh == gas.id)
        {
            sas = 1;
            jas = gas.count;
            continue;
        }
        if (gas.count > jas)
        {
            gas.count -= 1;
        }
        fwrite(&gas, sizeof(struct databarangadmin), 1, mlk);
    }
    fclose(mls);
    fclose(mlk);
    remove(".\\database\\infobarang.txt");
    miss = fopen(".\\database\\deleteadmin.txt", "rb");
    moss = fopen(".\\database\\infobarang.txt", "wb");
    int q = 0;
    while (!feof(miss))
    {
        if (q == read.count - 1)
        {
            break;
        }
        q++;
        fread(&moh, sizeof(struct databarangadmin), 1, miss);
        fwrite(&moh, sizeof(struct databarangadmin), 1, moss);
    }
    if (sas == 0)
    {
        printf("\n|******************! Data Gagal Dihapus !******************|\n\n");
    }
    else if (sas == 1)
    {
        printf("\n|****************! Data Berhasil Dihapus !*****************|\n\n");
    }
    fclose(ftr);
    fclose(miss);
    fclose(moss);
}

// Opsi 4 edit data barang ;
void editdatadmin()
{
    tampildataadmin();
    int asyu, id1, stok1, harga1, tanggal1, bulan1, tahun1;
    int total1, modal1, hasil1, jop = 0;
    char jik[20];
    printf("\n\n|********************* Edit Data Barang **********************|");
    printf("\n|       Pilih Id Barang Yang Ingin Diedit : ");
    scanf("%d", &asyu);
    FILE *eee;
    databarangadmin jus;
    eee = fopen(".\\database\\infobarang.txt", "rb+");
    while (!feof(eee))
    {
        fread(&jus, sizeof(struct databarangadmin), 1, eee);
        if (asyu == jus.id)
        {
            jop = 1;
            break;
        }
    }
    if (jop == 0)
    {
        goto kom;
    }

    printf("\n|--------------- Silahkan Masukkan Data Kembali --------------|");
    printf("\n|                                                             |\n");
    printf("|                    Id \t: ");
    scanf("%d", &id1);
    printf("|                    Barang \t: ");
    scanf("%s", &jik);
    printf("|                    Stok \t: ");
    scanf("%d", &stok1);
    printf("|                    Harga \t: ");
    scanf("%d", &harga1);
    printf("|                    Modal \t: ");
    scanf("%d", &modal1);
    total1 = (stok1 * harga1);
    hasil1 = (total1 - modal1);
kom:
    FILE *kkkk, *sss;
    databarangadmin hypo;
    kkkk = fopen(".\\database\\infobarang.txt", "rb+");
    int kon = 0;
    while (!feof(kkkk))
    {
        fread(&hypo, sizeof(struct databarangadmin), 1, kkkk);
        if (asyu == hypo.id)
        {
            kon = 1;
            hypo.id = id1;
            hypo.harga = harga1;
            hypo.stok = stok1;
            hypo.modal = modal1;
            hypo.total = total1;
            hypo.hasil = hasil1;
            for (int qak = 0; qak < 20; qak++)
            {
                hypo.barang[qak] = NULL;
            }
            for (int qa = 0; qa < strlen(jik); qa++)
            {
                hypo.barang[qa] = jik[qa];
            }
            fseek(kkkk, (hypo.count - 1) * sizeof(struct databarangadmin), SEEK_SET);
            fwrite(&hypo, sizeof(struct databarang), 1, kkkk);
            fclose(kkkk);
            printf("|                                                             |");
            printf("\n|-------------------------------------------------------------|");
            printf("\n|****************** Data Berhasil Diupdate *******************|");
            printf("\n|-------------------------------------------------------------|\n");
            break;
        }
    }
    if (kon == 0)
    {
        printf("|-------------------------------------------------------------|\n");
        printf("|************** Maaf Tidak Ada Id Yang Sesuai ****************|\n");
        printf("|******************* Data Gagal Diupdate *********************|\n");
        printf("|-------------------------------------------------------------|\n");
    }
}

//dasboard admin;
void dashboard_admin()
{
    int yw;
    system("cls");
    system("cls");
    system("cls");
awal:
    printf("\n**************** Welcome To Admin User ***************");
    printf("\n______________________________________________________");
    printf("\n----------------------- OPTION -----------------------");
    printf("\n--__________________________________________________--");
    printf("\n--               1. Input Data Barang               --");
    printf("\n--               2. Lihat Data Barang               --");
    printf("\n--               3. Riwayat Pembelian               --");
    printf("\n--               4. Edit Data Barang                --");
    printf("\n--               5. Hapus Data Barang               --");
    printf("\n--               6. Kembali                         --");
    printf("\n--__________________________________________________--");

    printf("\n  Pilih [1-5] : ");
    scanf("%d", &yw);
    switch (yw)
    {
    case 1:
    tambahbarang1:
        system("cls");
        tambahbarang();
    ulang1:
        int kwp;
        printf("\n\nOption\n");
        printf("1. Tambah Barang\n");
        printf("2. Kembali\n");
        printf("Pilih [1-2] : ");
        scanf("%d", &kwp);
        system("cls");
        switch (kwp)
        {
        case 1:
            goto tambahbarang1;
            break;
        case 2:
            system("cls");
            system("cls");
            goto awal;
            break;
        default:
            printf("\nmaaf yang anda masukkan salah\n");
            goto ulang1;
            break;
        }
        break;

    case 2:
        system("cls");
        system("cls");
        tampildataadmin();
        infototall();
        system("cls");
        system("cls");
        goto awal;
        break;
    case 3:
        system("cls");
        system("cls");
        system("cls");
        riwayatstruk();
        system("pause");
        system("cls");
        system("cls");
        goto awal;
        break;
    case 4:
        system("cls");
        system("cls");
        editdatadmin();
        printf("\n");
        system("pause");
        system("cls");
        system("cls");
        goto awal;
        break;

    case 5:
        hapusdata();
        system("pause");
        system("cls");
        system("cls");
        goto awal;
        break;
    case 6:
        break;
    default:
        system("cls");
        system("cls");
        printf("**************! Maaf Anda Salah Input !***************\n");
        goto awal;
        break;
    }
}
