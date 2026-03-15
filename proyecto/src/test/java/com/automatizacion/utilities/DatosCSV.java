package com.automatizacion.utilities;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class DatosCSV {
    public static Object[][] readCSV(String filePath) throws IOException, CsvException {
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            List<String[]> allRows = reader.readAll();
            // Skip header row (index 0), same convention as DatosExcel
            int rows = allRows.size() - 1;
            int cols = allRows.get(0).length;
            Object[][] data = new Object[rows][cols];
            for (int i = 1; i <= rows; i++) {
                String[] row = allRows.get(i);
                for (int j = 0; j < cols; j++) {
                    data[i - 1][j] = row[j];
                }
            }
            return data;
        }
    }
}
