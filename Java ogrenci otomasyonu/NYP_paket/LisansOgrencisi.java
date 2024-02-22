
//MAMADY CHEICK SOUARE 20100011002 

package NYP_paket;

public class LisansOgrencisi extends Ogrenci {
	
	private static int sayac =19;
	private int ogrID;
	private int ogrSinif;
	private String durum;
	
	
	//CONSTRUCTOR METHODS
	public LisansOgrencisi(int bolNo, String ogrAd, String ogrSoyad, int ogrSinif) {
		super(bolNo, ogrAd, ogrSoyad);
		this.ogrID = LisansOgrencisi.sayac++;
		this.ogrSinif = ogrSinif;
		this.durum = "Lisans";
	}
	
	
	//SETTER GETTER METHODS
	
	public int getOgrID() {
		return ogrID;
	}
	
	
	public int getOgrSinif() {
		return ogrSinif;
	}
	public void setOgrSinif(int ogrSinif) {
		this.ogrSinif = ogrSinif;
	}
	public String getDurum() {
		return durum;
	}
	public void setDurum(String durum) {
		this.durum = durum;
	}
	
	
	
	
	

}
