import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseHelper {
    private static final String URL = "jdbc:mysql://localhost:3306/ql_laodong?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void luuNhanVien(NhanVien nv) {
        String sql = "INSERT INTO nguoi_lao_dong (ma_ld, ho_ten, nam_sinh, luong_co_ban, loai_ld, chuc_vu, he_so_phu_cap) "
                   + "VALUES (?, ?, ?, ?, 'NHAN_VIEN', ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nv.getMaLD());
            pstmt.setString(2, nv.getHoTen());
            pstmt.setString(3, nv.getNamSinh());
            pstmt.setDouble(4, nv.getLuongCoBan());
            pstmt.setString(5, nv.getChucVu());
            pstmt.setDouble(6, nv.getHeSoPhuCap());

            pstmt.executeUpdate();
            System.out.println(">> Da luu nhan vien vao CSDL thanh cong!");
        } catch (SQLException e) {
            System.err.println("Loi khi luu Nhan vien: " + e.getMessage());
        }
    }

    public static void luuGiangVien(GiangVien gv) {
        String sql = "INSERT INTO nguoi_lao_dong (ma_ld, ho_ten, nam_sinh, luong_co_ban, loai_ld, trinh_do, so_tiet_day, don_gia_tiet) "
                   + "VALUES (?, ?, ?, ?, 'GIANG_VIEN', ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, gv.getMaLD());
            pstmt.setString(2, gv.getHoTen());
            pstmt.setString(3, gv.getNamSinh());
            pstmt.setDouble(4, gv.getLuongCoBan());
            pstmt.setString(5, gv.getTrinhDo());
            pstmt.setInt(6, gv.getSoTietDay());
            pstmt.setDouble(7, gv.getDonGiaTiet());

            pstmt.executeUpdate();
            System.out.println(">> Da luu giang vien vao CSDL thanh cong!");
        } catch (SQLException e) {
            System.err.println("Loi khi luu Giang vien: " + e.getMessage());
        }
    }

    // Luu Quản lý vao CSDL
    public static void luuQuanLy(QuanLy ql) {
        String sql = "INSERT INTO nguoi_lao_dong (ma_ld, ho_ten, nam_sinh, luong_co_ban, loai_ld, chuc_vu_ql, phu_cap_tn) "
                   + "VALUES (?, ?, ?, ?, 'QUAN_LY', ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, ql.getMaLD());
            pstmt.setString(2, ql.getHoTen());
            pstmt.setString(3, ql.getNamSinh());
            pstmt.setDouble(4, ql.getLuongCoBan());
            pstmt.setString(5, ql.getChucVuQuanLy());
            pstmt.setDouble(6, ql.getPhuCapTrachNhiem());

            pstmt.executeUpdate();
            System.out.println(">> Da luu quan ly vao CSDL thanh cong!");
        } catch (SQLException e) {
            System.err.println("Loi khi luu Quan ly: " + e.getMessage());
        }
    }

    public static void hienThiDanhSach() {
        String sql = "SELECT * FROM nguoi_lao_dong";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            System.out.println("\n=== DANH SACH NGUOI LAO DONG TRONG CSDL ===");
            while (rs.next()) {
                String ma = rs.getString("ma_ld");
                String ten = rs.getString("ho_ten");
                String loai = rs.getString("loai_ld");
                double luongCB = rs.getDouble("luong_co_ban");

                if ("NHAN_VIEN".equalsIgnoreCase(loai)) {
                    String chucVu = rs.getString("chuc_vu");
                    double phuCap = rs.getDouble("he_so_phu_cap");
                    double tongLuong = luongCB + (luongCB * phuCap);
                    System.out.printf("[Nhan Vien] Ma: %s | Ten: %s | Chuc vu: %s | Luong: %.2f\n", 
                            ma, ten, chucVu, tongLuong);
                } else if ("GIANG_VIEN".equalsIgnoreCase(loai)) {
                    String trinhDo = rs.getString("trinh_do");
                    int soTiet = rs.getInt("so_tiet_day");
                    double donGia = rs.getDouble("don_gia_tiet");
                    double tongLuong = luongCB + (soTiet * donGia);
                    System.out.printf("[Giang Vien] Ma: %s | Ten: %s | Trinh do: %s | Luong: %.2f\n", 
                            ma, ten, trinhDo, tongLuong);
                } else if ("QUAN_LY".equalsIgnoreCase(loai)) {
                    String chucVuQL = rs.getString("chuc_vu_ql");
                    double phuCapTN = rs.getDouble("phu_cap_tn");
                    double tongLuong = luongCB + phuCapTN;
                    System.out.printf("[Quan Ly]   Ma: %s | Ten: %s | Chuc vu: %s | Luong: %.2f\n", 
                            ma, ten, chucVuQL, tongLuong);
                }
            }
        } catch (SQLException e) {
            System.err.println("Loi khi lay danh sach: " + e.getMessage());
        }
    }
}