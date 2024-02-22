
//MAMADY CHEICK SOUARE 20100011002 

package NYP_paket;

import java.util.Scanner;

public class Anasayfa {

	public static void main(String[] args) {
		
		int bs;      // BOLUM SAYISI
		int ds;     //  DERS SAYISI
		
		int ls;    //   lisans ogr sayisi
		int yls;  //    YL ogr sayisi 
		int bolNo;
		String bolAd;
		int dersKredi;
		int derssayisi=0;
		int [] krediler;  // EN FAZLA DERS SAYISIDEN OLUSAN BIR DIZI 
		String dersAdi;
		
		LisansOgrencisi gecicilisans = new LisansOgrencisi(0, null, null, 0);
		YLOgrencisi geciciyl = new YLOgrencisi(0, null, null);
		
		//ogrenci icin 
		int sinif;
		String ad;
		String soyad;
	
		try (Scanner scan = new Scanner(System.in)) {
			System.out.print("KAC TANE BOLUM GIRECEKSINIZ------->");
			bs = scan.nextInt();
			
			Bolum [] bolumler = new Bolum[bs];
			
			for(int i =0;i<bs;i++)
			{
				System.out.print((i+1) +". BOLUM NUMARA GIRINIZ---->");
				bolNo = scan.nextInt();
				
				scan.nextLine();
				
				System.out.print((i+1) +". BOLUM ADI GIRINIZ----->");
				bolAd = scan.nextLine();
				
				bolumler[i] = new Bolum(bolNo,bolAd);
				
				System.out.println("-----------OGRENCI BILGILERI----------------");
				
				System.out.print("KAC LISANS OGRENCISI------->");
				ls = scan.nextInt();
				
				System.out.print("KAC YUKSEK LISANS OGRENCISI------->");
				yls = scan.nextInt();
				
				bolumler[i].ogrenciler = new Ogrenci[ls+yls];
				System.out.println("------------------------------------------------------");
				
				//LISAN OGRENCILERIN BILGILERI ALMAK
				
				for(int j =0;j<ls;j++)
				{   scan.nextLine();
					System.out.print((j+1)+ ". LISANS OGRENCININ ADI GIRINZ---->");
					ad = scan.nextLine();
					// scan.nextLine();
					System.out.print((j+1)+ ". LISANS OGRENCININ SOYADI GIRINZ---->");
					soyad = scan.nextLine();
					System.out.print((j+1)+ ". LISANS OGRENCININ SINIFI GIRINZ---->");
					sinif = scan.nextInt();
					
					bolumler[i].ogrenciler[j] = new LisansOgrencisi(bolNo, ad, soyad, sinif);
					System.out.println("------------------------------------------------------");

				}
				System.out.println("----------------------------------------------------------------------------------");
				
				//YUKSEK LISAN OGRENCILERIN BILGILERI ALMAK
				
				scan.nextLine();
				for(int k =ls;k<ls+yls;k++)
				{   
					System.out.print((k-ls+1)+ ". YUKSEK LISANS OGRENCININ ADI GIRINZ---->");
					ad = scan.nextLine();
					// scan.nextLine();
					System.out.print((k-ls+1)+ ". YUKSEK LISANS OGRENCININ SOYADI GIRINZ---->");
					soyad = scan.nextLine();
					
					bolumler[i].ogrenciler[k] = new YLOgrencisi(bolNo, ad, soyad);
					System.out.println("------------------------------------------------------");
				}
						
				
				System.out.println("-----------DERS BILGILERI----------------");
				
				System.out.print("KAC ADET DERS GIRECEKSINIZ----->");
				ds = scan.nextInt();
				
				derssayisi = derssayisi +ds;
				
				bolumler[i].dersler = new Ders[ds];
				
				/*
				   DERS BILGILERI ALMAK 
				 */
				
				for(int l=0;l<ds;l++)
				{    scan.nextLine();
					System.out.print((l+1) + ". DERSIN ADI GIRINIZ------> ");
					dersAdi = scan.nextLine();
					System.out.print((l+1) + ". DERSIN KREDISI GIRINIZ------> ");
					dersKredi = scan.nextInt();
					
					bolumler[i].dersler[l] = new Ders(bolNo, dersAdi, dersKredi);
					System.out.println("---------------------------------------------");
				}
				
			}
			
			krediler = new int[derssayisi];  // KREDI LISTESI
			
			int ekle =0;
			for(int i=0;i<bs;i++)
			{
				for(int j= 0;j<bolumler[i].dersler.length;j++)
				{
					dersKredi = bolumler[i].dersler[j].getDersKredi(); //********************** FARKLI KREDILER LISTEYE EKLEMEK**********************
					if(dizide(krediler, dersKredi) == 0)
					{
						krediler[ekle] = dersKredi;
						ekle++;
					}
								
				}			
			}
			
			//********************SIRALAMA**************************
			
			krediler = sirala(krediler);
			
			int secenek;
			
			while(true)  // SONSUZ DONGU
			{
				System.out.println();
				System.out.println("**********************************************");
				System.out.println("*                 MENU                       *");
				System.out.println("**********************************************");
				System.out.println();
				System.out.println("1- TUM BOLUMLERIN BILGILERINI LISTELE");
				System.out.println("2- LISANS OGRENCILERINI LISTELE");
				System.out.println("3- YUKSEK LISANS OGRENCILERINI LISTELE");
				System.out.println("4- DERSLERI LISTELE");
				System.out.println("5- ARAMA YAP");
				System.out.println("6- CIKIS");
				System.out.println();
				secenek = scan.nextInt();
				
				System.out.println("------------------------------------------------------------------");
				switch (secenek) {
			case 1:
			
					for(int i=0;i<bs;i++)
					{
		System.out.println("BOLUM NO: " + bolumler[i].getBolNo() + " BOLUM AD: " + bolumler[i].getBolAd());
		
		System.out.println("LISANS OGRENCILER:");
		
		for(int k=0;k<bolumler[i].ogrenciler.length;k++)
		{
			//LISAN ICIN
			
			
			if(bolumler[i].ogrenciler[k] instanceof LisansOgrencisi)
			{
				gecicilisans = (LisansOgrencisi) bolumler[i].ogrenciler[k];
				
	System.out.println("\t" +(k+1) +". OGRENCI: " + gecicilisans.getOgrID()+ " " + gecicilisans.getOgrAd()+ " "+ gecicilisans.getOgrSoyad()+ " " + gecicilisans.getOgrSinif());
	        
			}						
		}
		System.out.println("--------------------------------------------------------");
		
		System.out.println("YUKSEK LISANS OGRENCILER:");
		
		//YUKSEKLISANS ICIN
		 int count=0;  // YAZDIRMAK ICIN LISTE 1'DEN BASLAMAK ICIN 
		 
		for(int m=0;m<bolumler[i].ogrenciler.length;m++)
		{ 
			
			if(bolumler[i].ogrenciler[m] instanceof YLOgrencisi)
			{   count++;
				geciciyl = (YLOgrencisi) bolumler[i].ogrenciler[m];
				
	System.out.println("\t" + count +". OGRENCI: " + geciciyl.getOgrID()+ " " + geciciyl.getOgrAd()+ " "+ geciciyl.getOgrSoyad());
			}
			
		}
		
		System.out.println("----------------------------------------------------------------------");
		
		System.out.println("DERSLER: ");
		
		for(int j=0;j<bolumler[i].dersler.length;j++)
		   {
			   System.out.println("\t" +(j+1) +". Ders: " + bolumler[i].dersler[j].getDersID()+ " "+ bolumler[i].dersler[j].getDersAd() + " " +bolumler[i].dersler[j].getDersKredi() );
	      	}
		
		System.out.println("------------------------------------------------------------------");
					}
					break;
									
				case 2:
			System.out.println("TUM BOLUMLERDEKI LISANS OGRENCILER:");
			System.out.println("\t" +"1 SINIF OGRENCILER:");
			
					for(int i=0;i<bs;i++)
					{
						
						for(int j=0;j<bolumler[i].ogrenciler.length;j++)
						{
							if(bolumler[i].ogrenciler[j] instanceof LisansOgrencisi)
							{
								gecicilisans = (LisansOgrencisi) bolumler[i].ogrenciler[j];
								
								if(gecicilisans.getOgrSinif() == 1)
								{
									System.out.println("\t\t" +gecicilisans.getOgrID() + " "+ gecicilisans.getOgrAd() + " " + gecicilisans.getOgrSoyad());
								}
							}
						}
					}
					
					  System.out.println("\t" +"2 SINIF OGRENCILER;");
					 
					  for(int i=0;i<bs;i++)
						{
							
							for(int j=0;j<bolumler[i].ogrenciler.length;j++)
							{
								if(bolumler[i].ogrenciler[j] instanceof LisansOgrencisi)
								{
									gecicilisans = (LisansOgrencisi) bolumler[i].ogrenciler[j];
									
									if(gecicilisans.getOgrSinif() == 2)
									{
										System.out.println("\t\t" +gecicilisans.getOgrID() + " "+ gecicilisans.getOgrAd() + " " + gecicilisans.getOgrSoyad());
									}
								}
							}
						}
					  
					  System.out.println("\t" +"3 SINIF OGRENCILER:");
					  for(int i=0;i<bs;i++)
						{
							
							for(int j=0;j<bolumler[i].ogrenciler.length;j++)
							{
								if(bolumler[i].ogrenciler[j] instanceof LisansOgrencisi)
								{
									gecicilisans = (LisansOgrencisi) bolumler[i].ogrenciler[j];
									
									if(gecicilisans.getOgrSinif() == 3)
									{
										System.out.println("\t\t" +gecicilisans.getOgrID() + " "+ gecicilisans.getOgrAd() + " " + gecicilisans.getOgrSoyad());
									}
								}
							}
						}
					  System.out.println("\t" +"4 SINIF OGRENCILER:");
					  
					  for(int i=0;i<bs;i++)
						{
							
							for(int j=0;j<bolumler[i].ogrenciler.length;j++)
							{
								if(bolumler[i].ogrenciler[j] instanceof LisansOgrencisi)
								{
									gecicilisans = (LisansOgrencisi) bolumler[i].ogrenciler[j];
									
									if(gecicilisans.getOgrSinif() == 4)
									{
										System.out.println("\t\t" +gecicilisans.getOgrID() + " "+ gecicilisans.getOgrAd() + " " + gecicilisans.getOgrSoyad());
									}
								}
							}
						}
					  					  
					break;
				case 3:
					
					System.out.println("TUM BOLUMLERDEKI YUKSEK LISANS OGRENCILER:");
					
					for(int i=0;i<bs;i++)
					{
						for(int j=0;j<bolumler[i].ogrenciler.length;j++)
						{
							if(bolumler[i].ogrenciler[j] instanceof YLOgrencisi)
							{
								geciciyl = (YLOgrencisi) bolumler[i].ogrenciler[j];
			System.out.println("\t" + "ID: " +geciciyl.getOgrID() +" AD: "+ geciciyl.getOgrAd()+" SOYAD: "+ geciciyl.getOgrSoyad() );
							}
						}
					}
									
					break;
					
					//***************************ONEMLI NOKTA !!!******************************
					
				case 4:        
					System.out.println("TUM BOLUMLERDEKI DERSLER:");
					for(int i=0;i<ekle;i++)
					{
						System.out.println("\t" + krediler[i]+ " KREDILIK DERSLER:");
						
						for(int j=0;j<bs;j++)
						{
							for(int k=0;k<bolumler[j].dersler.length;k++)
							{
								if(krediler[i] == bolumler[j].dersler[k].getDersKredi())
								{
					System.out.println("\t\t" + "DERS KODU: " + bolumler[j].dersler[k].getDersID() + " DERS ADI: " + bolumler[j].dersler[k].getDersAd());
									
								}
							}
						}
						System.out.println("");
					}					
					
					break;
					
				case 5:
					String kelime;
				int kontrol =0; // **** KELIMENIN BULUNUP BULUNMADIGINI KONTROLU 
				 scan.nextLine();
				System.out.print("ARAMAK ISTEDIGINIZ KELIME YAZINIZ------>");
				 
				kelime = scan.nextLine();
				
				//**** OGRENCILER ICINDE KONTROL************************************************************
				
				for(int i=0;i<bs;i++)
				{
					for(int j=0;j<bolumler[i].ogrenciler.length;j++)
					{
			if(kelime.equals(bolumler[i].ogrenciler[j].getOgrAd()) || kelime.equals(bolumler[i].ogrenciler[j].getOgrSoyad()))
			{
				if(bolumler[i].ogrenciler[j] instanceof LisansOgrencisi)
				{
					gecicilisans = (LisansOgrencisi) bolumler[i].ogrenciler[j];
System.out.println("BOLUM: "+bolumler[i].getBolAd()+" ID: "+ gecicilisans.getOgrID()+" AD: "+bolumler[i].ogrenciler[j].getOgrAd()+" SOYAD: "+bolumler[i].ogrenciler[j].getOgrSoyad()+" SINIF: "+gecicilisans.getOgrSinif());
					
				}
				
				else
				{  geciciyl = (YLOgrencisi) bolumler[i].ogrenciler[j];
				
				System.out.println("BOLUM: "+bolumler[i].getBolAd()+" ID: "+ geciciyl.getOgrID()+" AD: "+bolumler[i].ogrenciler[j].getOgrAd()+" SOYAD: "+bolumler[i].ogrenciler[j].getOgrSoyad());
				
				}
		kontrol =1;
			}
					}
					
				}
							//**** DERSLER ICINDE KONTROL ETME*******************************************
				
				for(int i=0;i<bs;i++)
				{
					for(int j=0;j<bolumler[i].dersler.length;j++)
					{
						if(kelime.equals(bolumler[i].dersler[j].getDersAd()))
						{
System.out.println("BOLUM: "+bolumler[i].getBolAd() + " DERS KODU: "+bolumler[i].dersler[j].getDersID()+" DERS ADI: "+bolumler[i].dersler[j].getDersAd()+" KREDI: " +bolumler[i].dersler[j].getDersKredi() );
		kontrol =1;
						}
					}
				}
				
				if(kontrol == 0) 
				{
					System.out.println("ARADIGINIZ KELIME BULUNMAMAKTADIR");
				}
									
					break;
				case 6:
					System.exit(0);
					
					default:
						System.out.println("YANLIS ISLEM SECTINIZ LUTFEN TEKRAR EDINIZ !!!");
						break;		
				}				
			}
		}
	}
	
	// BIR SAYI BIR INT DIZISINDE BULUP BULUNMADIGINI KONTROL EDEN METOD
	
	public static int dizide(int []dizi,int aranan) 
	{
		for(int i=0;i<dizi.length;i++)
		{
			if(dizi[i]==aranan)
			{
				return 1;
			}
			
		}	
		
		return 0;
	}
	
	// BIR DIZI SIRALAYAN VE SIRALI DIZI DONDUREN FONKSIYONU NOT: BUBBLE SORT ALGORITMASINI KULLANILACAK
	
			public static int [] sirala(int []dizi)
			{ int temp;
				for(int i=0;i<dizi.length;i++)
				{
					for(int j=0;j<dizi.length-i-1;j++)
					{
						if(dizi[j]>dizi[j+1])
						{
							temp = dizi[j];
							dizi[j] =dizi[j+1];
							dizi[j+1] = temp;
						}
					}
				}
				
				return dizi;
						
			}
}
