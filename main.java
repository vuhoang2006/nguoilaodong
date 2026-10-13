import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QuanLyLaoDong ql = new QuanLyLaoDong();

        while (true) {
            System.out.println("\n--- CHUONG TRINH QUAN LY NGUOI LAO DONG ---");
            System.out.println("1. Them Nhan Vien");
            System.out.println("2. Them Giang Vien");
            System.out.println("3. Them Quan Ly");
            System.out.println("4. Hien thi danh sach");
            System.out.println("0. Thoat");
            System.out.print("Chon chuc nang: ");

            int chon = Integer.parseInt(sc.nextLine());
            switch (chon) {
                case 1:
                    NhanVien nv = new NhanVien();
                    nv.nhapThongTin(sc);
                    ql.themLaoDong(nv);
                    break;
                case 2:
                    GiangVien gv = new GiangVien();
                    gv.nhapThongTin(sc);
                    ql.themLaoDong(gv);
                    break;
                case 3:
                    QuanLy qly = new QuanLy();
                    qly.nhapThongTin(sc);
                    ql.themLaoDong(qly);
                    break;
                case 4:
                    ql.hienThiDanhSach();
                    break;
                case 0:
                    System.out.println("Da thoat.");
                    return;
                default:
                    System.out.println("Chon khong hop le!");
            }
        }
    }
}