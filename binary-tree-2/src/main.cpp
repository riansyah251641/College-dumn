#include <bits/stdc++.h>
#include <string>
using namespace std;
struct node
{
    int data;
    string nama;
    node *left;
    node *right;
};
node *root, *cur, *newnode;
void addfirst(int data, string nama)
{
    root = new node();
    root->data = data;
    root->nama = nama;
    root->left = NULL;
    root->right = NULL;
}
int check()
{
    int cek;
    if (root->left == NULL && root->right == NULL)
    {
        cek = 1;
    }
    else
    {
        cek = 0;
    }
}
int as = 0;
void inputan(int data, string nama)
{
    cur = root;
    newnode = new node();
    newnode->data = data;
    newnode->nama = nama;
    newnode->left = NULL;
    newnode->right = NULL;
    while (1)
    {

        if (data < cur->data)
        {
            if (cur->left == NULL)
            {
                cur->left = newnode;
                break;
            }
            cur = cur->left;
            as = 1;
        }
        else
        {
            if (cur->right == NULL)
            {
                cur->right = newnode;
                break;
            }
            cur = cur->right;
            as = 0;
        }
    }
}
int find(node *head, int data)
{
    int cek = 0;
    if (head == NULL)
    {
        return cek;
    }
    if (head->data != data)
    {
        if (data < head->data)
        {
            find(head->left, data);
        }
        else
        {
            find(head->right, data);
        }
    }
    else
    {
        cek = 1;
        return cek;
    }
}

int aiscii(string kata)
{
    int hasil = 0, i;
    for (i = 0; i < kata.length(); i++)
    {
        hasil += (int)kata[i];
    }
    return hasil;
}
int lp = 0;
void inorder(node *head, string temp[])
{
    if (head)
    {
        inorder(head->left, temp);
        cout << "keturunan : " << head->data << " | nama : " << head->nama;
        if (aiscii(temp[lp]) == head->data)
        {
            cout << " | Kembaran : ";
            while (aiscii(temp[lp]) == head->data)
            {
                cout << temp[lp] << " ";
                lp++;
            }
            cout << endl;
        }
        else
        {
            cout << endl;
        }
        inorder(head->right, temp);
    }
}
int main()
{
    int n, i, h = 0; string temp[101]; char nama[101];
    scanf("%d", &n);
    for (i = 0; i < n; i++)
    { scanf("%s", nama);
        int aisci = aiscii(nama);
        if (find(root, aisci) == 0)
        {
            if (root == NULL)
                addfirst(aisci, nama);
            else
                inputan(aisci, nama);
        }
        else
        {
            temp[h] = nama;
            h++;
        }
    }
    sort(temp, temp + h);
    inorder(root, temp);
    return 0;
}