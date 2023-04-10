#include "header.h"
#include "kasir.h"
#include "admin.h"
int main()
{
home:
    system("cls");
    system("cls");
    int jawab, jk;
    printf("\n*************** FINAL PROJECT ***************");
    printf("\n**-----------------------------------------**\n");
    printf("**               masuk sebagai :           **\n");
    printf("**               1. Admin                  **\n");
    printf("**               2. Kasir                  **\n");
    printf("**               3. Keluar                 **\n");
    printf("**-----------------------------------------**");
    printf("\n*********************************************\n");
inpo:
    printf("  Pilih[1-3] : ");
    scanf("%d", &jawab);

    if (jawab == 1)
    {
    tambahbarang1:
        system("cls");
        system("cls");
        dashboard_admin();
        system("cls");
        goto home;
    }
    else if (jawab == 2)
    {
        FILE *aku;
        databarang cek;
        aku = fopen(".\\database\\infobarang.txt", "rb");
        jk = 0;
        while (!feof(aku))
        {
            fread(&cek, sizeof(struct databarang), 1, aku);
            jk += cek.batas;
        }
        jk -= 1;
        system("cls");
        system("cls");
        fclose(aku);
        dasboard_kasir(jk);
        system("cls");
        printf("*** File Anda Sudah disave ***\n\n");
        goto home;
    }
    else if (jawab == 3)
    {
        goto akhir;
    }
    else
    {
        printf("\nMaaf Anda salah input !\n\n");
        goto inpo;
    }

akhir:
    printf("\n\n|*************** Akhir dari Program ***************|\n");
    printf("|************** Sekian Terima Kasih ***************|\n");
    return 0;
}