
//MAMADY CHEICK SOUARE 20100011002 

package NYP_paket;

public class Ders {
	
	private static int sayac=10;
	private int bolNo;
	private int dersID;
	private String dersAd;
	private int dersKredi;

	//CONSTRUCTOR METHODS
	public Ders(int bolNo, String dersAd, int dersKredi) {
		super();
		this.bolNo = bolNo;
		this.dersID = Ders.sayac++;
		this.dersAd = dersAd;
		this.dersKredi = dersKredi;
	}
	
	//SETTER GETTER METHODS

	public static int getSayac() {
		return sayac;
	}

	public static void setSayac(int sayac) {
		Ders.sayac = sayac;
	}

	public int getBolNo() {
		return bolNo;
	}

	public void setBolNo(int bolNo) {
		this.bolNo = bolNo;
	}

	public int getDersID() {
		return dersID;
	}

	

	public String getDersAd() {
		return dersAd;
	}

	public void setDersAd(String dersAd) {
		this.dersAd = dersAd;
	}

	public int getDersKredi() {
		return dersKredi;
	}

	public void setDersKredi(int dersKredi) {
		this.dersKredi = dersKredi;
	}
	
	
	
}
