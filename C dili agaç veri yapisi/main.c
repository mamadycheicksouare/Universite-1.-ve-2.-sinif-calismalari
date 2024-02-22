
//MAMADY CHEICK SOUARE
// 20100011002

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct node{
    int no;
    char ad[30];
    struct node *sol,*sag;

}agac;
//*********************EKLEME FONKSIYONU****************

agac *ekleme(agac *root,int no, char ad[])
{
    agac *newnode = malloc(sizeof(agac));
    newnode->no = no;
   strncpy(newnode->ad, ad, sizeof(newnode->ad) - 1);
    newnode->ad[sizeof(newnode->ad) - 1] = '\0';
    newnode->sag = NULL;
    newnode->sol =NULL;

    if(root ==NULL)
    {
        return newnode;
    }

    if(no<root->no)
    {
        root->sol = ekleme(root->sol,no,ad);
    }
    else if(no>root->no)
    {
        root->sag = ekleme(root->sag,no,ad);
    }
    return root;
}

//****************inorderlisteleme** sol-kok-sag*********

void listele(agac *root)
{
    if(root != NULL)
    {
        listele(root->sol);
        printf("%d------> %s\n",root->no,root->ad);
        listele(root->sag);
    }
}


//***************************nolarin toplami bulan function****
int sum(agac*root)
{
    if(root==NULL)
    {
         return 0;
    }

    return root->no+ sum(root->sol) + sum(root->sag);
}

//****************************dugumsayisibulan fonksiyon******************

int nodes(agac*root)
{
    if(root==NULL)
    {
        return 0;
    }
    return 1+ nodes(root->sol) + nodes(root->sag);
}
//*************************ortalamayi bulan fonksiyon*******************
double ortalama(agac*root)
{
    if(nodes(root) == 0)
    {
        return 0;
    }
    return (double) sum(root)/nodes(root);
}
//****************YUKSEKLIK HESAPLAYAN FONKSIYON*************************
int yukseklik(agac*root)
{
    if(root==NULL)
        return 0;
    else{
        return 1 + (yukseklik(root->sol)< yukseklik(root->sag) ? yukseklik(root->sag):yukseklik(root->sol));
    }
}


//**************SILME FONKSIYONU8***********************

agac *silme(agac *root, char ad[])
{
    if(root==NULL)
        return NULL;


   root->sol = silme(root->sol,ad);
   root->sag = silme(root->sag,ad);

   while(strcmp(ad,root->ad) == 0)
   {
       if(root->sol == NULL)
       {
           agac *temp = root->sag;
           free(root);
           return temp;
       }
       else if(root->sag == NULL)
       {
           agac *temp = root->sol;
           free(root);
           return temp;
       }

       agac *temp = root->sag;
       while(temp->sol != NULL)
       {
           temp = temp->sol;
       }

       root->no = temp->no;
       strncpy(root->ad,temp->ad,sizeof(root->ad)-1);

       root->ad[sizeof(root->ad)-1] = '\0';

       root->sag = silme(root->sag,temp->ad);
   }

   return root;
}

//***********************MAIN FONKSIYONU******************************
int main()
{
   agac * root =NULL;

   FILE *dosya = fopen("bilgi.txt","r");

   if(dosya ==NULL)
   {
       printf("DOSYA ACILMADI !!!");
       exit(-1);
   }
 int no;
 char ad[30];


   while(fscanf(dosya,"%d %30s",&no,ad) == 2)
   {
       root = ekleme(root,no,ad);
   }
   fclose(dosya);

    printf("DOSYADAN EKLEME ISLEMI GERCEKLESTIRILDI !!!\n\n");
    int sec;

    char silinecekad[30];
    while(1)
    {

        printf("**********************MENU****************************\n");
        printf("1- SILME\n2- YUKSEKLIK BUL\n3- NUMARALARIN ORTALAMASINI BUL\n4- INORDER LISTELEME\n5- CIKIS\n");
        scanf("%d",&sec);


         switch (sec) {
            case 1:
                 printf("SILMEK ISTEDIGINIZ ADI GIRINIZ ------>");
                 scanf("%s",&silinecekad);
                 root = silme(root,silinecekad);

                break;

            case 2:
                 printf("YUKSEKLIK----> %d\n", yukseklik(root));
                break;

            case 3:
                        printf("ORTALAMA----> %2f\n", ortalama(root));
                break;

            case 4:
                listele(root);

                break;


            case 5:
                printf("CIKIS YAPILDI\n");
                  exit(0);

                break;

            default:
                printf("YANLIS ISLEM SECILDI TEKRAR EDIN !!!\n\n");
        }
    }
    return 0;
}
