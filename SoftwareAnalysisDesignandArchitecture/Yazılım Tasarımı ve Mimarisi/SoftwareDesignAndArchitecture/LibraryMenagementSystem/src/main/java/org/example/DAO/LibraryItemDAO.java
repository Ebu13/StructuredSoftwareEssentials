package org.example.DAO;

import org.example.Core.Database;
import org.example.Entity.LibraryItemDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LibraryItemDAO {
    private Connection connection;

    public LibraryItemDAO() {
        this.connection = Database.getInstance();
    }

    public List<LibraryItemDto> getLibraryItems() {
        List<LibraryItemDto> items = new ArrayList<>();
        String query = "SELECT li.id, li.title, li.available, li.item_type, li.barcode, li.page_count " +
                "FROM LibraryItem li";

        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");  // id'yi int olarak alıyoruz
                String title = rs.getString("title");
                boolean available = rs.getBoolean("available");
                String itemType = rs.getString("item_type");
                String barcode = rs.getString("barcode");
                int pageCount = rs.getInt("page_count");

                // Türüne göre özel alanı almak
                String specialAttribute = null;
                if ("Book".equals(itemType)) {
                    specialAttribute = getBookAuthor(id);  // id'yi int olarak gönderiyoruz
                } else if ("DVD".equals(itemType)) {
                    specialAttribute = getDVDDirector(id);  // id'yi int olarak gönderiyoruz
                } else if ("Magazine".equals(itemType)) {
                    specialAttribute = getMagazinePublisher(id);  // id'yi int olarak gönderiyoruz
                }

                LibraryItemDto itemDto = new LibraryItemDto(String.valueOf(id), title, available, itemType, barcode, pageCount, specialAttribute);
                items.add(itemDto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;
    }

    private String getBookAuthor(int id) throws SQLException {  // id artık int türünde
        String query = "SELECT author FROM Book WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);  // id'yi int olarak gönderiyoruz
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getString("author");
            }
        }
        return null;
    }

    private String getDVDDirector(int id) throws SQLException {  // id artık int türünde
        String query = "SELECT director FROM DVD WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);  // id'yi int olarak gönderiyoruz
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getString("director");
            }
        }
        return null;
    }

    private String getMagazinePublisher(int id) throws SQLException {  // id artık int türünde
        String query = "SELECT publisher FROM Magazine WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);  // id'yi int olarak gönderiyoruz
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getString("publisher");
            }
        }
        return null;
    }

    public LibraryItemDto getLibraryItemByBarcode(String barcode) {
        LibraryItemDto item = null;
        String query = "SELECT li.id, li.title, li.available, li.item_type, li.barcode, li.page_count " +
                "FROM LibraryItem li WHERE li.barcode = ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, barcode);  // Barkodu alıyoruz
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int id = rs.getInt("id");
                    String title = rs.getString("title");
                    boolean available = rs.getBoolean("available");
                    String itemType = rs.getString("item_type");
                    String itemBarcode = rs.getString("barcode");
                    int pageCount = rs.getInt("page_count");

                    // Türüne göre özel alanı almak
                    String specialAttribute = null;
                    if ("Book".equals(itemType)) {
                        specialAttribute = getBookAuthor(id);
                    } else if ("DVD".equals(itemType)) {
                        specialAttribute = getDVDDirector(id);
                    } else if ("Magazine".equals(itemType)) {
                        specialAttribute = getMagazinePublisher(id);
                    }

                    item = new LibraryItemDto(String.valueOf(id), title, available, itemType, itemBarcode, pageCount, specialAttribute);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return item;
    }

}
