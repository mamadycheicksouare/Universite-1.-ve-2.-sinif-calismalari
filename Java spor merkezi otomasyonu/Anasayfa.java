//MAMADY CHEİCK SOUARE 20100011002

package NYP_paket_odev2;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Anasayfa {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		
		//-------------KULLANACAGIMIZ GECICI DEGISKENLER----------------------
		//KURS ICIN
		
		int Kid;
		String Kad;
		 
		//KURSIYER ICIN
		
		int id=0;
		String ad_soyad="";
		int yas;
		
		
		// OKUMA ISLEMI ICIN 
		
		String satir="";            // DOSYANIN HER SATITI ICIN
		
		
		//------------------------------ARRAYLISTLER OLUSTURMA ----------------------------------
		
		ArrayList<Kursiyer> Kursiyerler = new ArrayList<Kursiyer>();
		
		ArrayList<Kurs> Kurslar = new ArrayList<Kurs>();
		
		
		//------------------ONCE KURSLERI DOSYADAN OKUYALIM VE LISTEYE EKLEYELIM--------------------------------------
		
		File kursfile = new File("kurs.txt");
		
		FileReader fr = new FileReader(kursfile);
		BufferedReader br = new BufferedReader(fr);
		String[] tokens = new String[2];
		while(br.ready())
		{ 
			satir = br.readLine();
			
			 tokens = satir.split("\\+");
			
			
				Kid = Integer.parseInt(tokens[0]);
			
				Kad = tokens[1];
			
			Kurslar.add(new Kurs(Kid,Kad));	
			
		}
		fr.close();
			
		// -----------------KURSIYERLER DOSYADAN OKUYUP LISTEYE EKLEYELIM ------------------------------------
	
		File kursiyerfile = new File("kursiyer.txt");
		fr = new FileReader(kursiyerfile);
		br = new BufferedReader(fr);
		
		Kursiyer  eklenen = new Kursiyer(0, null, 0);
		while(br.ready())
		{  
			satir = br.readLine();
			
			if(satir.startsWith("*"))
			{
				tokens = satir.split("\\+");
				id = Integer.parseInt(tokens[0].replace("*", ""));
				ad_soyad = tokens[1];
				yas = Integer.parseInt(tokens[2]);
				
				eklenen = new Kursiyer(id, ad_soyad, yas);
				
				Kursiyerler.add(eklenen);		
				}
			
			else {
				
			    tokens = satir.split("\\+");
			    Kid = Integer.parseInt(tokens[0].replace("%", ""));
			    Kad = tokens[1];
			    
			    Kursiyerler.get(Kursiyerler.size()-1).alinanKurslar.add(new Kurs(Kid,Kad));
			}
		}
		fr.close();
		br.close();
	
		//----------------------------EKLEME ISLEMI BITTI----------------------------------------
	
//---------------------------------------------MENU----------------------------------------------
		Scanner scan = new Scanner(System.in);
		int sec;
		while(true)
		{
			System.out.println("****************************************************************************");
	System.out.println("1- KURS EKLE\n2- KURS LISTELE\n3- KURS ARA\n4- KURS SIL\n5- KURSIYER EKLE\n6- KURSIYER ARA\n7- KURSIYER SIL\n8- KURSIYERLERI LISTELE\n9- KURSIYERLERI AYRINTILI LISTELE\n10- KURSIYERIN ODEYECEGI TUTARI HESAPLA\n11- CIKIS\n");
	       sec = scan.nextInt();
	       
	       // HER ISLEM YAPARKEN VAZGECMEK VE ANA MENUYE GECMEK MUMKUN 
	       
	  switch (sec)
	  {
	  case 1:
		  System.out.println("EKLEMEK ISTEDIGINIZ KURSUN ID GIRINIZ----->");
		  System.out.println("ANA MENUYE GECMEK ICIN 0 BASINIZ----->");
		  Kid = scan.nextInt();
		  
		  if(Kid ==0)
		  {
			  break;
		  }
		  	  
		  while(idvar(Kurslar,Kid) == 1)
		  {
			  System.out.println("BU KURS ID VAR ZATEN  YENI BIR ID GIRINIZ----->");
			  System.out.println("ANA MENUYE GECMEK ICIN 0 BASINIZ----->");
			  Kid = scan.nextInt();
			  
			  if(Kid ==0)
			  {
				  break;
			  }
		  }
		  if(Kid ==0)
		  {
			  break;
		  }
		  
		  scan.nextLine();
		  System.out.println("EKLEMEK ISTEDIGINIZ KURSUN AD GIRINIZ----->");
		  System.out.println("ANA MENUYE GECMEK ICIN 0 BASINIZ------>");
		  Kad = scan.nextLine();
		  if(Kad.equals("0"))
		  {
			  break;
		  }
		  KursEkle(Kurslar, Kid, Kad);
		  
		  break;
	  case 2:
		  KursListele(Kurslar);
		  
		  break;
	  case 3:
		  System.out.println("ARAMAK ISTEDIGINIZ KURSUN ADI GIRINIZ----> ");
		  System.out.println("ANA MENUYE GECMEK ICIN 0 BASINIZ------>");
		  scan.nextLine();
		  Kad = scan.nextLine();
		  if(Kad.equals("0"))
		  {
			  break;
		  }
		  
		  KursAra(Kurslar, Kad);
		  
		  break;
	  case 4:
		 
		  System.out.println("SILMEK ISTEDIGINIZ KURSUN ADI GIRINIZ------>");
		  System.out.println("ANA MENUYE GECMEK ICIN 0 BASINIZ------->");
		  scan.nextLine();
		  Kad = scan.nextLine();
		  
		  
		  if(Kad.equals("0"))
		  {
			  break;
		  }
		  
		  
		  Iterator<Kursiyer> iter = Kursiyerler.iterator();
		  
		 int kontrol =0;
		  while(iter.hasNext())
			{ 
				Kursiyer kursiyer = iter.next();
				
				Iterator<Kurs> iterkurs = kursiyer.alinanKurslar.iterator();
				
				while(iterkurs.hasNext())
				{
					Kurs kurs = iterkurs.next();
					
					if(kurs.getKursAd().equals(Kad))
					{
						kontrol = 1;
						break;
					}
				}
				
				if(kontrol == 1)
				{
					break;
				}
				
			}
		  if(kontrol == 1)
			{   System.out.println("SILMEK ISTEDIGINIZ KURSU ALAN KURSIYER VAR  !!!");
				break;
			}
		  
		  
		  KursSil(Kurslar, Kad); 
		  break;
	  case 5:
		  
		  
		  System.out.println("EKLEMEK ISTEDIGINIZ KURSIYERIN ID GIRINIZ----->");
		  System.out.println("ANA MENUYE GECMEK ICIN 0 BASINIZ----->");
		  Kid = scan.nextInt();
		  
		  if(Kid ==0)
		  {
			  break;
		  }
		  
		  while (Kursiyeridvar( Kursiyerler, Kid) ==1)
		  {
			  System.out.println("BU KURSIYERIN ID VAR ZATEN  YENI BIR ID GIRINIZ----->");
			  System.out.println("ANA MENUYE GECMEK ICIN 0 BASINIZ----->");
			  Kid = scan.nextInt();
			  
			  if(Kid ==0)
			  {
				  break;
			  }
			  
		  }
		  if(Kid ==0)
		  {
			  break;
		  }
		  scan.nextLine();
		  System.out.println("EKLEMEK ISTEDIGINIZ KURSIYERIN AD_SOYAD GIRINIZ----->");
		  System.out.println("ANA MENUYE GECMEK ICIN 0 BASINIZ------>");
		  Kad = scan.nextLine();
		  if(Kad.equals("0"))
		  {
			  break;
		  }
		  
		  System.out.println("EKLEMEK ISTEDIGINIZ KURSIYERIN YASI GIRINIZ----->");
		  System.out.println("ANA MENUYE GECMEK ICIN 0 BASINIZ------>");
		  yas = scan.nextInt();
		  if(yas == 0)
		  {
			  break;
		  }
		  
		  ArrayList<Kurs> alinanKurslar1 = new ArrayList<>();  // HER KURSIYERIN ALDIGI KURSLARI ICIN 
		  
		   //------------alinan kurslar-------------------------
		  
		  System.out.println("MEVCUT KURSLAR\n------------------------------------ \n");
		   KursListele(Kurslar);
		
		 
		  System.out.println("EKLEMEK ISTEDIGINIZ KURSUN ID GIRINIZ----->");
		  int eklenenKursId1 = scan.nextInt();
		  
		  String _ad = "";
		  
		  while(idvar(alinanKurslar1,eklenenKursId1) == 1 || idvar(Kurslar,eklenenKursId1)==0 )
		  {
			  System.out.println("BU IDLI KURS EKLENEMEZ BASKA IDLI KURS GIRINIZ----->");
			  
			  eklenenKursId1 = scan.nextInt();
		  }
		  
		  for(Kurs kurs: Kurslar)
			{
				if(kurs.getKursId() == eklenenKursId1)
				{
					_ad = kurs.getKursAd();
					break;
				}
			}
		 		   
		  KursEkle(alinanKurslar1,eklenenKursId1, _ad);	         	// EN AZ BIR KURS OLACAK SEKLINDE   
		  //---------------------------------------------------------------------------------
		  
		  
		  int eklenenKursId = -1;
		  while(eklenenKursId != 0)                                // DAHA FAZLA KURS OLACAKSA 
		  {
			  
			  System.out.println("MEVCUT KURSLAR\n------------------------------------ \n");
			   KursListele(Kurslar);
			   
			   System.out.println("EKLEMEK ISTEDIGINIZ KURSUN ID GIRINIZ----->");
				  System.out.println("KURS EKLEME BITTIYSE ICIN 0 BASINIZ----->");
				  eklenenKursId = scan.nextInt();
				  
				  if(eklenenKursId ==0)
				  {
					  break;
				  }
				  
				
				  
				  while(idvar(alinanKurslar1,eklenenKursId) == 1 || idvar(Kurslar,eklenenKursId)==0 )  
				  {
					  System.out.println("BU IDLI KURS EKLENEMEZ BASKA IDLI KURS GIRINIZ----->");
					  System.out.println("KURS EKLEME BITTIYSE ICIN 0 BASINIZ----->");
					  eklenenKursId = scan.nextInt();
					  
					  if(eklenenKursId ==0)
					  {
						  break;
					  }
				  }
				  if(eklenenKursId ==0)
				  {
					  break;
				  }
				  //--------------------------------------------------------------------------------
				  
				  for(Kurs kurs: Kurslar)
					{
						if(kurs.getKursId() == eklenenKursId)
						{
							ad_soyad = kurs.getKursAd();
							break;
						}
					}
				 		   
				  KursEkle(alinanKurslar1,eklenenKursId, ad_soyad);		   	  
		  }
		  	     
		  KursiyerEkle(Kursiyerler, Kid, Kad, yas, alinanKurslar1);
		  System.out.println("KURSIYER BASARLI BIR SEKILDE EKLENDI!!!");
		  
		  break;
	  case 6:
		  
		  System.out.println("ARAMAK ISTEDIGINIZ KURSIYERIN ADI SOYADI GIRINIZ---->");
		  System.out.println("ANA MENUYE GECMEK ICIN 0 BASINIZ------>");
		  scan.nextLine();
		  Kad = scan.nextLine();
		  
		  
		  if(Kad.equals("0"))
		  {
			  break;
		  }
		  
		  System.out.println("-----------------------------------------------------");
		  KursiyerAra( Kursiyerler,Kad);
		  System.out.println("-----------------------------------------------------");
		  break;
	  case 7:
		  System.out.println("SILMEK ISTEDIGINIZ KURSIYERIN ID GIRINIZ------>");
		  System.out.println("ANA MENUYE GECMEK ICIN 0 BASINIZ----->");
		  Kid = scan.nextInt();
		  
		  if(Kid ==0)
		  {
			  break;
		  }
		  
		  
		  KursiyerSil( Kursiyerler, Kid);
		  
		  System.out.println("-----------------------------------------------------");
		  break;
	  case 8:
		  KursiyerListele( Kursiyerler);
		  System.out.println("-----------------------------------------------------");
		  break;
	  case 9:
		  KursiyerAyrintiliListele( Kursiyerler);
		  System.out.println("-----------------------------------------------------");
		  break;
	  case 10:
		  
		  
           System.out.println("HANGI IDLI KURSIYERIN ODEYECEYI TUTAR HESAPLAMAK ISTIYORSUNUZ----->");
           System.out.println("ANA MENUYE GECMEK ICIN 0 BASINIZ----->");
           Kid = scan.nextInt();
 
            if(Kid ==0)
              {
	              break;
              }
		  
		  KursiyerinOdeyecegiTutarHesapla( Kursiyerler, Kid);
		  System.out.println("-----------------------------------------------------");
		  break;
	  case 11:   
		  System.out.println("CIKIS ONAYLAMAK ICIN 0 BASINIZ DEVAM ETMEK ICIN BASKA NUMARA BASINIZ------>");
		 int onay = scan.nextInt();
		 
		 if(onay!= 0)
		 {
			 break;
		 }
		 
		 KursdosyaYaz( Kurslar,"kurs.txt");
		  
		  //------------------------
		  
		  KursiyerdosyaYaz( Kursiyerler,"kursiyer.txt");
		  
		  
		  System.out.println("CIKIS YAPILIYOR ......");
		  scan.close();
		  System.exit(0);
		  break;
	  default :
		  System.out.println("YANLIS ISLEM SECTINIZ LUTFEN TEKRAR EDINIZ !!!");
		  break;
	  }
	
		}
	}
	
	//---------------------------DIGER METOTLAR YAZALIM BURADA!!!---------------------------------
	
	//---------------------------KursListele METODU----------------------------2-----------------
	
	public static void KursListele(ArrayList<Kurs> Kurslar)
	{if(Kurslar.size() ==0)
	{
		System.out.println("HICBIR KURS YOK !!!");
		return;
	}
		System.out.println("Kurs ID\t\t" + "Kurs Adi\n");
		
	System.out.println("-------------------------------------------------------------------");
		for(Kurs kurs:Kurslar)
		{
			System.out.println( kurs.getKursId() +"\t\t" + kurs.getKursAd() );
		}
		
	}
	//---------------------------KURSIYELERI LISTLE----------------------------8------------
	public static void KursiyerListele(ArrayList<Kursiyer> Kursiyerler)
	{
		if(Kursiyerler.size() ==0)
		{
			System.out.println("HICBIR KURSIYER YOK!!!");
			return;
		}
		System.out.println("*****************************************************");
		System.out.println("Tum\tKursiyerler\n");
		System.out.println("-------------------------------------------------------------------");
		for(Kursiyer kursiyer:Kursiyerler)
		{
		System.out.println(kursiyer.getKursiyerId() +"\t" + kursiyer.getKursiyerAdSoyad()+"\t" +kursiyer.getKursiyerYas());
		}
		
		System.out.println("*****************************************************");
		
	}
	
	//---------------------------KURSIYELERI AYRINTILI LISTLE------------------9-----------------
	
	
	
	public static void KursiyerAyrintiliListele(ArrayList<Kursiyer> Kursiyerler)
	{
		if(Kursiyerler.size() ==0)
		{
			System.out.println("HICBIR KURSIYER YOK!!!");
			return;
		}
		System.out.println("*****************************************************");
		System.out.println("Tum Kursiyerler ve Aldiklari Kurslar\n");
		System.out.println("-------------------------------------------------------------------");
		for(Kursiyer kursiyer:Kursiyerler)
		{
		System.out.println(kursiyer.getKursiyerId() +"\t" + kursiyer.getKursiyerAdSoyad()+"\t" +kursiyer.getKursiyerYas());
		     
		for(Kurs kurs : kursiyer.alinanKurslar)
		{
			System.out.println("\t"+ kurs.getKursId() +" " + kurs.getKursAd() ); 			
		}
		}
		
		System.out.println("*****************************************************");
		
	}
	//-------------------------------KURS EKLE---------------------------------1---------------
	
	public static int idvar(ArrayList<Kurs> Kurslar,int id) 
	{
		int size = Kurslar.size();
		for(Kurs kurs: Kurslar)
		{
			if(kurs.getKursId() == id && size>0)
			{
				return 1;
			}
		}
		return 0;
	}
	
	
	public static void KursEkle(ArrayList<Kurs> Kurslar,int id,String ad)
	{ 
		Kurslar.add(new Kurs(id,ad));
		System.out.println("KURS BASARILI BIR SEKILDE EKLENDI !!!\n");
		
	}
	
	//-----------------------------KURS ARA------------------------------------3--------------
	
	public static void KursAra(ArrayList<Kurs> Kurslar,String ad) 
	{ 
		
		if(Kurslar.size() ==0)
	{
		System.out.println("HICBIR KURS YOK (^_^)!!!");
		return;
	}
		int kontrol=0;
		for(Kurs kurs: Kurslar)
		{
			if(kurs.getKursAd().equals(ad))
			{
				System.out.println( kurs.getKursId() +" " + kurs.getKursAd() );
				kontrol =1;
				break;
				
			}
		}
		
		if(kontrol == 0)
		{
			System.out.println("ARADIGINIZ KURS BULUNMAMAKTADIR !!!");
		}
	}
		
	//------------------------------KURS SIL-----------------------------------4--------------
	
	
	public static void KursSil(ArrayList<Kurs> Kurslar,String ad) 
	
	{  
		if(Kurslar.size() ==0)
		{
			System.out.println("HICBIR KURS YOK !!!");
			return;
		}
		int kontrol=0;
		Iterator<Kurs> iter = Kurslar.iterator();
		while(iter.hasNext())
		{ 
			Kurs kurs = iter.next();
			if(kurs.getKursAd().equals(ad))
			{
				iter.remove();
				kontrol =1;
				System.out.println("SILME ISLEMI BASARILI BIR SEKILDE YAPILDI !!!");
				
				break;  //ONEMLI!!! CUNKU TEKRARLI KURS ID OLMADIGINI KABUL EDIYORUZ!!!
			}
		}
		
		if(kontrol ==0)
		{
			System.out.println("SILMEK ISTEDIGINIZ KURS SILEMEZSINIZ CUNKU YOK  !!!");
		}	
		
	}
	//-------------------------KURSIYER EKLE-------------------------------------5------------------
	
	public static int Kursiyeridvar(ArrayList<Kursiyer> Kursiyerler,int id)
	{ 
		int size = Kursiyerler.size();
		
		for(Kursiyer kursiyer: Kursiyerler)
		{
			if(kursiyer.getKursiyerId() == id && size>0)
			{
				return 1;
			}
		}
		return 0;
	}
	
	//---------------------------------------------
	public static void KursiyerEkle(ArrayList<Kursiyer> Kursiyerler,int kursiyerId, String kursiyerAdSoyad, int kursiyerYas,ArrayList<Kurs> Kurslar ) 
	{
		Kursiyer eklenen = new Kursiyer( kursiyerId, kursiyerAdSoyad, kursiyerYas) ;
		eklenen.alinanKurslar = Kurslar;
		Kursiyerler.add(eklenen);	
	}
	
	//-------------------------KURSIYER ARA--------------------------------------6-----------------
	
	public static void KursiyerAra(ArrayList<Kursiyer> Kursiyerler,String ad)
	{
		if(Kursiyerler.size() == 0)
		{
			System.out.println("LISTE BOS KURSIYER BULUNMAMAKTADIR");
			return;
		}
		int kontrol=0;
		Iterator<Kursiyer> iter = Kursiyerler.iterator();
		while(iter.hasNext())
		{ 
			Kursiyer kursiyer = iter.next();
			if(kursiyer.getKursiyerAdSoyad().equals(ad))
			{
				System.out.println(kursiyer.getKursiyerId() +"\t" + kursiyer.getKursiyerAdSoyad()+"\t" +kursiyer.getKursiyerYas());
			     
				for(Kurs kurs : kursiyer.alinanKurslar)
				{
					System.out.println("\t"+ kurs.getKursId() +" " + kurs.getKursAd() );
					
				}
				kontrol = 1;
				break;                    //ONEMLI!!! CUNKU TEKRARLI KURS ID OLMADIGINI KABUL EDIYORUZ!!!
			}
		}
		
		if(kontrol ==0)
		{
			System.out.println("ARADIGINIZ ISIM BULUNMAMAKTADIR  !!!");
		}
		
	}
	
	//-------------------------KURSIYER SIL--------------------------------------7----------------
	public static void KursiyerSil(ArrayList<Kursiyer> Kursiyerler,int id)
	{
		
		if(Kursiyerler.size() == 0)
		{
			System.out.println("LISTE BOS KURSIYER BULUNMAMAKTADIR");
			return;
		}
		
		int kontrol=0;
		Iterator<Kursiyer> iter = Kursiyerler.iterator();
		
		while(iter.hasNext())
		{ 
			Kursiyer kursiyer = iter.next();
			if(kursiyer.getKursiyerId() == id)
			{
				
				iter.remove();
				kontrol = 1;
				
				System.out.println("KURSIYER BASARILI BIR SEKILDE SILINDI!!!");
				
				break; // //ONEMLI!!! CUNKU TEKRARLI KURSIYER ID OLMADIGINI KABUL EDIYORUZ!!!
			}
		}
		
		if(kontrol ==0)
		{
			System.out.println("SILMEK ISTEDIGINIZ KURSIYER BULUNMAMAKTADIR  !!!");
		}
		
	}
		
	//-------------------------TUTAR HESAPLA-------------------------------------10----------------
       
	public static void KursiyerinOdeyecegiTutarHesapla(ArrayList<Kursiyer> Kursiyerler,int id)
	{
		if(Kursiyerler.size() == 0)
		{
			System.out.println("LISTE BOS KURSIYER BULUNMAMAKTADIR");
			return;
		}
		
		int kontrol=0;
		Iterator<Kursiyer> iter = Kursiyerler.iterator();
		
		while(iter.hasNext())
		{ 
			Kursiyer kursiyer = iter.next();
			if(kursiyer.getKursiyerId() == id)
			{
				kursiyer.BorcHesapla();
				
				kontrol = 1;
					
				break; // //ONEMLI!!! CUNKU TEKRARLI KURSIYER ID OLMADIGINI KABUL EDIYORUZ!!!
			}
		}
		
		if(kontrol ==0)
		{
			System.out.println("BU KURSIYER BULUNMAMAKTADIR  !!!");
		}
	}
	
	
	//------------------------- DOSYA YA TEKRAR YAZ VE CIKIS YAP-----------------11----------------
	  public static void KursdosyaYaz(ArrayList<Kurs> Kurslar,String dosyaAd) throws IOException
	  {
		  if(Kurslar.size()==0)
		  {
			  return;
		  }
		 
		 try( FileWriter fw = new FileWriter(dosyaAd);
		  BufferedWriter bw = new BufferedWriter(fw);){
			 
			 String satir;
			  
			  for(Kurs kurs :Kurslar)
			  {
				  satir = "" +kurs.getKursId() + "+" + kurs.getKursAd();
				  bw.write(satir);
				  bw.newLine();
				  //----Write 
			  }
		 }
		 catch (IOException e) {
		        e.printStackTrace(); 
		    }	  
	  }
	   
	 //---------------------------------------------------------------------------------------------------------------------------------
	  
	  public static void KursiyerdosyaYaz(ArrayList<Kursiyer> Kursiyerler,String dosyaAd) throws IOException
	  {
		  if(Kursiyerler.size()==0)
		  {
			  return;
		  }
		  try (FileWriter fw = new FileWriter(dosyaAd);
			         BufferedWriter bw = new BufferedWriter(fw)) {

			        String satir, kurssatir;

			        for (Kursiyer kursiyer : Kursiyerler) {
			            satir = "*" + kursiyer.getKursiyerId() + "+" + kursiyer.getKursiyerAdSoyad() + "+" + kursiyer.getKursiyerYas();
			            bw.write(satir);
			            bw.newLine();

			            for (Kurs kurs : kursiyer.alinanKurslar) {
			                kurssatir = "%" + kurs.getKursId() + "+" + kurs.getKursAd();
			                bw.write(kurssatir);
			                bw.newLine();
			            }
			        }

			    } catch (IOException e) {
			        e.printStackTrace(); 
			    }		 
	  }
	                                                                                               
	  //                                                                                                     (^_^)
	  //                                                                                                     /   \

	  
}