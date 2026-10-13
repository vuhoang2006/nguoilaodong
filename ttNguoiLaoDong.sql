CREATE DATABASE IF NOT EXISTS ql_laodong DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE ql_laodong;

CREATE TABLE IF NOT EXISTS nguoi_lao_dong (
    ma_ld VARCHAR(20) PRIMARY KEY,
    ho_ten VARCHAR(100) NOT NULL,
    nam_sinh VARCHAR(10),
    luong_co_ban DOUBLE NOT NULL,
    loai_ld VARCHAR(20) NOT NULL, -- 'NHAN_VIEN', 'GIANG_VIEN' hoac 'QUAN_LY'
    
    -- Thuoc tinh NhanVien
    chuc_vu VARCHAR(50) DEFAULT NULL,
    he_so_phu_cap DOUBLE DEFAULT 0,
    
    -- Thuoc tinh GiangVien
    trinh_do VARCHAR(50) DEFAULT NULL,
    so_tiet_day INT DEFAULT 0,
    don_gia_tiet DOUBLE DEFAULT 0,
    
    -- Thuoc tinh QuanLy
    chuc_vu_ql VARCHAR(50) DEFAULT NULL,
    phu_cap_tn DOUBLE DEFAULT 0
);