
//MAMADY CHEICK SOUARE 20100011002 

package NYP_paket;

public class Bolum {
	
	private int bolNo;
	private String bolAd;
	public Ogrenci[] ogrenciler;
	public Ders[] dersler;
	
	//CONSTRUCTOR METHODS
	public Bolum(int bolNo, String bolAd) {
		super();
		this.bolNo = bolNo;
		this.bolAd = bolAd;
	}

	
	//SETTER GETTER METHODS
	public int getBolNo() {
		return bolNo;
	}

	public void setBolNo(int bolNo) {
		this.bolNo = bolNo;
	}

	public String getBolAd() {
		return bolAd;
	}

	public void setBolAd(String bolAd) {
		this.bolAd = bolAd;
	}

	public Ogrenci[] getOgrenciler() {
		return ogrenciler;
	}

	public void setOgrenciler(Ogrenci[] ogrenciler) {
		this.ogrenciler = ogrenciler;
	}

	public Ders[] getDersler() {
		return dersler;
	}

	public void setDersler(Ders[] dersler) {
		this.dersler = dersler;
	}
	
	
	

}
