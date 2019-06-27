package jcucumberng.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

/**
 * {@code FileUtil} handles actions for manipulating files or documents.
 * 
 */
public final class FileUtil {

	private FileUtil() {
		// No instantiation
	}

	/**
	 * Checks if a file exists in a specified directory.
	 * 
	 * @param dirPath absolute path to directory
	 * @param prefix  the beginning of a filename, can be a substring
	 * @param suffix  can be the file extension (e.g. {@code .txt})
	 * @return boolean - true if matching file is found using given prefix and
	 *         suffix
	 */
	public static boolean doesFileExist(String dirPath, String prefix, String suffix) {
		File[] files = new File(dirPath).listFiles();

		String fileName = null;
		for (File file : files) {
			if (file.isFile()) {
				fileName = file.getName();
				if (fileName.startsWith(prefix)) {
					if (fileName.endsWith(suffix)) {
						return true;
					}
				}
			}
		}

		return false;
	}

	/**
	 * Extracts readable text from a specified PDF file.
	 * 
	 * @param filePath absolute path to PDF file
	 * @return String - extracted text from PDF file
	 * @throws IOException
	 */
	public static String extractPdfText(String filePath) throws IOException {
		PdfReader pdfReader = new PdfReader(filePath);
		int pages = pdfReader.getNumberOfPages();

		StringBuilder builder = new StringBuilder();
		// Page number cannot be 0 or will throw NPE
		for (int ctr = 1; ctr < pages + 1; ctr++) {
			builder.append(PdfTextExtractor.getTextFromPage(pdfReader, ctr));
		}

		pdfReader.close();
		return builder.toString();
	}

	/**
	 * Converts an Excel file (xlsx only) to a 2D array. The xlsx can have 1 header
	 * row. If no header row is present, begin data on second row. Else, data in the
	 * first row will be omitted. Each row must have the same number of columns.
	 * Each column must have a value.
	 * 
	 * @param xlsxFilePath the absolute path of the xlsx file
	 * @param sheetName    the name of the sheet to be read (defaults to first sheet
	 *                     if blank)
	 * @return Object[ ][ ] - the String values in 2D array
	 * @throws IOException
	 */
	public static Object[][] convertExcelTo2DArray(String xlsxFilePath, String sheetName) throws IOException {
		File xlsxFile = new File(xlsxFilePath);
		InputStream inputStream = new FileInputStream(xlsxFile);
		String[][] testData = null;

		try (XSSFWorkbook workbook = new XSSFWorkbook(inputStream)) {
			XSSFSheet sheet = null;
			if (StringUtils.isBlank(sheetName)) {
				sheet = workbook.getSheetAt(0); // Default to first sheet
			} else {
				sheet = workbook.getSheet(sheetName);
			}

			int totalRows = sheet.getLastRowNum(); // Remove header row
			int totalColumns = FileUtil.getColumnCount(sheet);
			testData = new String[totalRows][totalColumns];

			int rowIndex = 0;
			int columnIndex = 0;
			DataFormatter dataFormatter = new DataFormatter();

			// Iterate each row
			Row row = null;
			Cell cell = null;
			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext()) {
				row = rowIterator.next();

				// Skip first row
				if (0 == row.getRowNum())
					continue;

				// Iterate each cell in row
				Iterator<Cell> cellIterator = row.iterator();
				while (cellIterator.hasNext()) {
					cell = cellIterator.next();

					// Format cell value to String
					testData[rowIndex][columnIndex] = StringUtils.trim(dataFormatter.formatCellValue(cell));

					columnIndex++;

					// Reset columnIndex after complete iteration of row
					if (totalColumns == columnIndex) {
						columnIndex = 0;
					}
				}

				rowIndex++;
			}
		} finally {
			inputStream.close();
		}

		return testData;
	}

	/**
	 * Returns the largest number of non-empty columns among all rows.
	 * 
	 * @param sheet the sheet from the xlsx file
	 * @return int - the number of columns
	 */
	private static int getColumnCount(XSSFSheet sheet) {
		int largestColumnNumber = 0;
		int currentColumnNumber = 0;

		Row row = null;
		Iterator<Row> rowIterator = sheet.iterator();
		while (rowIterator.hasNext()) {
			row = rowIterator.next();

			currentColumnNumber = row.getLastCellNum();
			if (currentColumnNumber > largestColumnNumber) {
				largestColumnNumber = currentColumnNumber;
			}
		}

		return largestColumnNumber;
	}

}
