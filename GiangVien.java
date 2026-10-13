import java.util.Scanner;

public class GiangVien extends NguoiLaoDong {
    private String trinhDo;
    private int soTietDay;
    private double donGiaTiet;

    public GiangVien() {
        super();
    }

    public GiangVien(String maLD, String hoTen, String namSinh, double luongCoBan, String trinhDo, int soTietDay, double donGiaTiet) {
        super(maLD, hoTen, namSinh, luongCoBan);
        this.trinhDo = trinhDo;
        this.soTietDay = soTietDay;
        this.donGiaTiet = donGiaTiet;
    }

    public String getTrinhDo() { return trinhDo; }
    public int getSoTietDay() { return soTietDay; }
    public double getDonGiaTiet() { return donGiaTiet; }

    @Override
    public void nhapThongTin(Scanner sc) {
        super.nhapThongTin(sc);
        System.out.print("Nhap trinh do (Thac si/Tien si/...): ");
        this.trinhDo = sc.nextLine();
        System.out.print("Nhap so tiet day: ");
        this.soTietDay = Integer.parseInt(sc.nextLine());
        System.out.print("Nhap don gia moi tiet: ");
        this.donGiaTiet = Double.parseDouble(sc.nextLine());
    }

    @Override
    public double tinhLuong() {
        return this.luongCoBan + (this.soTietDay * this.donGiaTiet);
    }

    @Override
    public void hienThiThongTin() {
        super.hienThiThongTin();
        System.out.printf(" | Trinh do: %s | So tiet: %d | Tong luong: %.2f\n", 
                trinhDo, soTietDay, tinhLuong());
    }
}