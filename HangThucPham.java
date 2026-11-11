package Tuan3.BaiThucPham;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.text.DecimalFormat;
public class HangThucPham {
	//Khai báo biến
	private int id;
	private String maHang;
    private String tenHang;
    private double donGia;
    private LocalDate ngaySanXuat;
    private LocalDate ngayHetHan;
    private static int demSoLuong = 0;
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final DecimalFormat CURRENCY_FORMATTER = new DecimalFormat("#,##0.00'VND'");
    
	public static void main(String[] args) {
		HangThucPham h1 = new HangThucPham(
		        1,
		        "001",
		        "Gạo",
		        100000,
		        LocalDate.of(2026, 8, 1),
		        LocalDate.of(2026, 10, 7)
		);

		HangThucPham h2 = new HangThucPham(
		        2,
		        "002",
		        "Mì",
		        5000,
		        LocalDate.of(2026, 1, 3),
		        LocalDate.of(2026, 9, 1)
		);

		HangThucPham h3 = new HangThucPham(
		        3,
		        "003",
		        "Nước",
		        10000,
		        LocalDate.of(2026, 3, 1),
		        LocalDate.of(2026, 12, 1)
		);
	    // Xuất thông tin
	    System.out.println("Mã_Hàng   Tên_Hàng       Đơn_Giá          Ngày_Sản_Xuất   Ngày_Hết_Hạn   Ghi_Chú");
	    System.out.println("-------------------------------------------------------------------------------");

	    System.out.println(h1);
	    System.out.println(h2);
	    System.out.println(h3);

	    // =========================
	    // PHẦN f: KIỂM THỬ RÀNG BUỘC
	    // =========================

	    // 1. Mã hàng không được rỗng
	    try {
	        HangThucPham test1 = new HangThucPham("");
	        System.out.println(test1);
	    } catch (IllegalArgumentException e) {
	        System.out.println("\nTest mã hàng rỗng: " + e.getMessage());
	    }

	    // 2. Tên hàng rỗng
	    HangThucPham test2 = new HangThucPham("004");
	    test2.setTenHang("");
	    System.out.println("\nTest tên hàng rỗng:");
	    System.out.println("Tên hàng = " + test2.getTenHang());

	    // 3. Đơn giá âm
	    test2.setDonGia(-5000);
	    System.out.println("Test đơn giá âm: " + test2.getDonGia());

	    // 4. Ngày sản xuất trong tương lai
	    test2.setNgaySanXuat(LocalDate.now().plusDays(10));
	    System.out.println("Test ngày sản xuất tương lai: "
	            + test2.getNgaySanXuat().format(DATE_FORMATTER));

	    // 5. Ngày hết hạn trước ngày sản xuất
	    test2.setNgayHetHan(test2.getNgaySanXuat().minusDays(5));
	    System.out.println("Test ngày hết hạn trước ngày sản xuất: "
	            + test2.getNgayHetHan().format(DATE_FORMATTER));

	    // 6. Kiểm tra hết hạn
	    System.out.println("Test hết hạn h1: " + h1.daHetHan());
	    System.out.println("Test hết hạn h2: " + h2.daHetHan());
	    System.out.println("Test hết hạn h3: " + h3.daHetHan());

	}
	//Đóng gói 
	public String getMaHang() {
		return maHang;
	}

	public void setMaHang(String maHang) {
		this.maHang = maHang;
	}

	public String getTenHang() {
		return tenHang;
	}

	public void setTenHang(String tenHang) {
		if (tenHang != null && !tenHang.trim().isEmpty()) {
            this.tenHang = tenHang;
        } else {
            this.tenHang = "xxx";
        }
	}
	
	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		if (donGia >= 0) {
            this.donGia = donGia;
        } else {
            this.donGia = 0;
        }
	}

	public LocalDate getNgaySanXuat() {
		return ngaySanXuat;
	}

	public void setNgaySanXuat(LocalDate ngaySanXuat) {
		if (ngaySanXuat != null && ngaySanXuat.isBefore(LocalDate.now())) {
            this.ngaySanXuat = ngaySanXuat;
        } else {
            this.ngaySanXuat = LocalDate.now();
        }
        if (this.ngayHetHan != null && this.ngayHetHan.isBefore(this.ngaySanXuat)) {
            this.ngayHetHan = this.ngaySanXuat;
        }
	}

	public LocalDate getNgayHetHan() {
		return ngayHetHan;
	}

	public void setNgayHetHan(LocalDate ngayHetHan) {
		if (ngayHetHan != null && 
		        this.ngaySanXuat != null &&
		        ngayHetHan.isAfter(this.ngaySanXuat)) {
		        
		        this.ngayHetHan = ngayHetHan;
		    } else {
		        this.ngayHetHan = this.ngaySanXuat;
		    }
	}
	public HangThucPham(String maHang) {
        if (maHang == null || maHang.trim().isEmpty()) {
            throw new IllegalArgumentException("Mã hàng không được để rỗng!");
        }
        this.maHang = maHang;
        this.tenHang = "xxx";
        this.donGia = 0;
        this.ngaySanXuat = LocalDate.now();
        this.ngayHetHan = this.ngaySanXuat;
	}
	
	public HangThucPham(int id, String maHang, String tenHang, double donGia, LocalDate ngaySanXuat, LocalDate ngayHetHan) {
		if (maHang == null || maHang.trim().isEmpty()) {
			throw new IllegalArgumentException("Mã hàng không được để trống!");
		}
		this.id = ++demSoLuong;
		this.maHang =  maHang;
		setTenHang(tenHang);
        setDonGia(donGia);
        setNgaySanXuat(ngaySanXuat);
        setNgayHetHan(ngayHetHan);
	}

	public boolean daHetHan() {
        return !LocalDate.now().isBefore(ngayHetHan);
    }
	
	public String toString() {
        String ghiChu = daHetHan() ? "Hàng hết hạn" : "";
        return String.format("%-10s %-12s %20s   %-15s %-15s %s",
                maHang,
                tenHang,
                CURRENCY_FORMATTER.format(donGia),
                ngaySanXuat.format(DATE_FORMATTER),
                ngayHetHan.format(DATE_FORMATTER),
                ghiChu);
    }
	
}
