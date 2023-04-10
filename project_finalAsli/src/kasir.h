#include "header.h"
int kj = 0;
struct databarang
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
struct totalbarang
{
    long long totalbarang;
    long long totalstok;
    long long totalmodal;
    long long totalkeluaran;
    long long totallaba;
    char keterangan[20];
};

struct datakasir
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
int guy = 0;
void printstruk(int ask)
{
    remove(".\\database\\struk.txt");
    char hasil[1000];
    datakasir buru;
    databarang allo;
    FILE *ul, *kg, *rw, *rt, *kkna, *ppp;
    ul = fopen(".\\database\\struk.txt", "w+");
    kg = fopen(".\\database\\kasir.txt", "rb+");
    kkna = fopen(".\\database\\riwayatstruk.txt", "ab+");
    fprintf(ul, "\n|************** Struk Belanjaan Toko Barokah **************|\n");
    fprintf(ul, "|__________________________________________________________|\n");
    fprintf(ul, "|*   Id\t\tBarang\t\tJumlah\t\tHarga\t\ttotal     *|\n");
    int res = 0;
    int hhasil = 0;
    while (!feof(kg))
    {
        if (res == ask)
        {
            break;
        }
        res++;
        fread(&buru, sizeof(struct datakasir), 1, kg);
        fwrite(&buru, sizeof(struct datakasir), 1, kkna);
        ppp = fopen(".\\database\\infobarang.txt", "rb+");
        while (!feof(ppp))
        {
            fread(&allo, sizeof(struct databarang), 1, ppp);
            if (allo.id == buru.id)
            {
                allo.stok -= buru.stok;
                fseek(ppp, (allo.count - 1) * sizeof(struct databarang), SEEK_SET);
                fwrite(&allo, sizeof(struct databarang), 1, ppp);
                break;
            }
        }
        if (strlen(buru.barang) < 4)
        {
            fprintf(ul, "|   %d\t%s\t\t\t%d\t\t\t%d\t\t", buru.id, buru.barang, buru.stok, buru.jumlah);
            fprintf(ul, "%d\t   |\n", buru.totall);
        }
        else if (strlen(buru.barang) < 7)
        {
            fprintf(ul, "|   %d\t%s\t\t%d\t\t\t%d\t\t", buru.id, buru.barang, buru.stok, buru.jumlah);
            fprintf(ul, "%d\t   |\n", buru.totall);
        }
        else if (strlen(buru.barang) >= 7)
        {
            fprintf(ul, "|   %d\t%s   \t%d\t\t\t%d\t\t", buru.id, buru.barang, buru.stok, buru.jumlah);
            fprintf(ul, "%d\t   |\n", buru.totall);
        }
        //mengirim ke riwayatstruk.txt

        hhasil += (buru.jumlah * buru.stok);
        if (res == ask)
        {
            fprintf(ul, "|__________________________________________________________|\n");
            fprintf(ul, "|               Total Pembayaran : %d                  |\n", hhasil);
            fprintf(ul, "|            Tanggal Transaksi :  %d/%d/%d               |\n", buru.tanggal, buru.bulan, buru.tahun);
            fprintf(ul, "|              Terima Kasih Atas belanjanya                |\n");
            fprintf(ul, "|__________________________________________________________|\n");
            fprintf(ul, "|**********************************************************|\n");
        }
        fclose(ppp);
    }
    fclose(kkna);
    fclose(kg);
    fclose(ul);
    //kirim ke riwayat pembelian
    rt = fopen(".\\database\\struk.txt", "rb+");
    rw = fopen(".\\database\\riwayatpembelian.txt", "ab+");
    char car;
    while ((car = fgetc(rt)) != EOF)
    {
        fputc(car, rw);
    }
    printf("\n|**************************************************************|");
    printf("\n|                                                              |");
    printf("\n|----------------------- Struk Berhasil -----------------------|");
    printf("\n|--------------------------- Dibuat ---------------------------|");
    printf("\n|------------------------ di Struk.txt ------------------------|");
    printf("\n|                                                              |");
    printf("\n|**************************************************************|\n");
    fclose(rw);
    fclose(rt);
}
void infokasir(int bts)
{
    int jis = 0;
    FILE *ks;
    datakasir dataks;
    system("cls");
    system("cls");
    ks = fopen(".\\database\\kasir.txt", "rb+");
    printf("\n|******************************* List Data Pembelian *****************************|");
    printf("\n|                                                                                 |\n");
    printf("| Id\t   Nama Barang\t\tstok\t\tHarga\t\ttanggal transaksi |");
    printf("\n|                                                                                 |\n");
    while (!feof(ks))
    {
        if (bts == jis)
        {
            break;
        }
        jis++;
        fread(&dataks, sizeof(struct datakasir), 1, ks);
        if (strlen(dataks.barang) < 7)
        {
            printf("| %d\t\t%s\t\t", dataks.id, dataks.barang);
            printf("%d\t\t", dataks.stok);
            printf("%d\t\t", dataks.jumlah);
            printf("%d/%d/%d\t  |\n", dataks.tanggal, dataks.bulan, dataks.tahun);
        }
        else if (strlen(dataks.barang) >= 7)
        {
            printf("| %d\t     %s\t\t", dataks.id, dataks.barang);
            printf("%d\t\t", dataks.stok);
            printf("%d\t\t", dataks.jumlah);
            printf("%d/%d/%d\t  |\n", dataks.tanggal, dataks.bulan, dataks.tahun);
        }
    }
    printf("|                                                                                 |\n");
    printf("|*********************************************************************************|\n");
    fclose(ks);
}
void hapusstruk(int batas)
{
    infokasir(batas);
    int inpat;
    printf("\n|********************************** DELETE DATA **********************************|");
    printf("\n                      Pilih No Id Barang yang ingin di hapus : ");
    scanf("%d", &inpat);
    FILE *aa, *bb, *cc, *dd, *ee;
    datakasir dtksr1, dtksr2;
    databarang dtksr3;
    aa = fopen(".\\database\\kasir.txt", "rb");
    bb = fopen(".\\database\\deletekasir.txt", "wb");
    int tam = 0;
    int kata = 0;
    while (!feof(aa))
    {
        if (tam == batas)
        {
            break;
        }
        fread(&dtksr1, sizeof(struct datakasir), 1, aa);
        tam++;

        if (dtksr1.id == inpat)
        {
            kata = 1;
            guy -= 1;
            continue;
        }
        fwrite(&dtksr1, sizeof(struct datakasir), 1, bb);
    }
    fclose(aa);
    fclose(bb);
    remove(".\\database\\kasir.txt");
    cc = fopen(".\\database\\deletekasir.txt", "rb");
    dd = fopen(".\\database\\kasir.txt", "wb");
    int lll = 0;
    while (!feof(cc))
    {
        if (lll == tam)
        {
            break;
        }
        lll++;
        fread(&dtksr2, sizeof(struct datakasir), 1, cc);
        fwrite(&dtksr2, sizeof(struct datakasir), 1, dd);
    }
    fclose(cc);
    fclose(dd);
    if (kata == 0)
    {
        printf("\n|***************************! Nomor Id Tidak Ditemukan !**************************|\n");
    }
    if (kata == 1)
    {
        printf("\n|***************************! Barang Berhasil Dihapus !***************************|\n");
    }
}

void lihatbarang(int batas)
{
    int stop = 0, jb;
    FILE *fp;
    databarang client;
    fp = fopen(".\\database\\infobarang.txt", "rb+");
    printf("\n|******************* List Barang Yang tersedia *****************|");
    printf("\n|************************ Di Toko Barokah **********************|");
    printf("\n|_______________________________________________________________|\n");
    printf("| No\t|     Nama Barang\t|   Jumlah\t|    Harga\t|");
    printf("\n|_______________________________________________________________|\n");

    FILE *huh;
    totalbarang jangan;
    huh = fopen(".\\database\\infototal.txt", "rb+");
    while (!feof(huh))
    {
        fread(&jangan, sizeof(struct totalbarang), 1, huh);
    }
    while (!feof(fp))
    {
        if (stop == jangan.totalbarang)
        {
            fclose(huh);
            break;
        }
        stop++;
        fread(&client, sizeof(struct databarang), 1, fp);
        /* display record */

        if (strlen(client.barang) < 8)
        {
            printf("| %d\t|\t%s\t\t|\t%d\t|\t%d\t|\n", client.id, client.barang,
                   client.stok, client.harga);
        }
        else if (strlen(client.barang) >= 8)
        {
            printf("| %d\t|\t%s\t|\t%d\t|\t%lld\t|\n", client.id, client.barang,
                   client.stok, client.harga);
        }
    }
    printf("|_______________________________________________________________|\n");
    fclose(fp);
}

void editkasir(int lol)
{
    infokasir(guy);
    int asya, id2, stok2, jumlah2, total2;
    char jika[20];
    printf("\n\n|****************************** Edit Data Pembayaran *****************************|");
    printf("\n|                                                                                 |");
    printf("\n|                        Pilih Id Barang Yang Ingin Diedit : ");
    scanf("%d", &asya);
    printf("|                                                                                 |");
    printf("\n");
    lihatbarang(lol);
    printf("\n");
    printf("|********************** Data Sedang Diubah *********************|");
    printf("\n|--------------- Silahkan Masukkan Data Kembali ----------------|");
    printf("\n|                                                               |\n");
    printf("|                    Id \t: ");
    scanf("%d", &id2);
    printf("|                    Stok \t: ");
    scanf("%d", &stok2);
    FILE *oooh;
    datakasir peer;
    oooh = fopen(".\\database\\kasir.txt", "rb+");
    int kan = 0;
    int dess = 0;
    while (!feof(oooh))
    {
        fread(&peer, sizeof(struct datakasir), 1, oooh);
        dess++;
        if (asya == peer.id)
        {
            FILE *bck;
            databarang juhu, komu;
            bck = fopen(".\\database\\infobarang.txt", "rb+");
            while (!feof(bck))
            {
                fread(&juhu, sizeof(struct databarang), 1, bck);
                if (peer.id == juhu.id)
                {
                    kan = 2;
                    FILE *uye;
                    uye = fopen(".\\database\\infobarang.txt", "rb+");
                    while (!feof(uye))
                    {
                        fread(&komu, sizeof(struct databarang), 1, uye);
                        if (id2 == komu.id)
                        {
                            kan = 1;
                            peer.id = id2;
                            peer.stok = stok2;
                            peer.jumlah = komu.harga;
                            peer.totall = (peer.stok * peer.jumlah);
                            for (int jko = 0; jko < 15; jko++)
                            {
                                peer.barang[jko] = komu.barang[jko];
                            }
                            fseek(oooh, (dess - 1) * sizeof(struct datakasir), SEEK_SET);
                            fwrite(&peer, sizeof(struct datakasir), 1, oooh);
                            break;
                        }
                    }

                    fclose(uye);
                    break;
                }
            }
            fclose(oooh);
            fclose(bck);

            break;
        }
    }
    if (kan == 0)
    {
        printf("|---------------------------------------------------------------|\n");
        printf("|************** Maaf Tidak Ada Id Yang Sesuai ******************|\n");
        printf("|******************* Data Gagal Diupdate ***********************|\n");
        printf("|---------------------------------------------------------------|\n");
    }
    else if (kan == 1)
    {
        printf("|                                                               |");
        printf("\n|---------------------------------------------------------------|");
        printf("\n|****************** Data Berhasil Diupdate *********************|");
        printf("\n|---------------------------------------------------------------|\n");
    }
    if (kan == 2)
    {
        printf("|---------------------------------------------------------------|\n");
        printf("|************ Maaf Id Baru Anda Tidak Ada Dilist ***************|\n");
        printf("|******************* Data Gagal Diupdate ***********************|\n");
        printf("|---------------------------------------------------------------|\n");
    }
}

void beli_barang(int batas)
{
    remove(".\\database\\kasir.txt");
tambahkasir:
    system("cls");
    system("cls");
    lihatbarang(batas);
    databarang clients;
    datakasir kasirr;
    int option;
    FILE *ka;
    printf("\n\n|**************** Pilih Barang Yang Ingin Dibeli ***************|\n\n");

    ka = fopen(".\\database\\kasir.txt", "ab+");
jkt:
    guy++;
    printf("                     Id Barang \t : ");
    int ye;
    scanf("%d", &ye);
    int yous;
    printf("                     Jumlah Stok : ");
    scanf("%d", &yous);
    kasirr.id = ye;
    FILE *gk, *ui;

    gk = fopen(".\\database\\infobarang.txt", "rb+");
    int tempe = 0;
    while (!feof(gk))
    {
        ui = fopen(".\\database\\riwayatstruk.txt", "ab+");
        fread(&clients, sizeof(struct databarang), 1, gk);
        if (kasirr.id == clients.id)
        {
            if (clients.stok <= 0)
            {
                tempe = 3;
                clients.stok == 0;
                printf("\n|************* Stok Barang Sudah Habis ! *************|");
                guy--;
                goto here;
            }
            else if (yous > clients.stok)
            {
                printf("\n|************* Input Stok Melebihi Batas! *************|");
                guy--;
                tempe = 3;
                goto here;
            }

            clients.stok -= yous;
            kasirr.jumlah = clients.harga;
            for (int wes = 0; wes <= 20; wes++)
            {
                kasirr.barang[wes] = NULL;
            }
            for (int u = 0; u < strlen(clients.barang); u++)
            {
                kasirr.barang[u] = clients.barang[u];
            }
            kasirr.stok = yous;
            //waktu
            struct tm *waktu;
            time_t haha;
            haha = time(NULL);
            waktu = localtime(&haha);
            kasirr.tanggal = waktu->tm_mday;
            kasirr.bulan = waktu->tm_mon + 1;
            kasirr.tahun = waktu->tm_year + 1900;
            kasirr.totall = (kasirr.stok * kasirr.jumlah);
            fwrite(&kasirr, sizeof(struct datakasir), 1, ka);
            tempe = 1;
        here:
            fclose(ui);
            break;
        }
    }
    if (tempe == 0)
    {
        guy -= 1;
        printf("\n|*****************! Id Barang Tidak Ditemukan !*****************|\n");
    }
    else if (tempe == 1)
    {
        printf("\n|****************! Barang Berhasil Ditambahkan !****************|\n");
    }
    else if (tempe == 3)
    {
        printf("\n|*****************! Barang Gagal Ditambahkan !*****************|\n");
    }
    fclose(gk);
guh:
    char anu;
    char lewatin;
    scanf("%c", &lewatin);
    printf("\n  Lanjutkan (y/n) ? ");
    scanf("%c", &anu);
    printf("\n");
    switch (anu)
    {
    case 'y':
        goto jkt;
        break;
    case 'Y':
        goto jkt;
        break;
    case 'n':
        break;
    case 'N':
        break;
    default:
        printf("\n|***************! Anda salah input, Hanya (y/n) !***************|\n");
        goto guh;
        break;
    }
    fclose(ka);
    printf("\n");
    system("pause");
    // jawab
}

void dasboard_kasir(int ass)
{
kere:
    int jwb;
    databarang kasir;
bkj:
    printf("\n|************** Selamat Datang Di Toko Barokah ****************|\n");
    printf("\n|********************** Selamat Bebelanja *********************|\n");
    printf("|______________________________________________________________|\n");
    printf("|                                                              |\n");
    printf("|                      1. Belanja                              |\n");
    printf("|                      2. lihat struk                          |\n");
    printf("|                      3. Update Struk                         |\n");
    printf("|                      4. Delete Struk                         |\n");
    printf("|                      5. Print struk                          |\n");
    printf("|                      6. Kembali                              |\n");
    printf("|______________________________________________________________|\n");

    printf("  Pilih [1-6] : ");
    scanf("%d", &jwb);
    switch (jwb)
    {
    case 1:
        guy = 0;
        beli_barang(ass);
        system("cls");
        system("cls");
        printf("|*****************! Struk Berhasil Disimpan !******************|\n");
        goto kere;
        break;

    case 2:
        infokasir(guy);
        printf("\n");
        system("pause");
        system("cls");
        system("cls");
        goto kere;
        break;
    case 3:
        system("cls");
        system("cls");
        editkasir(ass);
        printf("\n");
        system("pause");
        system("cls");
        system("cls");
        goto kere;
        break;
    case 4:
        hapusstruk(guy);
        printf("\n");
        system("pause");
        system("cls");
        system("cls");
        goto kere;
        break;
    case 5:
        printstruk(guy);
        printf("\n");
        system("pause");
        system("cls");
        system("cls");
        goto kere;
        break;
    case 6:
        break;

    default:
        system("cls");
        system("cls");
        printf("\n|******************! Maaf input anda salah !*******************|\n");
        goto bkj;
        break;
    }
}