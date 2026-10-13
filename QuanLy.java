import java.util.Scanner;

public class QuanLy extends NguoiLaoDong {
    private String chucVuQuanLy;
    private double phuCapTrachNhiem;

    public QuanLy() {
        super();
    }

    public QuanLy(String maLD, String hoTen, String namSinh, double luongCoBan, String chucVuQuanLy, double phuCapTrachNhiem) {
        super(maLD, hoTen, namSinh, luongCoBan);
        this.chucVuQuanLy = chucVuQuanLy;
        this.phuCapTrachNhiem = phuCapTrachNhiem;
    }

    public String getChucVuQuanLy() { return chucVuQuanLy; }
    public double getPhuCapTrachNhiem() { return phuCapTrachNhiem; }

    @Override
    public void nhapThongTin(Scanner sc) {
        super.nhapThongTin(sc);
        System.out.print("Nhap chuc vu quan ly (Truong phong/Giam doc/...): ");
        this.chucVuQuanLy = sc.nextLine();
        System.out.print("Nhap phu cap trach nhiem: ");
        this.phuCapTrachNhiem = Double.parseDouble(sc.nextLine());
    }

    @Override
    public double tinhLuong() {
        return this.luongCoBan + this.phuCapTrachNhiem;
    }

    @Override
    public void hienThiThongTin() {
        super.hienThiThongTin();
        System.out.printf(" | Chuc vu QL: %s | Phu cap TN: %.2f | Tong luong: %.2f\n", 
                chucVuQuanLy, phuCapTrachNhiem, tinhLuong());
    }
}