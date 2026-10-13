import java.util.Scanner;

public class NguoiLaoDong {
    protected String maLD;
    protected String hoTen;
    protected String namSinh;
    protected double luongCoBan;

    public NguoiLaoDong() {}

    public NguoiLaoDong(String maLD, String hoTen, String namSinh, double luongCoBan) {
        this.maLD = maLD;
        this.hoTen = hoTen;
        this.namSinh = namSinh;
        this.luongCoBan = luongCoBan;
    }

    public String getMaLD() { return maLD; }
    public void setMaLD(String maLD) { this.maLD = maLD; }

    public String getHoTen() { return hoTen; }
    public void setHoTen(String hoTen) { this.hoTen = hoTen; }

    public String getNamSinh() { return namSinh; }
    public void setNamSinh(String namSinh) { this.namSinh = namSinh; }

    public double getLuongCoBan() { return luongCoBan; }
    public void setLuongCoBan(double luongCoBan) { this.luongCoBan = luongCoBan; }

    public void nhapThongTin(Scanner sc) {
        System.out.print("Nhap ma lao dong: ");
        this.maLD = sc.nextLine();
        System.out.print("Nhap ho ten: ");
        this.hoTen = sc.nextLine();
        System.out.print("Nhap nam sinh: ");
        this.namSinh = sc.nextLine();
        System.out.print("Nhap luong co ban: ");
        this.luongCoBan = Double.parseDouble(sc.nextLine());
    }

    public double tinhLuong() {
        return this.luongCoBan;
    }

    public void hienThiThongTin() {
        System.out.printf("Ma LD: %s | Ho ten: %s | Nam sinh: %s | Luong co ban: %.2f", 
                maLD, hoTen, namSinh, luongCoBan);
    }
}