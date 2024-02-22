//MAMADY CHEİCK SOUARE 20100011002

package NYP_paket_odev2;

import java.util.ArrayList;

public class Kursiyer implements Hesaplama {

	private int KursiyerId;
	private String KursiyerAdSoyad;
	private int KursiyerYas;
	public ArrayList<Kurs> alinanKurslar;
	
	//-----------------------------------------------------------
	
	public Kursiyer(int kursiyerId, String kursiyerAdSoyad, int kursiyerYas) {
		super();
		KursiyerId = kursiyerId;
		KursiyerAdSoyad = kursiyerAdSoyad;
		KursiyerYas = kursiyerYas;
		alinanKurslar = new ArrayList<Kurs>();
		
	}
	
	//--------------------------------------
	@Override
	public  void BorcHesapla()
	{   String kampanyamesaj="" ;
	    double toplam=0.0;
		int size = (alinanKurslar != null) ? alinanKurslar.size() : 0;
		
		
		
		 if(size == 1)
		{  
			toplam = (double) 500*4;
			kampanyamesaj = "Tek kurs alan kursiyerler icin kampanya yoktur!!!";
		}
		
		else if(size == 2)
		{
			toplam = (double) 500*4 + 500*4 -500*4*0.2;
			kampanyamesaj = "Kampanya 1 den faydanaliyor!!! ikinci kurs 20% indirimli ";
		}
		
		else if(size ==3)
		{
			toplam = (double) 2*500*4 + 500*4 -500*4*0.25;
	kampanyamesaj = "Kampanya 2 den faydanaliyor!!! ucuncu kurs 25% indirimli ";
		}
		
		else if(size >3)
		{
			toplam = (double) 500*4*size - 500*4*size*0.1;
	kampanyamesaj = "Kampanya 3 den faydanaliyor!!! her kurs 10% indirimli  ";
		}
		
		System.out.println(kampanyamesaj);
		System.out.println("Aylik odenmesi gereken------> " + toplam + " TL");
	}
	
	//-----------------------------------------------------
	public int getKursiyerId() {
		return KursiyerId;
	}
	
	public void setKursiyerId(int kursiyerId) {
		KursiyerId = kursiyerId;
	}
	public String getKursiyerAdSoyad() {
		return KursiyerAdSoyad;
	}
	public void setKursiyerAdSoyad(String kursiyerAdSoyad) {
		KursiyerAdSoyad = kursiyerAdSoyad;
	}
	public int getKursiyerYas() {
		return KursiyerYas;
	}
	public void setKursiyerYas(int kursiyerYas) {
		KursiyerYas = kursiyerYas;
	}
	public ArrayList<Kurs> getAlinanKurslar() {
		return alinanKurslar;
	}
	public void setAlinanKurslar(ArrayList<Kurs> alinanKurslar) {
		this.alinanKurslar = alinanKurslar;
	}
}
