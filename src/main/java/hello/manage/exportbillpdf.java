package hello.manage;
import hello.Ifuser;
import hello.book.*;

import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfTable;
import com.lowagie.text.pdf.PdfWriter;

public class exportbillpdf extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		@SuppressWarnings("unchecked")
		List<Orders> order= (List<Orders>) model.get("orderlist");
		Ifuser user= (Ifuser) model.get("user");
		PdfPTable table= new PdfPTable(5);
		table.setWidths(new int[] {1,5,3,2,3});
		table.addCell("STT");
		table.addCell("Ten mon an");
		table.addCell("Gia");
		table.addCell("So luong");
		table.addCell("thanh tien");
		int stt=0;
		double tong=0;
		for(Orders each:order) {
			stt++;
			table.addCell(String.valueOf(stt));
			table.addCell(each.getFood_id().getName());
			table.addCell(String.valueOf(each.getFood_id().getPrice()));
			table.addCell(String.valueOf(each.getValue()));
			table.addCell(String.valueOf(each.getFood_id().getPrice()*each.getValue()));
			tong+=(each.getFood_id().getPrice()*each.getValue());
		}
		/*PdfWriter.getInstance(document,new FileOutputStream("bill.pdf"));
		document.open();*/
		Paragraph p = new Paragraph("Hoa don ban le \n\n");	
		p.setAlignment(Element.ALIGN_CENTER);
		document.add(p);
		Paragraph p1= new Paragraph("               Tong:       " + String.valueOf(tong));
		Paragraph name= new Paragraph("               Ten khach hang:       " + user.getName());
		Paragraph phone= new Paragraph("               So dien thoai:       " + user.getPhone()+"\n\n");
		document.add(name);
		document.add(phone);
		document.add(table);
		document.add(p1);
		/*document.close();*/
	}

}
