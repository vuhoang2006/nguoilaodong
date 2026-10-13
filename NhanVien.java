import java.util.Scanner;

public class NhanVien extends NguoiLaoDong {
    private String chucVu;
    private double heSoPhuCap;

    public NhanVien() {
        super();
    }

    public NhanVien(String maLD, String hoTen, String namSinh, double luongCoBan, String chucVu, double heSoPhuCap) {
        super(maLD, hoTen, namSinh, luongCoBan);
        this.chucVu = chucVu;
        this.heSoPhuCap = heSoPhuCap;
    }

    public String getChucVu() { return chucVu; }
    public double getHeSoPhuCap() { return heSoPhuCap; }

    @Override
    public void nhapThongTin(Scanner sc) {
        super.nhapThongTin(sc);
        System.out.print("Nhap chuc vu: ");
        this.chucVu = sc.nextLine();
        System.out.print("Nhap he so phu cap: ");
        this.heSoPhuCap = Double.parseDouble(sc.nextLine());
    }

    @Override
    public double tinhLuong() {
        return this.luongCoBan + (this.luongCoBan * this.heSoPhuCap);
    }

    @Override
    public void hienThiThongTin() {
        super.hienThiThongTin();
        System.out.printf(" | Chuc vu: %s | Phu cap: %.2f | Tong luong: %.2f\n", 
                chucVu, heSoPhuCap, tinhLuong());
    }
}