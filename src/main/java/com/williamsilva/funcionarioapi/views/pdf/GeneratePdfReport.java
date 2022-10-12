package com.williamsilva.funcionarioapi.views.pdf;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.williamsilva.funcionarioapi.domain.dto.EtiquetaDto;

import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class GeneratePdfReport {

    public static ByteArrayInputStream generateEtiqueta(EtiquetaDto etiquetaDto) {

        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(100);
        table.getDefaultCell().setMinimumHeight(25);
        table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
        table.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.getDefaultCell().setBackgroundColor(Color.lightGray);

        table.addCell("Nome");
        table.addCell("E-mail");

        table.getDefaultCell().setBackgroundColor(Color.WHITE);

        table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(etiquetaDto.getNome());

        table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
        table.addCell(etiquetaDto.getEmail());

        PdfWriter.getInstance(document, out);
        document.open();
        document.add(table);

        document.close();

        return new ByteArrayInputStream(out.toByteArray());
    }
}
