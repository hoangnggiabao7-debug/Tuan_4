package Tuan3_Bai8;
/** 
 * Bai tap tuan 3 , bai 8, masv : 25671021 hoten: Hoang Nguyen Gia Bao
 */
public class CD {
	private String maCD;
	private String tuaCD;
	private String caSy;
	private int soBaiHat;
	private float gia;
	// dong goi va rang buoc
	
	/**
	 * @return the maCD
	 */
	public String getMaCD() {
		return maCD;
	}
	/**
	 * @param maCD the maCD to set
	 */
	public void setMaCD(String maCD) {
		this.maCD = maCD;
	}
	/**
	 * @return the tuaCD
	 */
	public String getTuaCD() {
		return tuaCD;
	}
	/**
	 * @param tuaCD the tuaCD to set
	 */
	public void setTuaCD(String tuaCD) {
		this.tuaCD = tuaCD;
	}
	/**
	 * @return the caSy
	 */
	public String getCaSy() {
		return caSy;
	}
	/**
	 * @param caSy the caSy to set
	 */
	public void setCaSy(String caSy) {
		this.caSy = caSy;
	}
	/**
	 * @return the soBaiHat
	 */
	public int getSoBaiHat() {
		return soBaiHat;
	}
	/**
	 * @param soBaiHat the soBaiHat to set
	 * @throws Exception
	 */
	public void setSoBaiHat(int soBaiHat) throws Exception {
		if (soBaiHat > 0) {
			this.soBaiHat = soBaiHat;
		}
		else {
			throw new Exception("so bai hat lon hon 0");
		}
		
	}
	/**
	 * @return the giaThanh
	 */
	public float getGiaThanh() {
		return gia;
	}
	/**
	 * @param giaThanh the giaThanh to set
	 */
	public void setGiaThanh(float giaThanh) {
		this.gia = giaThanh;
	}
	
	//constructor
	public CD(String maCD, String tuaCD, int soBai, float gia, String caSy) {
		this.maCD = maCD;
		this.tuaCD = tuaCD;
		this.caSy = caSy;
		this.soBaiHat = soBai;
		this.gia = gia;
	}
	
	public CD() {
		
	}

	public static void tieuDe() {
		System.out.println("In danh sach CD");
		for (int i=0 ; i<100; i++) {
			System.out.print("-");
		}
		System.out.println();
		String s = String.format(
	            "|%-10s|%-10s|%-10s|%-10s|%-10s|%-10s|",
	            "Ma CD", "Tua CD", "Ca Sy",
	            "So Bai", "Don Gia", "Thanh Tien");
	    System.out.println(s);
		for (int i=0 ; i<100; i++) {
			System.out.print("-");
		}
		System.out.println();
	}
	@Override
	public String toString() {
		return String.format(
	            "|%-10s|%-10s|%-10s|%-10d|%-10.2f|%-10.2f|",
	            maCD, tuaCD, caSy, soBaiHat, gia, gia * soBaiHat);
	}
	
	public static void main(String[] args) {
		tieuDe();
	}
	
}
