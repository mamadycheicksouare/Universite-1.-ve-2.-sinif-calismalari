
//MAMADY CHEICK SOUARE 20100011002 

package NYP_paket;

public class YLOgrencisi extends Ogrenci{
	
	private static int sayac=49;
	private int ogrID;
	private String durum;
	
	
	//CONSTRUCTOR METHODS 
	
	public YLOgrencisi(int bolNo, String ogrAd, String ogrSoyad) {
		super(bolNo, ogrAd, ogrSoyad);
		this.ogrID = YLOgrencisi.sayac++;
		this.durum = "Yuksek Lisans";
	}

	//SETTER GETTER  METHODS
	public int getOgrID() {
		return ogrID;
	}

	

	public String getDurum() {
		return durum;
	}

	public void setDurum(String durum) {
		this.durum = durum;
	}

	
	
	

}
