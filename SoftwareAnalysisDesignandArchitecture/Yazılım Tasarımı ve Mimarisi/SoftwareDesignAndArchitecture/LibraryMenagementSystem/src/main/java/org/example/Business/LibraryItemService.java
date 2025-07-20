package org.example.Business;


import org.example.DAO.LibraryItemDAO;
import org.example.Entity.LibraryItemDto;

import java.util.List;

public class LibraryItemService {
    private LibraryItemDAO libraryItemDAO;

    public LibraryItemService() {
        this.libraryItemDAO = new LibraryItemDAO();
    }

    public List<LibraryItemDto> getLibraryItems() {
        return libraryItemDAO.getLibraryItems();
    }
    public LibraryItemDto getLibraryItemByBarcode(String barcode) {
        return libraryItemDAO.getLibraryItemByBarcode(barcode);
    }


}
