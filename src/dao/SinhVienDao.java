package dao;

import connect.DBConnect;
import model.SinhVien;

import java.sql.*;
import java.util.ArrayList;

public class SinhVienDao {
public ArrayList<SinhVien> search(String keyword) {

    ArrayList<SinhVien> list = new ArrayList<>();

    try {

        Connection conn = DBConnect.getConnection();

        String sql =
            "SELECT * FROM SinhVien WHERE HoTen LIKE ? OR Lop LIKE ?";

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, "%" + keyword + "%");
        ps.setString(2, "%" + keyword + "%");

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            SinhVien sv = new SinhVien();

            sv.setMaSV(rs.getInt("MaSV"));
            sv.setHoTen(rs.getString("HoTen"));
            sv.setLop(rs.getString("Lop"));
            sv.setNamSinh(rs.getInt("NamSinh"));
            sv.setSdt(rs.getString("SDT"));

            list.add(sv);
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return list;
}
    public ArrayList<SinhVien> getAll() {

        ArrayList<SinhVien> list = new ArrayList<>();

        try {

            Connection conn = DBConnect.getConnection();

            String sql = "SELECT * FROM SinhVien";

            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                SinhVien sv = new SinhVien();

                sv.setMaSV(rs.getInt("MaSV"));
                sv.setHoTen(rs.getString("HoTen"));
                sv.setLop(rs.getString("Lop"));
                sv.setNamSinh(rs.getInt("NamSinh"));
                sv.setSdt(rs.getString("SDT"));

                list.add(sv);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public boolean insert(SinhVien sv) {

        try {

            Connection conn = DBConnect.getConnection();

            String sql =
                "INSERT INTO SinhVien(HoTen,Lop,NamSinh,SDT) VALUES(?,?,?,?)";

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ps.setString(1, sv.getHoTen());
            ps.setString(2, sv.getLop());
            ps.setInt(3, sv.getNamSinh());
            ps.setString(4, sv.getSdt());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean update(SinhVien sv) {

        try {

            Connection conn = DBConnect.getConnection();

            String sql =
                "UPDATE SinhVien SET HoTen=?, Lop=?, NamSinh=?, SDT=? WHERE MaSV=?";

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ps.setString(1, sv.getHoTen());
            ps.setString(2, sv.getLop());
            ps.setInt(3, sv.getNamSinh());
            ps.setString(4, sv.getSdt());
            ps.setInt(5, sv.getMaSV());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean delete(int maSV) {

        try {

            Connection conn = DBConnect.getConnection();

            String sql =
                "DELETE FROM SinhVien WHERE MaSV=?";

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ps.setInt(1, maSV);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}